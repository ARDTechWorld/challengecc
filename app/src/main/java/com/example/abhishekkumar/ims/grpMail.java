package com.example.abhishekkumar.ims;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class grpMail extends AppCompatActivity {

    EditText setEmail,subject,mes;
    Button btn_send;
    String useremail,sub,mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grp_mail);
        setEmail = (EditText) findViewById(R.id.editEmail) ;
        btn_send = (Button) findViewById(R.id.btnSend);
        subject = (EditText)findViewById(R.id.editSub);
        sub = subject.getText().toString();
        mes = (EditText)findViewById(R.id.editDes);
        mess = mes.getText().toString();
        Bundle extras = getIntent().getExtras();
        useremail = extras.getString("email");
        setEmail.setText(useremail);
        //Toast.makeText(getApplicationContext(),useremail,Toast.LENGTH_LONG).show();
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{useremail});
                intent.putExtra(Intent.EXTRA_SUBJECT,sub);
                intent.putExtra(Intent.EXTRA_TEXT,mess);

                intent.setType("message/rfc822");
                startActivity(intent.createChooser(intent,"Choose an Email Client:"));
            }
        });
    }
}
