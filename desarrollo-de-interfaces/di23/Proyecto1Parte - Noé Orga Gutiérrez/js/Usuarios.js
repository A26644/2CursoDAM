
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
    let campos = document.getElementsByClassName("id" + id);
    let camposArray = [...campos]
    let nombresCampos = ['modApellido1', 'modApellido2', 'modNombre', '']
    for (let index = 0; index < camposArray.length; index++) {
        let valorActual = camposArray[index].innerHTML;

        if (index === 3) {
            camposArray[index].innerHTML = `
                <select name="modActivo">
                    <option value="S">Sí</option>
                    <option value="N">No</option>
                </select></td>
            `
        } else {
            camposArray[index].innerHTML = '<input type="text" name="' + nombresCampos[index] + '" value="' + valorActual + '">'
        }
    }
    // CAMBIAR COMO ACTUA EL BOTON DE CAMBIOS
    let boton = document.getElementById("btnId" + id)
    boton.removeAttribute("onclick")
    boton.setAttribute("type", "submit")
    boton.innerHTML = "Aplicar cambios"
    // CAMBIAR COMO ACTUA EL BOTON DE ELIMINAR
    let botonRmv = document.getElementById("btnRmvId" + id)
    botonRmv.style.backgroundColor = "yellow"
    botonRmv.innerHTML = "Cancelar modificacion"
    botonRmv.setAttribute("onclick", "cancelarModificacion(" + id + ")")
    // METER UN FORM
    let fila = document.getElementById("fila" + id)
    let form = document.createElement("form")
    form.classList.add("editarUsuario")
    form.setAttribute("id", "editarUsuario" + id)
    form.setAttribute("onsubmit", "editarUsuario(event," + id + ")")
    form.innerHTML = fila.innerHTML;
    fila.innerHTML = '';
    fila.appendChild(form);
}
function editarUsuario(event, id) {
    event.preventDefault();
    console.log("Has entrado en el usuario con id: " + id)

    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=editarUsuario&modId=" + id;
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("editarUsuario" + id))).toString();
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
function eliminarUsuario(id) {
    console.log("eliminar usuario")
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
function cancelarModificacion(id) {
    console.log("eliminar")
    location.reload();

}
