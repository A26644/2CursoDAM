<?php
    require_once 'controladores/Controlador.php';

    class C_Usuarios extends Controlador{
        public function __construct()
        {
            parent::__construct();
        }

        public function validarUsuario($datos) {
            $usuario= 'maria';
            $pass = '1234';

            extract($datos);
            $valido= 'N';
            
            if($usuario == 'maria' && $pass=='1234'){
                $_SESSION['usuario'] = $usuario;
                $valido= 'S';
            }

            echo $valido;
            
        }

        public function getVistaUsuario(){
            Vista::render('vistas/Usuarios/V_Usuarios.php');
        }
    }
?>