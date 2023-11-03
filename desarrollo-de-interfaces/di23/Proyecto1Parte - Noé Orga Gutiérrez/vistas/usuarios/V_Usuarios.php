<?php
echo 'Hola desde usuarios';
?>
<form id="formularioBuscar" name="formBuscar">

    Nombre:
    <br>
    <label for="b_texto">
        <input type="text" id="b_texto" name="b_texto">
    </label>
    <br>
    Fecha de alta
    <br>
    <label for="b_texto">
        <select name="sexo" id="sexo">
            <option value="--">--</option>
            <option value="ASC">Ordenar por fecha de alta ascendente</option>
            <option value="DESC">Ordenar por fecha de alta descendente</option>
        </select>
    </label>
    <br>
    <button type="button" onclick="buscarUsuarios()">Buscar</button>
</form>

<div id="capaResultadosBusqueda">

</div>
