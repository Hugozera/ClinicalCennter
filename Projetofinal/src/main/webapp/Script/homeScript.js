
function toggleMenu() {
    let menu = document.getElementById("menu");
    let menuToggle = document.getElementsByClassName("menu-toggle")[0];

    if (menu.style.left === "-250px") {
        menu.style.left = "0";
        menuToggle.innerHTML = '<i class="fas fa-times"></i> Fechar';
    } else {
        menu.style.left = "-250px";
        menuToggle.innerHTML = '<i class="fas fa-bars"></i> Menu';
    }
}
function formatar(mascara, documento) {
    var i = documento.value.length;
    var saida = mascara.substring(0, 1);
    var texto = mascara.substring(i);

    if (texto.substring(0, 1) != saida) {
        documento.value += texto.substring(0, 1);
    }

}

function editarPerfil() {
    var inputs = document.querySelectorAll("input:not(.readonly)");
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].readOnly = false;
    }
}