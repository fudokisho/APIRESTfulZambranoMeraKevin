package com.example.apirestful;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apirestful.WebService.Asynchtask;
import com.example.apirestful.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void ver (View view) {
            Map<String, String> datos = new HashMap<String, String>();
            WebService ws= new WebService(
                    "https://jsonplaceholder.typicode.com/users",
                    datos, MainActivity.this, MainActivity.this);
            ws.execute("GET");

        }

    @Override
    public void processFinish(String result) throws JSONException {
        String listaNombre="";

        JSONArray listaJson = new JSONArray(result);
        for (int i=0; i<listaJson.length();i++)
        {
            JSONObject info=listaJson.getJSONObject(i);
            listaNombre=listaNombre+"\n"+info.getString("name").toString()+info.getString("email").toString();

        }
        TextView consulta = (TextView)findViewById(R.id.txtmostrar);
        consulta.setText("NOMBRES"+"\n" + listaNombre);


    }
}