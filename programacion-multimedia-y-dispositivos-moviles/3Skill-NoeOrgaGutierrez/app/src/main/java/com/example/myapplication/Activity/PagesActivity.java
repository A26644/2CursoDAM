<<<<<<< HEAD
package com.example.myapplication.Activity;
=======
package com.example.myapplication;
>>>>>>> f4dcbc965e7d74620deebccd8a8816022b9e0b0d

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
<<<<<<< HEAD
import android.widget.TextView;

import com.example.myapplication.R;

public class PagesActivity extends AppCompatActivity {
=======

public class pages extends AppCompatActivity {
>>>>>>> f4dcbc965e7d74620deebccd8a8816022b9e0b0d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages);
<<<<<<< HEAD

        int pageId = getIntent().getIntExtra("id", 0);
        TextView pageid = findViewById(R.id.pageId);
        pageid.setText("PAGE : "+ pageId);
=======
>>>>>>> f4dcbc965e7d74620deebccd8a8816022b9e0b0d
    }
}