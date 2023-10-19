function getVistaMenuSeleccionado(controlador, metodo){
    let opciones ={method:"GET"}
                let parametros = "?controlador=" + controlador +"&metodo=" + metodo;
                fetch("C_Ajax.php"+parametros, opciones)
                .then( res=> {
                    if(res.ok){
                        console.log('respuesta ok')
                        return res.text();
                    }
                })
                .then(vista=>{
                    document.getElementById("secContenidoPagina").innerHTML = vista; 
                })
                .catch(err => {
                    console.log("Error al realizar la peticion", err.message)
                })
}