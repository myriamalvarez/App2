package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView TVFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        acceder();
    }
    @SuppressLint("Range")
    private void acceder(){
        TVFinal = findViewById(R.id.TVFinal);
        Uri llamadas = Uri.parse("content://call_log/calls");
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(llamadas,null,null,null,null);
        String nro = null;
        String tiempo = null;

        if(c != null && c.getCount()>0){
            StringBuilder sb = new StringBuilder();
            while (c.moveToNext()){
                nro = c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));
                tiempo = c.getString(c.getColumnIndex(CallLog.Calls.DURATION));
                sb.append("numero:"+nro+" duracion:"+tiempo+" \n");
            }
            TVFinal.setText(sb.toString());
        }else{
            TVFinal.setText("sin datos");
        }
    }
}