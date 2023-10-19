<?php session_start() ;

    if(isset($_SESSION['usuario']) && $_SESSION['usuario']!=''){
        //esta logeado
    }else{
        header('Location: login.php');
    }
?>



<!DOCTYPE html>
<html>

    <head>
        <title>Prueba 14 - 09</title>
    </head>

    <body>
        holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa <?php echo $_SESSION['usuario']; ?>

        
        <?php 
            // etiqueta php
            $numero = 5;
            $palabra1 = '<br>sandia '.$numero. ' es numero'; // concatenar
            $palabra2 = "<br>borraja y esto $numero es un numero"; // dentro de las comillas dobles se pueden meter variables sencillas de php
            
            echo "<br>hoy es jueves";
            echo $palabra1;
            echo $palabra2;

            $matriz= array();
            $matriz= array('a', 'b', 5, 7.6, true);
            echo "<br>";
            print_r($matriz);

            for( $posicion = 0; $posicion < sizeof($matriz); $posicion++ ){
                    echo "<br> En esta posicion $posicion  esta el elemento: $matriz[$posicion]";
            }

            foreach($matriz as $posicion => $valor){
                echo "<br> En esta posicion $posicion  esta el elemento: $valor";
            }

            $edades= array('Javier'=> 52, 'Ivan' => 23); //Arraylist
            foreach($edades as $nombre => $edad){
                echo "<br>$nombre  tiene: $edad";
            }

            echo $msj;
            define('CENTRO', 'San Valero');

        ?>

        <br> (c) <?php echo CENTRO?> 2023
        <br> (c) <?=CENTRO?> 2023


    </body>

</html>
