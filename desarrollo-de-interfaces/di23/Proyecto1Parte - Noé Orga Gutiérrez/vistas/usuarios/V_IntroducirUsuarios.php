<?php
?>
<form class="row g-3" id="introducirUsuario" onsubmit="introducirUsuarios(event)">
    <div class="col-md-6">
        <label for="inputEmail4" class="form-label">Email</label>
        <input type="email" class="form-control" id="introducirEmail" name="intEmail" required>
    </div>
    <div class="col-md-6">
        <label for="inputPassword4" class="form-label">Login</label>
        <input type="text" class="form-control" id="introducirLogin" name="intLogin" required>
    </div>
    <div class="col-12">
        <label for="inputAddress" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="introducirNombre" placeholder="Jane" name="intNombre" required>
    </div>
    <div class="col-12">
        <label for="inputAddress2" class="form-label">Apellido 1</label>
        <input type="text" class="form-control" id="IntroducirApellido1" placeholder="Doe" name="intApellido1" required>
    </div>
    <div class="col-md-6">
        <label for="inputCity" class="form-label">Apellido 2</label>
        <input type="text" class="form-control" id="IntroducirApellido2" placeholder="Doe 2" name="intApellido2"
            required>
    </div>
    <div class="col-md-4">
        <label for="inputState" class="form-label">Sexo</label>
        <select id="Sex" class="form-select" name="intSexo">
            <option selected>H</option>
            <option>M</option>
        </select>
    </div>
    <div class="col-12">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="IntroducirActivo" name="intActivo">
            <label class="form-check-label" for="gridCheck">
                Activo
            </label>
        </div>
    </div>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Registrar usuario</button>
        <div class="alert alert-dark" role="alert" id="resultadoInsert">

        </div>
    </div>
</form>
