(function(){
    var listaBotonesEditar = document.querySelectorAll(".editarTrabajador");
    listaBotonesEditar.forEach(item =>{
        item.addEventListener("click", e =>{
            document.getElementById('txtNombre').value = item.dataset.nombre;
            document.getElementById('txtSalario').value = item.dataset.salario;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        });
    });
})();