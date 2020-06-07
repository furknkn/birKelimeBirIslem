package com.example.furkan.yazilimyapimiodev;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActivityKelime extends AppCompatActivity {

    TextView bth1,bth2,bth3,bth4,bth5,bth6,bth7,txKelime,txw,txtAd,btBonus;
    EditText txBonus;
Button btnSifirla,btnBitir;
String adsss,BonusText;
String[] kelimeler=new String[]{"ga","ss","vv","A"};
List<String> kelimeKontrol=new ArrayList<String>();

    Button btnOnay,btnTekrar;
    String temp;
    int scor=0;

    int[] sayac=new int[]{1,2,3};
    char[] alphabet = "bcdfghjklmnpqrstvyz".toCharArray();
    char[] alphabetSesli = "aeıiuüoö".toCharArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime);
        islem();
    }
void islem()
{

    txKelime=findViewById(R.id.txtKelime);
    txw=findViewById(R.id.adtxt);
    txtAd=findViewById(R.id.txtAd);
    bth1=findViewById(R.id.txt1);
    bth2=findViewById(R.id.txt2);
    bth3=findViewById(R.id.txt3);
    bth4=findViewById(R.id.txt4);
    bth5=findViewById(R.id.txt5);
    bth6=findViewById(R.id.txt6);
    bth7=findViewById(R.id.txt7);
    txBonus=findViewById(R.id.txtBonus);
    btnBitir=findViewById(R.id.btnBitir);
    btnOnay=findViewById(R.id.btnBiter);
    btBonus=findViewById(R.id.star);
    btnTekrar=findViewById(R.id.btnTekrarOyna);
   btnSifirla=findViewById(R.id.btnSifirla);
   txBonus.setText("");
   txBonus.setOnEditorActionListener(new TextView.OnEditorActionListener() {
       @Override
       public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

           Toast.makeText(ActivityKelime.this, txBonus.getText(), Toast.LENGTH_SHORT).show();
         if (txBonus.getText().equals(""))
         {
             BonusText=txBonus.getText().toString();
             Toast.makeText(ActivityKelime.this, BonusText, Toast.LENGTH_SHORT).show();
             btBonus.setText(BonusText);
             txBonus.setVisibility(View.INVISIBLE);
         }
           return false;
       }
   });
txw.setText(getIntent().getExtras().getString("veri"));
   atama();
   btnBitir.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           atama();
       }
   });
   btnTekrar.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

          bitir();

       }
   });
btnOnay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        kontrol();
    }
});
    bth1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            temp=txKelime.getText().toString()+bth1.getText().toString();
            txKelime.setText(temp);
            bth1.setEnabled(false);
        }
    });
    bth2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            temp=txKelime.getText().toString()+bth2.getText().toString();
            txKelime.setText(temp);
            bth2.setEnabled(false);
        }
    });
    bth3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            temp=txKelime.getText().toString()+bth3.getText().toString();
            txKelime.setText(temp);
            bth3.setEnabled(false);
        }
    });
    bth4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            temp=txKelime.getText().toString()+bth4.getText().toString();
            txKelime.setText(temp);
            bth4.setEnabled(false);
        }
    });
    bth5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            temp=txKelime.getText().toString()+bth5.getText().toString();
            txKelime.setText(temp);
            bth5.setEnabled(false);
        }
    });
    bth6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            temp=txKelime.getText().toString()+bth6.getText().toString();
            txKelime.setText(temp);
            bth6.setEnabled(false);
        }
    });
    bth7.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            temp=txKelime.getText().toString()+bth7.getText().toString();
            txKelime.setText(temp);
            bth7.setEnabled(false);
        }
    });
    btBonus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            temp=txKelime.getText().toString()+btBonus.getText().toString();
            txKelime.setText(temp);
            btBonus.setEnabled(false);

        }
    });
btnSifirla.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        tekrar();
    }
});

}
void atama(){
    int i=-1;
    final List<TextView> list=new ArrayList<TextView>();
    list.add(bth1);
    list.add(bth2);
    list.add(bth3);
    list.add(bth4);
    list.add(bth5);
    list.add(bth6);
    list.add(bth7);
    Random rand=new Random();
    sayac[0]=rand.nextInt(7);
    sayac[1]=rand.nextInt(7);
    sayac[2]=rand.nextInt(7);

    for (TextView item:list
            ) {
        item.setEnabled(true);
        i++;
        if (sayac[0]==i){
            item.setText(String.valueOf(alphabetSesli[rand.nextInt(8)]).toUpperCase());
            continue;}
        if (sayac[1]==i){
            item.setText(String.valueOf(alphabetSesli[rand.nextInt(8)]).toUpperCase());
            continue;}
        if (sayac[2]==i){
            item.setText(String.valueOf(alphabetSesli[rand.nextInt(8)]).toUpperCase());
            continue;}

        item.setText(String.valueOf(alphabet[rand.nextInt(18)]).toUpperCase());

    }
    txKelime.setText("");
    scor=0;
}
void kontrol(){
String tempKelime=txKelime.getText().toString();
String s;
boolean kontrol=false;
    for (String item:kelimeler)
    {
        if ( item.equals(tempKelime))
{
    for (String Kitem:kelimeKontrol)
    {
        if (Kitem.equals(tempKelime))

        Toast.makeText(this, "Daha önce kelimeyi kullandınz", Toast.LENGTH_SHORT).show();
        kontrol=true;
    }
    if (kontrol)
        break;
   Toast.makeText(this, tempKelime, Toast.LENGTH_SHORT).show();
    scor+=tempKelime.length();
    tekrar();
    kelimeKontrol.add(tempKelime.toString());


}
    }

}
void tekrar(){
   bth1.setEnabled(true);
    bth2.setEnabled(true);
    bth3.setEnabled(true);
    bth4.setEnabled(true);
    bth5.setEnabled(true);
    bth6.setEnabled(true);
    bth7.setEnabled(true);
btBonus.setEnabled(true);
    txKelime.setText("");
}
void bitir(){
    Toast.makeText(this, "Toplam skorunuz:"+scor, Toast.LENGTH_LONG).show();
    Intent gecis=new Intent(ActivityKelime.this,MainActivity.class);
    startActivity(gecis);
}
}
