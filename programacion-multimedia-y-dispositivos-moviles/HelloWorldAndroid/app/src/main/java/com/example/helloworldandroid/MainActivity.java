package com.example.helloworldandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnSignIn;

    /* CICLO DE VIDA: ONLOAD JAVASCRIPT*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // document.getElementById("idUser")
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        // btnEnviar.addEventListener("submit", hacerAlgo())
        btnSignIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
    }
}