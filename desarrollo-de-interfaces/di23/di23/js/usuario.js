function buscarUsuarios() {
    let opciones = { method: "GET" };
    let parametros = "controlador=usuarios&metodo=buscarUsuario" + controlador + "&metodo=" + metodo;
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('respuesta ok');
                return res.text();
            }
        })
        .then(vista => {
            document.getElementById("capaResultadosBusqueda").innerHTML = vista;
        })
        .catch(err => {
            console.log("Error al realizar la petición", err.message);
        });
}