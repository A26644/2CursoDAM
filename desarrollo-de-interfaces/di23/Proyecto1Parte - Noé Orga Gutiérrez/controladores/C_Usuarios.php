<?php
require_once 'controladores/Controlador.php';
require_once 'vistas/Vista.php';
require_once 'modelos/M_Usuarios.php';

class C_Usuarios extends Controlador
{

    private $modelo;

    public function __construct()
    {
        parent::__construct();
        $this->modelo = new M_Usuarios();
    }

    public function validarUsuarios($filtros)
    {
        $valido = 'N';
        // if($usuario=='javier' && $pass=='123'){
        //     $_SESSION['usuario']=$usuario;
        //     $valido='S';
        // }
        $usuarios = $this->modelo->getUser($filtros);

        if (!empty($usuarios)) {
            $_SESSION['usuario'] = $usuarios[0]['login'];
            $valido = "S";
        }
        return $valido;
    }

    public function getVistaUsuarios()
    {
        Vista::render('vistas/Usuarios/V_Usuarios.php');
    }
    public function getVistaIntroducirUsuarios()
    {
        Vista::render('vistas/usuarios/V_IntroducirUsuarios.php');
    }

    public function getVistaEditarUsuario()
    {
        Vista::render('vistas/usuarios/V_EditarUsuario.php');
    }

    public function buscarUsuarios($filtros = array())
    {
        $usuarios = $this->modelo->buscarUsuarios($filtros);

        Vista::render(
            'vistas/Usuarios/V_Usuarios_Listado.php',
            array('usuarios' => $usuarios)
        );

    }
    public function introducirUsuario($filtros = array())
    {
        $respuesta = '';
        $idUsuario = $this->modelo->introducirUsuario($filtros);
        if ($idUsuario > 0) {
            $respuesta = "okay";
        } else {
            $respuesta = 'error';
        }

        echo $respuesta;
    }
    public function editarUsuario($filtros = array())
    {
        $filasModificasdas = $this->modelo->editarUsuario($filtros);

        echo $filasModificasdas;
    }
    public function eliminarUsuario($filtros = array())
    {

        $filasModificadas = $this->modelo->eliminarUsuario($filtros);
        echo $filasModificadas;
    }
    public function cargarValoresUsuario($filtros = array())
    {
        $usuario = $this->modelo->cargarValoresUsuario($filtros);
        $string = json_encode($usuario);
        echo $string;

    }

}
?>
