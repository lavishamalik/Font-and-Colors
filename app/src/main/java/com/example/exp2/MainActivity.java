package com.example.exp2;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    final String[] color = {"Red", "Blue", "Green", "Black", "Yellow"};
    final String[] font = {"10", "30", "50", "70", "90"};
    TextView targetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinColor = (Spinner) findViewById(R.id.idSpinnerColor);
        spinColor.setOnItemSelectedListener(this);
        Spinner spinFont = (Spinner) findViewById(R.id.idSpinnerFont);
        spinFont.setOnItemSelectedListener(this);
        final ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, color);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinColor.setAdapter(aa1);
        final ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, font);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinFont.setAdapter(aa2);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        targetText=findViewById(R.id.tvText);
        switch(parent.getId()){
            case R.id.idSpinnerColor :
                String clr=parent.getSelectedItem().toString();
                targetText.setTextColor(Color.parseColor(clr));
                break;
            case R.id.idSpinnerFont :
                String font=parent.getSelectedItem().toString();
                targetText.setTextSize(Float.parseFloat(font));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}