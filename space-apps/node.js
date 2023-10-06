const mysql = require('mysql');
const fs = require('fs');

// Configuración de la conexión a la base de datos
const conexion = mysql.createConnection({
    host: 'database-2.cpmqkeqmhomo.us-east-1.rds.amazonaws.com',
    user: 'admin',
    password: '12344321',
    database: 'SPACEAPPS'
});

// Abre el archivo PDF en modo binario
const archivoPDF = fs.readFileSync('archivo.pdf');

// Consulta SQL para insertar el PDF en la base de datos
const consulta = 'INSERT INTO PROYECTO (PROYECTO_EXTRA) VALUES (?)';

// Ejecuta la consulta con el archivo binario como parámetro
conexion.query(consulta, [archivoPDF], (error, resultados) => {
    if (error) {
        console.error('Error al insertar el PDF:', error);
    } else {
        console.log('PDF insertado correctamente');
    }

    // Cierra la conexión
    conexion.end();
});
