<?php
$usuarios = $datos['usuarios'];
// AVERIGUAR EL NUMERO TOTAL DE FILAS
$resto = sizeof($usuarios) % 10;
$filas = (sizeof($usuarios) - $resto) / 10;
if ($resto != 0) {
    $filas++;
}
echo $filas;
echo '<table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Login</th>
                    <th scope="col">Apellido 1</th>
                    <th scope="col">Apellido 2</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Editar</th>
                    <th scope="col">Eliminar</th>
                </tr>
            </thead>
            <tbody>';
foreach ($usuarios as $fila) {
    echo '       <tr>
                    <th>' . $fila['login'] . '</th>
                    <td>' . $fila['apellido_1'] . '</td>
                    <td>' . $fila['apellido_2'] . '</td>
                    <td>' . $fila['nombre'] . '</td>
                    <td><button type="button" class="btn btn-success" onclick="cogerValores(' . $fila['id_Usuario'] . ')">Modificar</button></td>
                    <td><button type="button" class="btn btn-danger" onclick="eliminarUsuario(event, ' . $fila['id_Usuario'] . ')">Eliminar</button></td>
                </tr>
    ';
}

echo '            </tbody>
        </table>';

?>
