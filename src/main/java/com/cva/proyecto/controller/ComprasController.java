package com.cva.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cva.proyecto.model.dao.IComprasDAO;
import com.cva.proyecto.model.entidad.Producto;
import com.cva.proyecto.model.service.ICarroService;
import com.cva.proyecto.model.service.ProductoService;

public class ComprasController {
    @Autowired
    private ICarroService carroService;

    @Autowired
    private IComprasDAO comprasDAO;

    @GetMapping("/agregar-al-carrito/{idProducto}")
    public String agregarAlCarrito(@PathVariable("idProducto") Long idProducto,
                                   @RequestParam("cantidad") int cantidad) {
        // Aquí puedes obtener el producto de la base de datos según el id
        Producto producto = comprasDAO.obtenerProductoPorId(idProducto);

        // Agregar el producto al carrito
        carroService.agregarProducto(producto, cantidad);

        return "redirect:/compras";
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model) {
        List<CarritoItem> carrito = carroService.obtenerCarrito();
        double total = carroService.calcularTotalCarrito();

        model.addAttribute("carrito", carrito);
        model.addAttribute("total", total);

        return "carrito";
    }

    @PostMapping("/realizar-compra")
    public String realizarCompra(@ModelAttribute("pedidoForm") PedidoForm pedidoForm) {
        // Crear un objeto Pedido a partir de los datos del formulario
        ComprasEntity pedido = new ComprasEntity();
        pedido.setFechaPedido(new Date());
        pedido.setCliente(pedidoForm.getCliente());
        pedido.setProductos(carroService.obtenerCarrito());

        // Guardar el pedido en la base de datos
        comprasDAO.guardarPedido(pedido);

        // Vaciar el carrito
        carroService.vaciarCarro();

        return "redirect:/dashboard/pedidos";
    }
}
