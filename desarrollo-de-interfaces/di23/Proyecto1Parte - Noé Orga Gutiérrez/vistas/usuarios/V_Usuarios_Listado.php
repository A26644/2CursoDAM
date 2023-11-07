<?php

$usuarios = $datos['usuarios'];
echo '<table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Apellido 1</th>
                    <th scope="col">Apellido 2</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Activo</th>
                    <th scope="col">Fecha de alta</th>
                </tr>
            </thead>
            <tbody>';
foreach ($usuarios as $fila) {
    echo '  <tr>
                <th scope="row">' . $fila['id_Usuario'] . '</th>
                <td>' . $fila['apellido_1'] . '</td>
                <td>' . $fila['apellido_2'] . '</td>
                <td>' . $fila['nombre'] . '</td>
                <td>' . $fila['activo'] . '</td>
                <td>' . $fila['fecha_Alta'] . '</td>
            </tr>';
}
echo '</tbody>
        </table>';
?>
