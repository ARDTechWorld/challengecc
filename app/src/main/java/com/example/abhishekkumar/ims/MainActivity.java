package com.example.abhishekkumar.ims;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAdmin, btnFaculty, btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  btnAdmin = (Button) findViewById(R.id.btnAdmin);
        btnStudent = (Button) findViewById(R.id.btnStudent);
        btnFaculty = (Button) findViewById(R.id.btnFaculty);

        btnFaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginScreen_Faculty.class);
                startActivity(intent);
            }
        });
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginScreen_Student.class);
                startActivity(intent);
            }
        });
    }

}
