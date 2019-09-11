package com.example.abhishekkumar.ims;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class shownotice extends AppCompatActivity {

   // private static final String NOTICE_URL = "http://192.168.1.3/IMS/notice1.php";
    private static final String NOTICE_URL = "http://192.168.43.140/IMS/notice1.php";
    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownotice);
        productList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.r1);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        showNotice();
    }
    private void showNotice() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, NOTICE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray jArray = new JSONArray(response);
                            for (int i = 0; i<jArray.length(); i++) {

                                JSONObject jsonObjectNotice = jArray.getJSONObject(i);

                                int id = jsonObjectNotice.getInt("n_id");
                                String heading = jsonObjectNotice.getString("heading");
                                String description = jsonObjectNotice.getString("description");
                                String sign = jsonObjectNotice.getString("sign");
                                String date = jsonObjectNotice.getString("n_date");

                                Product product = new Product(id, heading, description, sign, date);
                                productList.add(product);
                            }
                            ProductAdapter adapter = new ProductAdapter(shownotice.this, productList);
                            recyclerView.setAdapter(adapter);
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
