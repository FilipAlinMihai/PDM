package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CereriAnterioare extends AppCompatActivity {
    TextView afisare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cereri_anterioare);
        String em= getIntent().getStringExtra("email");
        afisare=findViewById(R.id.CereriAnterioareA);
        String s="Cererile sunt :\n*";
        DBHelper db;
        db = new DBHelper(this);

        Cursor cursor= db.getdata3();
        cursor.moveToFirst();
        int max1=0;
        while(!cursor.isAfterLast())
        {
            String m=cursor.getString(0);
            String e=cursor.getString(1);
            String d=cursor.getString(2);
            if(em.compareTo(e)==0)
                s=s+m.toUpperCase()+" "+e+" "+d+"\n*";
            cursor.moveToNext();
        }
        afisare.setText(s);
    }
}