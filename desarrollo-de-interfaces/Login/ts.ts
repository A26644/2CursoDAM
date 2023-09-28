function validar() {
    var usuario = (<HTMLInputElement>document.getElementById("usuario")).value;
    var pass = (<HTMLInputElement>document.getElementById("pass")).value;
    let mensaje: string = ""
    if (usuario === '' || pass === '') {
        mensaje = "Debes completar los campos"
    } else {
        fetch("")
            .then(response => response.json())
            .then(data => {

            }).catch(error => {

            })
    }
    document.getElementById("msj")!.innerHTML = mensaje;

}
