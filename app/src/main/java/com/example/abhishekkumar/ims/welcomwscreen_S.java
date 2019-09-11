package com.example.abhishekkumar.ims;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.List;

public class welcomwscreen_S extends AppCompatActivity {
    Button btn_viewNotice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomwscreen__s);

        btn_viewNotice = (Button) findViewById(R.id.btn_viewNotice);

        btn_viewNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(welcomwscreen_S.this,shownotice.class);
                startActivity(intent);
            }
        });
    }

}
