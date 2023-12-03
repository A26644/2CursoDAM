<?php
$usuarios = $datos['numUsuarios'];
$numUsuariosPorPagina = $datos['numUsuariosPorPagina'];
// AVERIGUAR EL NUMERO TOTAL DE FILAS
$resto = $usuarios % $numUsuariosPorPagina;
$filas = ($usuarios - $resto) / $numUsuariosPorPagina;
if ($resto != 0) {
    $filas++;
}
;
?>
