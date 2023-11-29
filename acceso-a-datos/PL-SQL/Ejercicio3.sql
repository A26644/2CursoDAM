DECLARE resultado NUMBER;
BEGIN resultado := sumar_numeros(5, 7);
DBMS_OUTPUT.PUT_LINE('La suma es: ' || resultado);
END;
/
DECLARE resultado NUMBER;
BEGIN resultado := sumar_numeros(5, 7);
DBMS_OUTPUT.PUT_LINE('La suma es: ' || resultado);
END;
/
CREATE OR REPLACE FUNCTION invertir_cadena(p_cadena IN VARCHAR2) RETURN VARCHAR2 IS v_cadena_invertida VARCHAR2(32767);
v_longitud NUMBER;
BEGIN v_longitud := LENGTH(p_cadena);
v_cadena_invertida := '';
FOR i IN REVERSE 1..v_longitud LOOP v_cadena_invertida := v_cadena_invertida || SUBSTR(p_cadena, i, 1);
END LOOP;
RETURN v_cadena_invertida;
END invertir_cadena;
/
DECLARE cadena_invertida VARCHAR2(100);
BEGIN cadena_invertida := invertir_cadena('Hola Mundo');
DBMS_OUTPUT.PUT_LINE('Cadena invertida: ' || cadena_invertida);
END;
/
