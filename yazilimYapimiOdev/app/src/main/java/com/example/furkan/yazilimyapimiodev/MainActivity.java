package com.example.furkan.yazilimyapimiodev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnKelime,btnIslem;
    EditText txAd;
   String AD="aa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
islem();

    }
    void islem(){

        btnKelime=findViewById(R.id.btnKelime);
        txAd=findViewById(R.id.txtAd);
        AD=txAd.getText().toString();
btnIslem=findViewById(R.id.btnIslem);
btnIslem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent gecis =new Intent(MainActivity.this,ActivityIslem.class);
        gecis.putExtra("veri",txAd.getText().toString());
        startActivity(gecis);
    }
});
        btnKelime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecis=new Intent(MainActivity.this,ActivityKelime.class);
            gecis.putExtra("veri",txAd.getText().toString());
                startActivity(gecis);
            }
        });
    }
}
