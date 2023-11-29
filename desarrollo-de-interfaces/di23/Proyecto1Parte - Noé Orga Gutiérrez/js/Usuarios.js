
function buscarUsuarios() {
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=buscarUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
    console.log("C_Ajax.php?" + parametros, opciones)
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
    console.log(parametros)
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => res.text())
        .then(res => {
            console.log(res)
            if (res == "okay") {
                document.getElementById("resultadoInsert").innerHTML = "Usuario insertado";
            } else {
                document.getElementById("resultadoInsert").innerHTML = "Usuario no insertado";
            }
        })

        .catch(err => {
            console.log("Error al realizar la petición", err.message);
            document.getElementById("resultadoInsert").innerHTML = "Usuario no insertado";
        });
}
function vistaEditarUsuario(id) {
    // CREAR LOS INPUTS

}
function editarUsuario(id) {

    console.log("Has entrado en el usuario con id: " + id)

    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=editarUsuario&modId=" + id;
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("introducirUsuario"))).toString();
    console.log(parametros)
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => res.text())
        .then(res => {
            console.log(res)
            if (res === "1") {
                alert("Usuario modificado correctamente")
            } else {
                alert("Usuario no modificado correctamente")
            }

        })

        .catch(err => {
            console.log("Error al realizar la petición", err.message);
        });

}
function eliminarUsuario(event, id) {
    console.log("eliminar usuario con id: " + id)
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=eliminarUsuario&remId=" + id;
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => res.text())
        .then(res => {
            console.log(res)
            if (res === "1") {
                alert("Usuario eliminado correctamente")
            } else {
                alert("Usuario no eliminado correctamente")
            }

        })

        .catch(err => {
            console.log("Error al realizar la petición", err.message);
        });


}
function cogerValores(id) {
    let arrayValores;
    console.log("Coger los valores al usuario con el id: " + id)
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=cargarValoresUsuario&editId=" + id;
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => res.json())
        .then(async res => {
            console.log(res)
            getVistaMenuSeleccionado('Usuarios', 'getVistaEditarUsuario')
            await new Promise(r => setTimeout(r, 100));
            document.getElementById("introducirEmail").value = res[0].mail
            document.getElementById("introducirLogin").value = res[0].login
            document.getElementById("introducirNombre").value = res[0].nombre
            document.getElementById("IntroducirApellido1").value = res[0].apellido_1
            document.getElementById("IntroducirApellido2").value = res[0].apellido_2
            document.getElementById("Sex").value = res[0].sexo
            localStorage.setItem("id", res[0].id_Usuario)
            let form = document.getElementById("introducirUsuario")
            form.addEventListener("submit", function (event) {
                event.preventDefault()
                editarUsuario(res[0].id_Usuario)
            })
        })

        .catch(err => {
            console.log("Error al realizar la petición", err.message);
        });
}
