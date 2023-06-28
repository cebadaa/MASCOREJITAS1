(function(){
    var listaBotonesEditar = document.querySelectorAll(".editarPedido");
    listaBotonesEditar.forEach(item =>{
        item.addEventListener("click", e =>{
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('cboCliente').value = item.dataset.cliente;
            new bootstrap.Modal(document.getElementById('modalEditarP')).show();
        });
    });
})();