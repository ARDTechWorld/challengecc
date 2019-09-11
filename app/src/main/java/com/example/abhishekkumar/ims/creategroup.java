package com.example.abhishekkumar.ims;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class creategroup extends AppCompatActivity {

    ArrayList<String>  listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    RequestQueue requestQueue;
   // private static final String inserturl = "http://192.168.1.3/IMS/createGroup.php";
    private static final String inserturl = "http://192.168.43.140/IMS/createGroup.php";
    EditText edit_groupName;
    Button btn_save, btn_done;
    Spinner selectGrpSpinner;
    String itemSeleced;
    Intent intentSpinner;

  @Override
    protected void onStart() {
        super.onStart();
        groupSpinner gs =new groupSpinner();
        gs.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creategroup);

        edit_groupName = (EditText) findViewById(R.id.edit_groupName);
        btn_save = (Button) findViewById(R.id.btn_save);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        btn_done = (Button) findViewById(R.id.btn_done);
        selectGrpSpinner = (Spinner) findViewById(R.id.selectGrp_spinner);
        adapter = new ArrayAdapter<String>(this,R.layout.selectgrpspinner,R.id.spinnerTV,listItems);
        selectGrpSpinner.setAdapter(adapter);
        selectGrpSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               itemSeleced = parent.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSpinner = new Intent(creategroup.this,spinnerItemSelected.class);
                intentSpinner.putExtra("itmslc",itemSeleced);
                startActivity(intentSpinner);
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, inserturl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        groupSpinner gs1 =new groupSpinner();
                        gs1.execute();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();

                        parameters.put("groupname", edit_groupName.getText().toString());
                        return parameters;
                    }
                };

                requestQueue.add(stringRequest);
                //Toast.makeText(getApplicationContext(),"running" ,Toast.LENGTH_LONG).show();
                //groupSpinner gs1 =new groupSpinner();
                //gs1.execute();
            }
        });


    }


    private class groupSpinner extends AsyncTask<String, String, String> {




        ArrayList<String> list;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            list = new ArrayList<>();
        }

        @Override
        protected String doInBackground(String... strings) {
            InputStream is = null;
            String result = "";
            try {
                HttpClient httpClient = new DefaultHttpClient();
               // HttpPost httpPost = new HttpPost("http://192.168.1.3/IMS/selectGroup.php");
                HttpPost httpPost = new HttpPost("http://192.168.43.140/IMS/selectGroup.php");
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //converting the response to String.....
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "utf-8"));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                is.close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //parsing to JSON ...

            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i= 0; i<=jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    list.add(jsonObject.getString("groupname"));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listItems.addAll(list);
            adapter.notifyDataSetChanged();
           /* Intent intent = new Intent(creategroup.this, creategroup.class);
            startActivity(intent);*/
        }
    }
}


//http://gninfotech.org/ims/

