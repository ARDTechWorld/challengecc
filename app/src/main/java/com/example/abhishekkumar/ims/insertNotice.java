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

public class insertNotice extends AppCompatActivity {

    RequestQueue requestQueue;

   // private static final String inserturl = "http://192.168.1.3/IMS/insertNotice.php";
    private static final String inserturl = "http://192.168.43.140/IMS/insertNotice.php";
    EditText editHeading, editDec, editSign, editDate;
    Button btn_ins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_notice);
        editHeading  = (EditText) findViewById(R.id.edit_heading);
        editDec  = (EditText) findViewById(R.id.edit_desc);
        editSign  = (EditText) findViewById(R.id.edit_sign);
        editDate  = (EditText) findViewById(R.id.edit_date);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        btn_ins = (Button) findViewById(R.id.btn_ins);

        btn_ins.setOnClickListener(new View.OnClickListener() {
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
                        parameters.put("heading",editHeading.getText().toString());
                        parameters.put("description",editDec.getText().toString());
                        parameters.put("sign",editSign.getText().toString());
                        parameters.put("n_date",editDate.getText().toString());

                        return parameters;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
    }
}
