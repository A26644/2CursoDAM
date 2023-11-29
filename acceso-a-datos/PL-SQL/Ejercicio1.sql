CREATE OR REPLACE PROCEDURE sumar_numeros(
        v_numero1 IN NUMBER,
        v_numero2 IN NUMBER,
        v_resultado OUT NUMBER
    ) AS BEGIN p_resultado := p_numero1 + p_numero2;
END;
/
DECLARE resultado NUMBER;
BEGIN sumar_numeros(5, 7, resultado);
DBMS_OUTPUT.PUT_LINE('La suma es: ' || resultado);
END;
/
