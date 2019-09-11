package com.example.abhishekkumar.ims;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class addStudentForm extends AppCompatActivity {

    RequestQueue requestQueue;

//    private static final String inserturl = "http://192.168.1.3/IMS/insertstudent.php";
    private static final String inserturl = "http://192.168.43.140/IMS/insertstudent.php";
    EditText edit_name, edit_batch, edit_phone, edit_password, edit_email;
    Button btn_insertData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_form);
        btn_insertData = (Button) findViewById(R.id.btn_insert);
        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_batch = (EditText) findViewById(R.id.edit_batch);
        edit_phone = (EditText) findViewById(R.id.edit_phone);
        edit_password = (EditText) findViewById(R.id.edit_password);
        edit_email = (EditText) findViewById(R.id.edit_email);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        btn_insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, inserturl, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> parameters = new HashMap<String, String>();
                                parameters.put("name",edit_name.getText().toString());
                                parameters.put("batch",edit_batch.getText().toString());
                                parameters.put("password",edit_password.getText().toString());
                                parameters.put("phone",edit_phone.getText().toString());
                                parameters.put("email",edit_email.getText().toString());

                                return parameters;
                            }
                        };
                        requestQueue.add(stringRequest);
                    }
                });
        }
}
