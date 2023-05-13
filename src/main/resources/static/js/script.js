let arrow = document.querySelectorAll(".arrow");
for (var i = 0; i < arrow.length; i++) {
    arrow[i].addEventListener("click", (e)=>{
    let arrowParent = e.target.parentElement.parentElement;//selecting main parent of arrow
    arrowParent.classList.toggle("mostrar");
    });
}

let barra = document.querySelector(".barra");
let barraBtn = document.querySelector(".bx-menu");
console.log(barraBtn);
barraBtn.addEventListener("click", ()=>{
    barra.classList.toggle("cerrar");
});

function mostrarTabla(tabla) {
    var tablaPerrosContainer = document.getElementById("tablaperros");
    var tablaPanelContainer = document.getElementById("tablapanel");
    
    if (tabla === 'perros') {
        tablaPerrosContainer.style.display = "block";
        tablaPanelContainer.style.display = "none";
    } else if (tabla === 'panel') {
        tablaPerrosContainer.style.display = "none";
        tablaPanelContainer.style.display = "block";
    } else {
        tablaPerrosContainer.style.display = "none";
        tablaPanelContainer.style.display = "none";
    }
    }