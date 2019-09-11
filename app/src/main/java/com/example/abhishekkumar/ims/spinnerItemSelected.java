package com.example.abhishekkumar.ims;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class spinnerItemSelected extends AppCompatActivity {

   // private static final String INS_in_GRP = "http://192.168.1.3/IMS/Groupdata.php";
    private static final String INS_in_GRP = "http://192.168.43.140/IMS/Groupdata.php";
  //  private static final String MAIL_URL = "http://192.168.1.3/IMS/slcfrmgrp.php";
    private static final String MAIL_URL = "http://192.168.43.140/IMS/slcfrmgrp.php";
    TextView slcSpinName;
    EditText editGrpName, editEmail, editName;
    Button btn_InsInGrp, btn_sendMail;
    RequestQueue requestQueue;
    String emailS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_item_selected);
        slcSpinName = (TextView) findViewById(R.id.TV_showgrpSelected);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        Bundle extras = getIntent().getExtras();
        String slcitemName = extras.getString("itmslc");
        slcSpinName.setText("{" + " " + slcitemName + " " + "Group is Selected }");
        editGrpName = (EditText) findViewById(R.id.edit_groupName);
        editGrpName.setText(slcitemName);
        editEmail = (EditText) findViewById(R.id.edit_email);
        editName = (EditText) findViewById(R.id.edit_name);
        btn_sendMail = (Button) findViewById(R.id.btn_sendMail);
        btn_InsInGrp = (Button) findViewById(R.id.btn_insInGrp);
        btn_InsInGrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, INS_in_GRP, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("email", editEmail.getText().toString());
                        parameters.put("name", editName.getText().toString());
                        parameters.put("groupname", editGrpName.getText().toString());

                        return parameters;

                    }
                };
                requestQueue.add(stringRequest);
            }

        });
        btn_sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMAIL();
            }
        });
    }

    private void sendMAIL() {


            StringRequest stringRequest = new StringRequest(Request.Method.POST,MAIL_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {

                                JSONArray jArray = new JSONArray(response);
                                for (int i = 0; i<jArray.length(); i++) {
                                    JSONObject jsonObjectMail = jArray.getJSONObject(i);
                                    emailS =emailS+ jsonObjectMail.getString("email")+",";
                                }
                                emailS=emailS.substring(4,emailS.length()-1);

                                Intent intent = new Intent(spinnerItemSelected.this,grpMail.class);
                                intent.putExtra(
                                        "email",emailS
                                );
                                startActivity(intent);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });

            Volley.newRequestQueue(this).add(stringRequest);
        }

}
