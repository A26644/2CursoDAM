CREATE OR REPLACE PROCEDURE invertir_cadena(
        p_cadena IN VARCHAR2,
        p_cadena_invertida OUT VARCHAR2
    ) AS v_longitud NUMBER;
BEGIN v_longitud := LENGTH(p_cadena);
p_cadena_invertida := '';
FOR i IN REVERSE 1..v_longitud LOOP p_cadena_invertida := p_cadena_invertida || SUBSTR(p_cadena, i, 1);
END LOOP;
END;
/
DECLARE cadena_invertida VARCHAR2(100);
BEGIN invertir_cadena('Hola Mundo', cadena_invertida);
DBMS_OUTPUT.PUT_LINE('Cadena invertida: ' || cadena_invertida);
END;
/
