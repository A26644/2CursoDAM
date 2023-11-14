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

        $SQL = "SELECT * FROM usuarios WHERE ";

        if ($usuario != '') {
            $usuario = addslashes($usuario);
            $SQL .= "login = '$usuario' ";
        }

        if ($pass != '') {
            $pass = addslashes($pass);
            $SQL .= "AND pass = '$pass' ";
        }

        echo ($SQL);
        $usuarios = $this->DAO->consultar($SQL);

        return $usuarios;
    }
    public function introducirUsuario($filtros = array())
    {
        // COGER PARAMETROS
        $intEmail = '';
        $intLogin = '';
        $intNombre = '';
        $intApellido1 = '';
        $intApellido2 = '';
        $intSexo = '';
        $intActivo = '';
        $intPass = '';
        extract($filtros);
        $intPass = md5($intPass);
        if ($intActivo == 'on') {
            $intActivo = 'S';
        } else {
            $intActivo = 'N';
        }
        // MONTAR LA SQL
        $SQL = "INSERT INTO usuarios (nombre, apellido_1, apellido_2, sexo, fecha_Alta, mail, login, pass, activo) VALUES ('$intNombre', '$intApellido1', '$intApellido2', '$intSexo', NOW(), '$intEmail',  '$intLogin', '$intPass', '$intActivo' )";

        $idUsuario = $this->DAO->insertar($SQL);

        return $idUsuario;
    }
    public function editarUsuario($filtros = array())
    {
        // COGER PARAMETROS
        $modApellido1 = '';
        $modApellido2 = '';
        $modNombre = '';
        $modActivo = '';
        $modFecha = '';
        $modId = '';
        extract($filtros);
        // MONTAR LA SQL
        $SQL = "UPDATE usuarios SET apellido_1 = '$modApellido1', apellido_2 = '$modApellido2', nombre = '$modNombre', activo = '$modActivo' WHERE id_Usuario = $modId";


        $filasModificadas = $this->DAO->actualizar($SQL);
        return $filasModificadas;
    }
    public function eliminarUsuario($filtros = array())
    {
        // COGER PARAMETROS
        $remId = '';
        extract($filtros);
        // MONTAR LA SQL
        $SQL = "DELETE FROM usuarios WHERE id_Usuario = $remId";
        return $filasModificadas = $this->DAO->borrar($SQL);
    }

}
