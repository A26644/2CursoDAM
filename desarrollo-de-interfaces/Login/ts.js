function validar() {
    var usuario = document.getElementById("usuario").value;
    var pass = document.getElementById("pass").value;
    var mensaje = "";
    if (usuario === '' || pass === '') {
        mensaje = "Debes completar los campos";
    }
    document.getElementById("msj").innerHTML = mensaje;
}
