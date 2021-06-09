package com.example.matko_zavrsni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    private TextView text;
    private double provjes1;
    private  double provjes2;
    private double provjes3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        text = (TextView) findViewById(R.id.provjesi);
        Intent intent= getIntent();
        provjes1=intent.getDoubleExtra("provjes",1);
        provjes2=intent.getDoubleExtra("provjes1",1);
        provjes3=intent.getDoubleExtra("provjes2",1);
        text.setText("Provjesi za temperature(-5,-20-40) su:"+provjes1+","+provjes2+","+provjes3);

        Log.d("provjes2", String.valueOf((provjes2)));
    }
}