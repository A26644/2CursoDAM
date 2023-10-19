package com.example.demo.interfaces;

import org.springframework.http.ResponseEntity;

public interface IController<X> {
    public ResponseEntity<X> getMethod(X bean);

    public ResponseEntity<X> postMethod(X bean);

    public ResponseEntity<X> putMethod(X bean);

    public void deleteMethod(X bean);

}
