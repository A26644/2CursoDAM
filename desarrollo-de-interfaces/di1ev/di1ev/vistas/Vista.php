<?php
    class Vista{
        static public function render($rutaVista){
            require_once($rutaVista);
        }
    }


?>