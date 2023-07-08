(function(){
    var listaBotonesEditar = document.querySelectorAll(".editarDetalle");
    listaBotonesEditar.forEach(item =>{
        item.addEventListener("click", e =>{
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('cboPedido').value = item.dataset.pedido;
            document.getElementById('cboProducto').value = item.dataset.producto;
            document.getElementById('txtCantidad').value = item.dataset.cantidad;
            document.getElementById('txtPrecio').value = item.dataset.precio;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        });
    });
})();