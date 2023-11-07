<?php

require_once 'controladores/C_Usuarios.php';

session_start();
$usuario = '';
$pass = '';
extract($_POST);
//var_dump($_POST);
if ($usuario == '' || $pass == '') {
    $mensa = 'Debe completar los campos';
} else {
    $objUsuarios = new C_Usuarios();
    $datos['usuario'] = $usuario;
    $datos['pass'] = $pass;

    $resultado = $objUsuarios->validarUsuarios(
        array(
            'usuario' => $usuario,
            'pass' => $pass
        )
    );

    if ($resultado == 'S') {
        header('Location: index.php');
    } else {
        $mensa = 'Datos incorrectos';
    }
}
?>
<!DOCTYPE html>
<html>

    <head>
        <script type="text/javascript">
            function validar() {
                const usuario = document.getElementById("usuario");
                const pass = document.getElementById("pass");
                let mensaje = '';
                if (usuario.value == '' || pass.value == '') {
                    mensaje = 'Debe completar los campos';
                } else {
                    //enviar formulario
                    document.getElementById("formularioLogin").submit();
                }
                document.getElementById("msj").innerHTML = mensaje;
            }
        </script>
        <link rel="stylesheet" href="css/login.css">

    </head>

    <body>
        <header></header>
        <main>

            <form id="formularioLogin" name="formularioLogin" method="post" action="login.php">
                <h2>Login</h2>
                <div class="campo">
                    <label for="usuario">Usuario</label><br>
                    <input type="text" id="usuario" name="usuario" value="<?php echo $usuario; ?>"><br>
                </div>

                <div class="campo">
                    <label for="pass">Contraseña</label><br>
                    <input type="password" id="pass" name="pass" value="<?php echo $pass; ?>"><br>
                </div>

                <span id="msj">
                    <?php echo $mensa; ?>
                </span>
                <button type="button" id="aceptar" onclick="validar()">Login</button>
            </form>
        </main>

        <footer></footer>
    </body>

</html>
