package com.example.temperature_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    Button ansBtn, clearBtn;
    TextView showAns;
    EditText getVal;
    RadioButton c2f, f2c;
    Double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ansBtn = findViewById(R.id.ansBtn);
        clearBtn = findViewById(R.id.clearBtn);
        showAns = findViewById(R.id.showAns);
        getVal = findViewById(R.id.editText1);

        c2f = findViewById(R.id.c2f);
        f2c = findViewById(R.id.f2c);

        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getVal.getText().toString().isEmpty()){
                    showAns.setText("Please enter temperature");
                }
                else {
                    x = Double.parseDouble(String.valueOf(getVal.getText()));

                    if (c2f.isChecked()){
                        x = (x*9)/5+32;

                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));

                        showAns.setText(String.valueOf(x) + "Degree");
                    }
                    else if (f2c.isChecked()){
                        x = (x-32)*5/9;

                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));

                        showAns.setText(String.valueOf(x) + "Degree");
                    }
                    else {
                        showAns.setText("Please select an option");
                    }
                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAns.setText("0.0");
                getVal.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });

    }
}