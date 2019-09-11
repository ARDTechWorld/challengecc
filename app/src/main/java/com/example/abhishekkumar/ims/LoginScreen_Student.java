package com.example.abhishekkumar.ims;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginScreen_Student extends AppCompatActivity {

    //private static final String sURL= "http://192.168.1.3/IMS/slogin.php";
    private static final String sURL= "http://192.168.43.140/IMS/slogin.php";
    private static final String TAG_SUCCESS = "success";
    JSONParser jsonParser = new JSONParser();
    EditText edit_usrname, edit_pass;
    Button signIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen__student);
        edit_usrname = (EditText) findViewById(R.id.edit_username);
        edit_pass = (EditText) findViewById(R.id.edit_password);
        signIN = (Button) findViewById(R.id.bntSignin);

        signIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Running",Toast.LENGTH_LONG).show();
                AttemptLogin attemptLogin = new AttemptLogin();
                attemptLogin.execute(edit_usrname.getText().toString(), edit_pass.getText().toString(), "");

            }
        });
    }
    class AttemptLogin extends AsyncTask<String, String, JSONObject> {


        String email = null;
        String password = null;
        String name = null;
        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override
        protected JSONObject doInBackground(String... args) {


            password = args[1];
            name = args[0];

            ArrayList params = new ArrayList();
            params.add(new BasicNameValuePair("username", name));
            params.add(new BasicNameValuePair("password", password));


            JSONObject json = jsonParser.makeHttpRequest(sURL, "POST", params);


            return json;

        }

        protected void onPostExecute(JSONObject result) {


            try {
                int success = result.getInt(TAG_SUCCESS);
                if (success == 1)
                {
                    Intent intent = new Intent(getApplicationContext(), welcomwscreen_S.class);
                   /* intent.putExtra("username",result.getString("name"));
                    intent.putExtra("propic",result.getString("pic"));*/
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


    }
}
