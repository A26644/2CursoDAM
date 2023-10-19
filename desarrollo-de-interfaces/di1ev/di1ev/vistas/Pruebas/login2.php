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
                let opciones ={method:"GET"}
                let parametros = "usuario=" + usuario.value +"&pass=" + pass.value;
                fetch("validarUsuario.php?"+parametros, opciones)
                .then( res=> {
                    if(res.ok){
                        console.log('respuesta ok')
                        return res.json();
                    }
                    
                })
                .then(respuestaJson=>{
                    console.log('respuesta ok')
                    if(respuestaJson.valido == 'SI'){
                        location.href = "index.php";
                    }else{
                        document.getElementById("msj").innerHTML = respuestaJson.msj;
                    }
                })
                .catch(err => {
                    console.log("Error al realizar la peticion", err.message)
                })
            }

            document.getElementById('msj').innerHTML= mns;
        }
    </script>
</head>

    <body>
        <form id="formularioLogin" method="post" action="login.php">
            <label  for="usuario">Usuario</label><br>
                <input type="text" id="usuario" name="usuario"><br>

            <label for="pass">Contraseña</label><br>
                <input type="password" id="pass" name="pass"><br>
                <span id="msj">
                </span>
                <input type="button" id="aceptar" onclick="validar()" value="Enviar">
        </form>
        

    </body>

</html>
