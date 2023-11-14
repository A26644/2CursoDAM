<?php
$usuarios = $datos['usuarios'];
echo '<div id="header">
            <div>ID</div>
            <div>Apellido 1</div>
            <div>Apellido 2</div>
            <div>Nombre</div>
            <div>Activo</div>
            <div>Editar</div>
            <div>Eliminar</div>
        </div>
        <div class="contenidoCargado">';
foreach ($usuarios as $fila) {
    echo '<div class="fila"  id="fila' . $fila['id_Usuario'] . '">
                <div name="modId">' . $fila['id_Usuario'] . '</div>
                <div class="id' . $fila['id_Usuario'] . ' campo" name="modApellido1">' . $fila['apellido_1'] . '</div>
                <div class="id' . $fila['id_Usuario'] . ' campo" name="modApellido2">' . $fila['apellido_2'] . '</div>
                <div class="id' . $fila['id_Usuario'] . ' campo" name="modNombre">' . $fila['nombre'] . '</div>
                <div class="id' . $fila['id_Usuario'] . ' campo" name="modActivo">' . $fila['activo'] . '</div>
                <div class="campo"><button id="btnId' . $fila['id_Usuario'] . '" onclick="vistaEditarUsuario(' . $fila['id_Usuario'] . ')">Editar</button></div>
                <div class="campo"><button id="btnRmvId' . $fila['id_Usuario'] . '" class="eliminar" onclick="eliminarUsuario(' . $fila['id_Usuario'] . ')">Eliminar</button></div>
            </div>';
}
echo '</div>';
?>
