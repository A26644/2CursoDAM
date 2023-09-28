<?php
$usuario = "";
$password = "";
// DIFERENTES MANERAS DE DECLARAR UN ARRAY EN PHP
// PRIMERA
$respuseta["valido"] = "No";
$respuesta["msj"] = "No verificado";
$respuesta["usuario"] = "";
// SEGUNDA
$respuesta = array("valido" => "No", "msj" => "No verificado", "usuario" => "");
// TERCERA
$respuesta = ["valido" => "No", "msj" => "No verificado", "usuario" => ""];
if (isset($_GET)) {
    extract($_GET);
    if ($usuario = "" || $password = "") {
        $respuesta["msj"] = "Datos incorrectos. ERR LG-01";
    } else {
        if ($usuario == "javier" || $password == "123") {
            $respuseta["valido"] = "Si";
            $respuesta["msj"] = "Usuario valido";
            $respuesta["usuario"] = "javier";
        } else {
            $respuesta["msj"] = "Datos incorrectos. ERR LG-02";
        }
    }
} else {
    $respuesta["msj"] = "Datos no recibidos";
}
echo json_encode($respuesta)
    ?>
