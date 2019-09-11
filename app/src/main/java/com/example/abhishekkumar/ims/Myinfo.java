package com.example.abhishekkumar.ims;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Myinfo extends Fragment {

   // private static final String SHOW_URL = "http://192.168.1.3/IMS/facultyInfo.php";
    private static final String SHOW_URL = "http://192.168.43.140/IMS/facultyInfo.php";
    TextView tvtype, tvid, tvsub, tvattn, tvsal;

    RequestQueue requestQueue;
    View view;
    public Myinfo() {


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.myinfo, container ,false);
        requestQueue = Volley.newRequestQueue(view.getContext());
        tvtype = (TextView) view.findViewById(R.id.txttypeVal);
        tvid = (TextView) view.findViewById(R.id.txtIdVal);
        tvsub = (TextView) view.findViewById(R.id.txtSubVal);
        tvattn = (TextView) view.findViewById(R.id.txtAttVal);
        tvsal = (TextView) view.findViewById(R.id.txtSalVal);
        showInfo();
        return view;

    }

    private void showInfo() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,SHOW_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray jArray = new JSONArray(response);
                            for (int i = 0; i<jArray.length(); i++) {
                                JSONObject info = jArray.getJSONObject(i);

                                String acctype = info.getString("acctype");
                                String fid = info.getString("fid");
                                String fsub = info.getString("fsub");
                                String fattn = info.getString("fattn");
                                String fsal = info.getString("fsal");

                                tvtype.setText(acctype);
                                tvid.setText(fid);
                                tvsub.setText(fsub);
                                tvattn.setText(fattn);
                                tvsal.setText(fsal);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}
