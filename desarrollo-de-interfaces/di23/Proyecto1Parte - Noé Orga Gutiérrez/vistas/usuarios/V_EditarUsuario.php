<?php
?>

<form class="row g-3" id="introducirUsuario">
    <div class="col-md-6">
        <label for="inputEmail4" class="form-label">Email</label>
        <input type="email" class="form-control" id="introducirEmail" name="modEmail" required>
    </div>
    <div class="col-md-6">
        <label for="inputPassword4" class="form-label">Login</label>
        <input type="text" class="form-control" id="introducirLogin" name="modLogin" required>
    </div>
    <div class="col-12">
        <label for="inputAddress" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="introducirNombre" placeholder="Nombre" name="modNombre">
    </div>
    <div class="col-12">
        <label for="inputAddress2" class="form-label">Apellido 1</label>
        <input type="text" class="form-control" id="IntroducirApellido1" placeholder="Doe" name="modApellido1">
    </div>
    <div class="col-md-6">
        <label for="inputCity" class="form-label">Apellido 2</label>
        <input type="text" class="form-control" id="IntroducirApellido2" placeholder="Doe 2" name="modApellido2">
    </div>
    <div class="col-md-4">
        <label for="inputState" class="form-label">Sexo</label>
        <select id="Sex" class="form-select" name="modSexo">
            <option selected>H</option>
            <option>M</option>
        </select>
    </div>
    <div class="col-12">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="IntroducirActivo" name="modActivo">
            <label class="form-check-label" for="gridCheck">
                Activo
            </label>
        </div>
    </div>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Editar usuario</button>
        <div class="alert alert-dark" role="alert" id="resultadoInsert">

        </div>
    </div>
</form>
