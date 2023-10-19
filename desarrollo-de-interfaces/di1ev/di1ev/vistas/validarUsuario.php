<?php session_start();
    $usuario='';
    $pass= '';

    //$repuesta['valido'] = 'NO';
    $repuesta['msj']= 'NO verificado';
    $repuesta['usuario'] = '';

    if(isset($_GET)){
        extract($_GET);
        if($usuario== '' || $pass == '' ){
            $repuesta['msj'] = 'Datos incorrectos. ERR-LG-01';
        }else{
            if ($usuario == 'maria' && $pass == '123') {
                $repuesta['valido'] = 'SI';
                $repuesta['msj']= 'Usuario valido';
                $repuesta['usuario'] = 'maria';
                $_SESSION['usuario']='maria';
            }else{
                $repuesta['msj'] = 'Datos incorrectos. ERR-LG-02';
            }
        }
    }else{
        $repuesta['msj'] = 'Datos no recibidos';
    }

    echo json_encode($repuesta);

?>