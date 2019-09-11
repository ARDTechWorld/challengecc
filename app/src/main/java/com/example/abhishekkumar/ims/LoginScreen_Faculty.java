package com.example.abhishekkumar.ims;

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

public class LoginScreen_Faculty extends AppCompatActivity {

    JSONParser jsonParser = new JSONParser();
    private static final String TAG_SUCCESS = "success";
    //String URL = "http://192.168.1.3/IMS/login.php";
    String URL = "http://192.168.43.140/IMS/login.php";
    EditText edit_Email, edit_Password;
    Button btn_SignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen__faculty);
        edit_Email = (EditText) findViewById(R.id.edit_username);
        edit_Password = (EditText) findViewById(R.id.edit_password);
        btn_SignIn = (Button) findViewById(R.id.bntSignin);

        btn_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Running",Toast.LENGTH_LONG).show();
                AttemptLogin attemptLogin = new AttemptLogin();
                attemptLogin.execute(edit_Email.getText().toString(), edit_Password.getText().toString(), "");

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


            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);


            return json;

        }

        protected void onPostExecute(JSONObject result) {


            try {
                int success = result.getInt(TAG_SUCCESS);
                if (success == 1)
                {
                    Intent intent = new Intent(getApplicationContext(), welcomeScreen_F.class);
                    intent.putExtra("username",result.getString("name"));
                    intent.putExtra("propic",result.getString("pic"));
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
