<?php
require_once 'modelos/Modelo.php';
require_once 'modelos/DAO.php';

class M_Usuarios extends Modelo
{
    public $DAO;

    public function __construct()
    {
        parent::__construct();
        $this->DAO = new DAO();
    }

    public function buscarUsuarios($filtros = array())
    {
        $paginaActual = '';
        $numUsuariosPorPagina = '';
        $b_texto = '';
        extract($filtros);
        $paginaActual--;
        $SQL = "SELECT * FROM usuarios ";

        if ($b_texto != '') {
            $SQL .= "WHERE UPPER(nombre) LIKE UPPER('%".$b_texto."%')
                    OR UPPER(apellido_1) LIKE UPPER('%".$b_texto."%')
                    OR UPPER(apellido_2) LIKE UPPER('%".$b_texto."%') ";
        }

        if ($sexo == 'ASC') {
            $SQL .= "ORDER BY fecha_Alta ";
        }
        if ($sexo == 'DESC') {
            $SQL .= "ORDER BY fecha_Alta DESC ";
        }

        $SQL .= "LIMIT " . ($numUsuariosPorPagina * $paginaActual) . "," . $numUsuariosPorPagina;

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
        // COMPROBAR SI EL USUARIO EXISTE CON EL LOGIN
        $SQL = "SELECT login FROM usuarios WHERE login = '$intLogin'";
        $existeLogin = $this->DAO->consultar($SQL);
        $resultado = '';
        if (isset($existeLogin[0]['login'])) {
            $SQL = "UPDATE usuarios SET apellido_1 = '$intApellido1', apellido_2 = '$intApellido2', nombre = '$intNombre', activo = '$intActivo' WHERE login = '$intLogin'";
            $this->DAO->actualizar($SQL);
            $resultado = 'UPDATED';
        }else{
            $SQL = "INSERT INTO usuarios (nombre, apellido_1, apellido_2, sexo, fecha_Alta, mail, login, pass, activo) VALUES ('$intNombre', '$intApellido1', '$intApellido2', '$intSexo', NOW(), '$intEmail',  '$intLogin', '$intPass', '$intActivo' )";
            $this->DAO->insertar($SQL);
            $resultado = 'ADDED';
        }
        return $resultado;
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
        if ($modActivo == 'on') {
            $modActivo = 'S';
        } else {
            $modActivo = 'N';
        }
        // MONTAR LA SQL
        $SQL = "UPDATE usuarios SET apellido_1 = '$modApellido1', apellido_2 = '$modApellido2', nombre = '$modNombre', activo = '$modActivo' WHERE id_Usuario = $modId";


        $filasModificadas = $this->DAO->actualizar($SQL);
        return $filasModificadas;
    }
    public function cargarValoresUsuario($filtros = array())
    {
        $editId = '';
        extract($filtros);
        // MONTAR LA SQL
        $SQL = "SELECT * FROM usuarios WHERE id_Usuario = $editId";
        return $this->DAO->consultar($SQL);
    }
    public function eliminarUsuario($filtros = array())
    {
        // COGER PARAMETROS
        $remId = '';
        extract($filtros);
        // MONTAR LA SQL
        $SQL = "DELETE FROM usuarios WHERE id_Usuario = $remId";
        return $this->DAO->borrar($SQL);
    }
    public function countAllUsuarios()
    {
        // REALIZAR LA CONSULTA
        $SQL = "SELECT COUNT(*) AS numUsuarios FROM usuarios";
        $numeroUsuario = $this->DAO->consultar($SQL);
        return $numeroUsuario[0]['numUsuarios'];
    }

}
