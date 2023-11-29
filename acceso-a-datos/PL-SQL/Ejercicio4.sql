CREATE OR REPLACE FUNCTION obtener_anio(p_fecha IN DATE) RETURN NUMBER IS v_anio NUMBER;
BEGIN v_anio := EXTRACT(
    YEAR
    FROM p_fecha
);
RETURN v_anio;
END obtener_anio;
/
DECLARE fecha_prueba DATE := TO_DATE('2023-11-23', 'YYYY-MM-DD');
anio_resultante NUMBER;
BEGIN anio_resultante := obtener_anio(fecha_prueba);
DBMS_OUTPUT.PUT_LINE(
    'El año correspondiente a la fecha es: ' || anio_resultante
);
END;
/
