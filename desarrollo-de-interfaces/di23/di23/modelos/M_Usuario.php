<?php
    require_once 'modelos/Modelo.php';
    class M_Usuarios extends Modelo {
        public $DAO;

        public function __construct(){
            parent::__construct();
            $this->DAO = new DAO();
        }

        public function buscarUsuarios($filtros=array()){
            $SQL = "SELECT * FROM usuarios WHERE 1=1";

            $usuarios = $this->DAO->consultar($SQL);

            return $usuarios;
        }

        
    }

?>