
function buscarUsuarios() {
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=buscarUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
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
function introducirUsuarios(event) {
    event.preventDefault();
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=introducirUsuario";

    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("introducirUsuario"))).toString();
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            console.log(res)
            document.getElementById("resultadoInsert").innerHTML = "Usuario insertado";
        })

        .catch(err => {
            console.log("Error al realizar la petición", err.message);
            document.getElementById("resultadoInsert").innerHTML = "Usuario no insertado";
        });
}
