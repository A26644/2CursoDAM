
let apiKey = 'POSVKOw3IJZjfjbehWcdbcUHVXlYAo6YQik34XFs';
let sol = 1000; // El número de sol que deseas consultar

// URL del API de la NASA
let apiUrl = `https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=${sol}&api_key=${apiKey}`;

// Realizar una solicitud GET utilizando Fetch API
fetch(apiUrl)
    .then((response) => {
        if (!response.ok) {
            throw new Error('Error en la solicitud al API');
        }
        return response.json();
    })
    .then((data) => {
        // Los datos de las fotos se encuentran en el objeto 'data'
        console.log(data)
        let id = document.getElementById("container")!
        id.innerHTML = ""
        data.photos.forEach((element) => {
            let img = document.createElement("div")
            img.classList.add("rover-photo")
            img.innerHTML = `
                <img id="img"
                src="${element.img_src}"
                alt="Mars Rover Photo">
            <div class="rover-details">
                <p>ID: ${element.id}</p>
                <p>Sol: ${element.sol}</p>
                <p>Camera: Front Hazard Avoidance Camera</p>
                <p>Earth Date: ${element.earth_date}</p>
                <p>Rover: Curiosity</p>
                <p>Status: Active</p>
            </div>
            `
            id.appendChild(img)
        });
        // Aquí puedes procesar los datos o mostrar las imágenes en tu aplicación
    })
    .catch((error) => {
        console.error('Ocurrió un error:', error);
    });
