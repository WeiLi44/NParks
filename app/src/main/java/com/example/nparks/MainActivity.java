package com.example.nparks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final String EXT_URL = "extURL";
    ListView listView;
    WebView webView;
    String[] parks = {"East Coast Park","Gardens by the Bay","MacRitchie Reservoir Park"};

    Button btnVid;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        webView = findViewById(R.id.webView);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, parks);
        listView.setAdapter(arrayAdapter);
        listView.getSelectedItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if (pos == 0){
                    launchtoExternal("https://www.nparks.gov.sg/");
                }
                else if(pos == 1){
                    launchtoExternal("https://www.nparks.gov.sg/gardens-parks-and-nature/heritage-roads");
                }
                else if (pos == 2){
                    launchtoExternal("https://www.nparks.gov.sg/gardens-parks-and-nature/heritage-trees");
                }
            }
        });

        // this button leads to Video
        btnVid = findViewById(R.id.btnVid);
        btnVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                Toast.makeText(getApplicationContext(), "Let's Go", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    void launchtoExternal(String extURL){
        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        intent.putExtra(EXT_URL, extURL);
        startActivity(intent);
    }
}