<!DOCTYPE html>

<?php session_start();
if (isset($_SESSION['usuario']) && $_SESSION['usuario'] != '') {

} else {
    header('Location: ./login.php');
}
$user = "";
$pass = "";

extract($_POST);
if ($user == '' || $pass == '') {
    $mensa = "Debe completar los campos";
} else {
    if ($usuario == "javier" && $pass == "123") {
        header("location: index.php");
    } else {
        $mensa = "Datos incorrectos";
    }
}


?>

<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='./login.css'>
    <script src='./ts.js'></script>
</head>

<body>
    <?php include './validarUsuario.php'; ?>
    <form action="login.php">
        <label for="usuario">Usuario:
            <input type="text" id="name" name="user" value="<?php echo $usuario ?>"><br>
        </label>
        <label for="pass">Contraseña:
            <input type="pass" id="pass" name="pass" value="<?php echo $pass ?>"><br>
        </label>
        <span id="msj"></span>
        <button type="button" id="aceptar" onclick="">Aceptar</button>
    </form>
</body>

</html>
