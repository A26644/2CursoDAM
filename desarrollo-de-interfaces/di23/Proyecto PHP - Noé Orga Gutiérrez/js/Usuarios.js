
function buscarUsuarios(event) {
    event.preventDefault();
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
    // BUSCAR VALORES PARA LIMITAR EL PAGINADOR
    opciones = { method: "GET" };
    parametros = "controlador=Usuarios&metodo=countAllUsuarios";
    console.log("C_Ajax.php?" + parametros, opciones)
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => res.text())
        .then(res => {
            let paginaActual = document.getElementById("paginaActual");
            let numUsuariosPP = document.getElementById("numeroUsuariosPorPagina").value;
            let numeroPaginasTotales = Math.ceil(res / numUsuariosPP);
            paginaActual.setAttribute("max", numeroPaginasTotales);

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
            if (res === "ADDED") {
                // console.log(res.text())
                document.getElementById("resultadoInsert").innerHTML = "Usuario insertado";
            } else if (res === 'UPDATED'){
                document.getElementById("resultadoInsert").innerHTML = "Usuario modificado";
            } else {
                document.getElementById("resultadoInsert").innerHTML = "Error al hacer la peticion";

            }
        })

        .catch(err => {
                console.log(res.text())
            console.log("Error al realizar la petición", err.message);
            document.getElementById("resultadoInsert").innerHTML = "Usuario no insertado";
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
                buscarUsuarios(event);
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
            getVistaMenuSeleccionado('Usuarios', 'getVistaIntroducirUsuarios');
            await new Promise(r => setTimeout(r, 100));
            let email = document.getElementById("introducirEmail")
            let login = document.getElementById("introducirLogin")
            let nombre =document.getElementById("introducirNombre")
            let apellido1 = document.getElementById("IntroducirApellido1")
            let apellido2 = document.getElementById("IntroducirApellido2")
            let sexo = document.getElementById("Sex")
            apellido1.removeAttribute('required')
            apellido2.removeAttribute('required')
            email.value = res[0].mail
            login.value = res[0].login
            nombre.value = res[0].nombre
            apellido1.value = res[0].apellido_1
            apellido2.value = res[0].apellido_2
            sexo.value = res[0].sexo
            localStorage.setItem("id", res[0].id_Usuario)
            let form = document.getElementById("introducirUsuario")
        })
        .catch(err => {
            console.log("Error al realizar la petición", err.message);
        });
}
function modificarPagina(accion) {
    let formulario = document.getElementById("formularioBuscar")
    paginador = document.getElementById("paginaActual")
    let valorMax= paginador.getAttribute("max");
    if (formulario.checkValidity()) {
            switch (accion) {
                case '<<':
                    paginador.value = 1;
                    break;
                case '<':
                    if (paginador.value > 1) {
                        paginador.value--;

                    }
                    break;
                case '>':
                    console.log("estoy comparando " +paginador.value + "")
                    if (paginador.value < valorMax) {
                        console.log("subiendo de valor")
                        paginador.value++;
                    }
                    break;
                case '>>':
                    paginador.value = valorMax;
                    break;
            }
        }
}
function resetearPagina() {
    paginador = document.getElementById("paginaActual")
    paginador.value = 1
}
