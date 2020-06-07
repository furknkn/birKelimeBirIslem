package com.example.furkan.yazilimyapimiodev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ActivityIslem extends AppCompatActivity {
TextView cir1,cir2,cir3,cir4,cir5,cir6,txSonuc,islemSonuc,istenilenSayi,islemAd;

String temp;
int islemler=0,s2;
boolean sonSayi=false;
ImageView arti,eksi,carpi,bolu;
int[] sayilar=new int[6];
Button btnSifirla,btnBitir,btnKekrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islem);

        islem();
        atama();
        kapaAc();
    }
    void islem()
    {
        islemSonuc=findViewById(R.id.txtIslemSonuc);
txSonuc=findViewById(R.id.txtSonuc);
istenilenSayi=findViewById(R.id.txistenilenSayi);
        cir1=findViewById(R.id.cir1);
        islemAd=findViewById(R.id.txtIslemAd);
        cir2=findViewById(R.id.cir2);
        cir3=findViewById(R.id.cir3);
        cir4=findViewById(R.id.cir4);
        cir5=findViewById(R.id.cir5);
        cir6=findViewById(R.id.cir6);
        arti=findViewById(R.id.pls);
        eksi=findViewById(R.id.minus);
        carpi=findViewById(R.id.carpi);
        bolu=findViewById(R.id.bolme);
        btnBitir=findViewById(R.id.islemBitir);
        btnKekrar=findViewById(R.id.islemTekarar);
        islemAd.setText(getIntent().getExtras().getString("veri"));
        btnSifirla=findViewById(R.id.islemSifirla);
        btnSifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islemSonuc.setText("0");
                txSonuc.setText("");
                s2=0;
                sonSayi=false;
                kapaAc();
            }
        });
        btnKekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atama();
                islemSonuc.setText("0");
                txSonuc.setText("");
                s2=0;
                sonSayi=false;
                kapaAc();
            }
        });
        btnBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(istenilenSayi.getText().toString())-10<Integer.parseInt(islemSonuc.getText().toString()) && Integer.parseInt(istenilenSayi.getText().toString())>Integer.parseInt(islemSonuc.getText().toString()))
                {
                    Toast.makeText(ActivityIslem.this, "Kazandınız", Toast.LENGTH_SHORT).show();
                    Intent gedis=new Intent(ActivityIslem.this,MainActivity.class);
                    startActivity(gedis);
                }
                else
                    Toast.makeText(ActivityIslem.this, "Hatalı", Toast.LENGTH_SHORT).show();
            }
        });

        cir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
temp=txSonuc.getText().toString()+cir1.getText().toString();
txSonuc.setText(temp);
s2=Integer.parseInt(cir1.getText().toString());
call();
sonSayi=true;
kapaAc();


            }
        });
        cir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=txSonuc.getText().toString()+cir2.getText().toString();
                txSonuc.setText(temp);
                s2=Integer.parseInt(cir2.getText().toString());
                sonSayi=true;
                kapaAc();

            }
        });
        cir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=txSonuc.getText().toString()+cir3.getText().toString();
                s2=Integer.parseInt(cir3.getText().toString());

                txSonuc.setText(temp);
                call();
                sonSayi=true;
kapaAc();
            }
        });
        cir4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=txSonuc.getText().toString()+cir4.getText().toString();
                txSonuc.setText(temp);
                s2=Integer.parseInt(cir4.getText().toString());
                call();
                sonSayi=true;
                kapaAc();
            }
        });
        cir5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=txSonuc.getText().toString()+cir5.getText().toString();
                txSonuc.setText(temp);
                s2=Integer.parseInt(cir5.getText().toString());
                call();
                sonSayi=true;
                kapaAc();
            }
        });
        cir6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=txSonuc.getText().toString()+cir6.getText().toString();
                txSonuc.setText(temp);
                s2=Integer.parseInt(cir6.getText().toString());
                call();
            sonSayi=true;
            kapaAc();
            }
        });
        arti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=txSonuc.getText().toString()+"+";
                txSonuc.setText(temp);
                islemler=1;
                sonSayi=false;
                kapaAc();
            }
        });
        eksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=txSonuc.getText().toString()+"-";
                txSonuc.setText(temp);
                islemler=2;
                sonSayi=false;
                kapaAc();
            }
        });
        carpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=txSonuc.getText().toString()+"x";
                txSonuc.setText(temp);
                islemler=3;
                sonSayi=false;
                kapaAc();
            }
        });
        bolu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=txSonuc.getText().toString()+"/";
                txSonuc.setText(temp);
                islemler=4;
                sonSayi=false;
                kapaAc();
            }
        });

    }
    void atama(){

        Random rand=new Random();

istenilenSayi.setText(String.valueOf(rand.nextInt(1000)));
        cir1.setText((String.valueOf(rand.nextInt(10))));
        cir2.setText((String.valueOf(rand.nextInt(10))));
        cir3.setText((String.valueOf(rand.nextInt(10))));
        cir4.setText((String.valueOf(rand.nextInt(10))));
        cir5.setText((String.valueOf(rand.nextInt(10))));
        cir6.setText((String.valueOf(rand.nextInt(10)*10)));

    }
    void call(){
        int sayi1,sayi2;
        sayi1=Integer.parseInt(islemSonuc.getText().toString());
        sayi2=s2;
        if (islemler==0){}
        else if(islemler==1)
        {
islemSonuc.setText(String.valueOf(sayi1+sayi2));
        }
        else if(islemler==2)
        {

            islemSonuc.setText(String.valueOf(sayi1-sayi2));
        }
        else if(islemler==3)
        {

            islemSonuc.setText(String.valueOf(sayi1*sayi2));
        }
        else{
            islemSonuc.setText(String.valueOf(sayi1/sayi2));}
    }
void kapaAc()
{
    if (sonSayi==true)
    {
        cir2.setEnabled(false);
        cir1.setEnabled(false);
        cir3.setEnabled(false);
        cir4.setEnabled(false);
        cir5.setEnabled(false);
        cir6.setEnabled(false);
        arti.setEnabled(true);
        eksi.setEnabled(true);
        carpi.setEnabled(true);
        bolu.setEnabled(true);

    }
    if(sonSayi==false){
        cir1.setEnabled(true);
    cir2.setEnabled(true);
    cir3.setEnabled(true);
    cir4.setEnabled(true);
    cir5.setEnabled(true);
    cir6.setEnabled(true);
    arti.setEnabled(false);
    eksi.setEnabled(false);
    carpi.setEnabled(false);
    bolu.setEnabled(false);}

}

    }

