<?php
require_once 'modelos/Modelo.php';
require_once 'modelos/DAO.php';

class M_Usuarios extends Modelo
{
    public $DAO;

    public function __construct()
    {
        parent::__construct(); //ejecuta constructor del padre
        $this->DAO = new DAO();
    }

    public function buscarUsuarios($filtros = array())
    {
        $b_texto = '';
        extract($filtros);

        $SQL = "SELECT * FROM usuarios WHERE 1=1 ";

        if ($b_texto != '') {
            $aTexto = explode(' ', $b_texto);
            $SQL .= " AND (1=2 ";
            foreach ($aTexto as $palabra) {
                $SQL .= " OR nombre LIKE '%" . $palabra . "%'";
                $SQL .= " OR apellido_1 LIKE '%" . $palabra . "%'";
                $SQL .= " OR apellido_2 LIKE '%" . $palabra . "%'";
                $SQL .= ")";
            }
        }

        if ($sexo == 'ASC') {
            $SQL .= "ORDER BY fecha_Alta";
        }
        if ($sexo == 'DESC') {
            $SQL .= "ORDER BY fecha_Alta DESC";
            # code...
        }
        $usuarios = $this->DAO->consultar($SQL);

        return $usuarios;
    }

    public function getUser($filtros = array())
    {

        $usuario = '';
        $pass = '';
        $sexo = '';
        extract($filtros);
        $pass = md5($pass);

        $SQL = "SELECT * FROM usuarios WHERE 1=1 ";

        if ($usuario != '') {
            $usuario = addslashes($usuario);
            $SQL .= " AND login = '$usuario' ";
        }

        if ($pass != '') {
            $pass = addslashes($pass);
            $SQL .= " AND pass = '$pass' ";
        }

        echo $SQL;
        $usuarios = $this->DAO->consultar($SQL);

        return $usuarios;
    }
}
