
<?php session_start();
    $usuario ='';
    $pass = '';

    extract($_POST);
    //var_dump($_POST);
    if($usuario == '' || $pass ==''){
        $mensa='Debe completar los campos';
    }else{
        require_once 'controladores/C_Usuarios.php';
        $objUsuarios = new C_Usuarios();
        $res = $objUsuarios->validarUsuario(array(
            'usuario'=> $usuario,
            'pass' => $pass
        ));
        if ($res == 'S') {
            header('Location: index.php');
        } else {
            $mensa ='Datos incorrectos';
        }
    }

    
    
    
?>


<!DOCTYPE html>
<html>
<head>
    <title>Prueba 14 - 09</title>
    <script>
        function validar(){
            const usuario = document.getElementById("usuario");
            const pass = document.getElementById("pass");
            const mns = '';
            if(usuario.value=='' | pass.value ==''){
                mns='debes completar los campos'

            }else{
                document.getElementById("formularioLogin").submit();
            }

            document.getElementById('msj').innerHTML= mns;
        }
    </script>
</head>

    <body>
        <form id="formularioLogin" method="post" action="login.php">
            <label  for="usuario">Usuario</label><br>
                <input type="text" id="usuario" name="usuario" value="<?php echo $usuario; ?>"><br>

            <label for="pass">Contraseña</label><br>
                <input type="password" id="pass" value="<?php echo $pass; ?>" name="pass"><br>
                <span id="msj">
                </span>
                <input type="button" id="aceptar" onclick="validar()" value="Enviar">
        </form>
        

    </body>

</html>



 