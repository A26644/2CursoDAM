function mostrarEditar(idUsuario, nombre, apellido1, apellido2, sexo, mail, movil, activo) {
    // Verificar si el div popup ya existe
    var popupExistente = document.getElementById('popup');

    // Si existe, eliminarlo antes de crear uno nuevo
    if (popupExistente) {
        popupExistente.remove();
    }

    // Crear el div emergente
    var popup = document.createElement('div');
    popup.id = 'popup';
    // popup.innerHTML = `
    //         <h2>ID Usuario: ${idUsuario}</h2>
    //         <p>Nombre: ${nombre}</p>
    //         <p>Apellido 1: ${apellido1}</p>
    //         <p>Apellido 2: ${apellido2}</p>
    //         <p>Sexo: ${sexo}</p>
    //         <p>Email: ${mail}</p>
    //         <p>Móvil: ${movil}</p>
    //         <p>Activo: ${activo}</p>
    //         <button onclick="cerrarPopup()">Cerrar</button>
    //     `;

    popup.innerHTML = `
        <h2>ID Usuario: ${idUsuario}</h2>
        <label for="b_nombre">Nombre del usuario:</label>
        <input type="text" id="b_nombre" name="b_nombre" value="${nombre}">

        <label for="b_apellido1">Apellido 1:</label>
        <input type="text" id="b_apellido1" name="b_apellido1" value="${apellido1}">

        <label for="b_apellido2">Apellido 2:</label>
        <input type="text" id="b_apellido2" name="b_apellido2" value="${apellido2}">

        <label for="b_sexo">Sexo:</label>
        <div id="sexo" class="sexo">
            <button type="button" id="b_sexo_hombre" name="b_sexo" onclick="cambiarSexo('H')" ${sexo === 'H' ? 'disabled' : ''}>Hombre</button>
            <button type="button" id="b_sexo_mujer" name="b_sexo" onclick="cambiarSexo('M')" ${sexo === 'M' ? 'disabled' : ''}>Mujer</button>
        </div>

        <label for="b_email">Email:</label>
        <input type="text" id="b_email" name="b_email" value="${mail}">

        <label for="b_movil">Movil:</label>
        <input type="text" id="b_movil" name="b_movil" value="${movil}">

        <button type="button" onclick="insertarUsuario()">Añadir usuario</button>
        <button type="button" onclick="cerrarPopup()">Cerrar</button>
    `;


    // Añadir el div emergente al body
    document.body.appendChild(popup);

    // Mostrar el div emergente
    popup.style.display = 'block';

    // Agregar un listener para clics en el documento
    document.addEventListener("click", cerrarPopupSiClicasFuera);
}
