package com.example.testapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String code = "0.72x0.355x0.438x0.266x0.245x0.658x0.918x0.4x1.0x0.002x0.329x0.597x0.172x0.988x-0.228x-0.052x0.534x0.505x0.2x0.608x0.231x0.215x0.326x0.067x0.449x-0.388x0.831x-0.381x0.339x0.297x0.276x-0.161x0.116x0.029x0.002x0.269x-0.288x0.188x-0.098x-0.012x-0.144x0.479x0.099x-0.395x-0.061x0.153x-0.055x0.031x-0.304x-0.162x0.307x0.138x-0.103x-0.478x0.186x-0.18x0.109x-0.412x-0.173x-0.265x-0.546x-0.699x-0.488x-0.519x0.162x-0.071x-0.339x-0.226x0.761x-0.321x-0.039x0.189x-0.048x0.426x-0.45x0.648x-0.194x0.435x-0.188x0.757x-0.16x0.121x0.349x-0.189x0.271x0.688x0.04x0.202x0.115x0.003x0.257x0.359x0.09x0.435x0.09x-0.027x0.062x0.295x0.306x-0.098x0.17x0.091x0.036x-0.251x-0.029x-0.194x-0.013x-0.148x-0.388x0.188x-0.495x0.179x-0.325x-1.14x0.213x-0.07x-0.476x0.056x-0.298x-0.603x-0.17x-0.153x-0.529x-0.161x0.284x-0.785x-0.15x-0.754x-0.1x-0.522x-0.571x-0.338x-0.155x0.145x-0.449x-0.093x-0.252x-0.045x-0.092x-0.348x0.126x-0.092x-0.161x0.405x-0.426x-0.066x0.102x-0.07x0.016x0.146x-0.277x0.322x0.083x-0.093x0.321x-0.446x-0.136x0.376x-0.012x-0.151x-0.321x0.265x-0.032x0.175x-0.349x0.033x-0.081x0.107x-0.052x-0.153x0.13x-0.182x0.098x0.13x-0.118x0.076x-0.346x0.487x-0.688x0.022x0.134x0.074x-0.003x-0.537x0.122x-0.016x-0.362x-0.154x-0.039x0.187x-0.404x-0.237x0.312x-0.224x-0.696x0.012x0.487x-0.245x-0.273x-0.19x0.273x0.029x-0.8x0.246x-0.285x-0.069x-0.105x-0.212x-0.337x0.22x-0.383x0.01x0.24x-0.533x0.029x-0.31x-0.098x-0.146x-0.503x0.116x-0.355x-0.233x-0.038x-0.258x-0.698x0.038x-0.183";
    public static final String API_BASE_URL = "http://192.168.1.7:8000/predict/?intensity=";

    TextView tv_input, tv_output;
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_input = findViewById(R.id.input);
        tv_output = findViewById(R.id.output);
        btn_ok = findViewById(R.id.send);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                API_BASE_URL + code,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("e Rest Response", error.toString());
                    }
                }

        );

        requestQueue.add(objectRequest);

    }
}


