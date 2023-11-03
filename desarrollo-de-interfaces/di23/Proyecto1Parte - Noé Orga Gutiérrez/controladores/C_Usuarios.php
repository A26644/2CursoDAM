<?php
    require_once 'controladores/Controlador.php';
    require_once 'vistas/Vista.php';
    require_once 'modelos/M_Usuarios.php';    

    class C_Usuarios extends Controlador{

        private $modelo;

        public function __construct(){
            parent::__construct();
            $this->modelo=new M_Usuarios();
        }

        public function validarUsuarios($filtros){
            $valido='N';
            // if($usuario=='javier' && $pass=='123'){
            //     $_SESSION['usuario']=$usuario;
            //     $valido='S';   
            // }
            $usuarios=$this->modelo->getUser($filtros);

            if(!empty($usuarios)){
                $_SESSION['usuario']=$usuarios[0]['login'];
                $valido = "S";
            }
            return $valido;
        }

        public function getVistaUsuarios(){
            Vista::render('vistas/Usuarios/V_Usuarios.php');
        }

        public function buscarUsuarios($filtros=array()){
            $usuarios=$this->modelo->buscarUsuarios($filtros);

            Vista::render('vistas/Usuarios/V_Usuarios_Listado.php',
                          array('usuarios'=>$usuarios));

        }

    }
?>