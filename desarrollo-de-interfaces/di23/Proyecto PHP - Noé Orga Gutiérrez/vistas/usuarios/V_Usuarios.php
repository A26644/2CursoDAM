<?php
?>
<form id="formularioBuscar" name="formBuscar" onsubmit="buscarUsuarios(event)">
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
            <option value="ASC">Ordenar por fecha de alta ascendente</option>
            <option value="DESC">Ordenar por fecha de alta descendente</option>
        </select>
    </label>
    <br>
        <label>Nº Usuarios por pagina: </label>
    <input type="number" name="numUsuariosPorPagina" min="1" required id="numeroUsuariosPorPagina" onchange="resetearPagina()">
    <button type="submit">Buscar</button><br>
    <center>
    <button onclick="modificarPagina('<<')" class="page-item"><<</button>
    <button onclick="modificarPagina('<')"><</button>
    <input name="paginaActual" id="paginaActual" value="1" min="1" max="1" required placeholder="Ir a página"  type="number">
    <button onclick="modificarPagina('>')">></button>
    <button onclick="modificarPagina('>>')">>></button>
    </center>
</form>
<div id="capaResultadosBusqueda">

</div>
