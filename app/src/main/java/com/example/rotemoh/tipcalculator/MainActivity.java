package com.example.rotemoh.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtBillAmount;
    TextView tipResultText;
    CheckBox checkRound;
    final double PERCENT_TIP = 0.12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtBillAmount = (EditText)findViewById(R.id.edtBillAmount);
        tipResultText = (TextView)findViewById(R.id.TipResultText);
        checkRound = (CheckBox)findViewById(R.id.checkRound);
        Button calculate = (Button)findViewById(R.id.btnCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int billAmount = Integer.valueOf(edtBillAmount.getText().toString());
                double tip = (double)billAmount * (PERCENT_TIP);
                if (checkRound.isChecked()) {
                    tip = Math.round(tip);
                }
                tipResultText.setText(" $ " + tip);
            }
        });
    }
}
