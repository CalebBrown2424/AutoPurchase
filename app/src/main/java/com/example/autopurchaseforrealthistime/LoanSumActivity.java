package com.example.autopurchaseforrealthistime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class LoanSumActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loansummary_layout);
        TextView monthlyPayET = (TextView) findViewById(R.id.textview22);
        TextView loanReportET = (TextView) findViewById(R.id.textview33);


        Intent intent = getIntent();

        String report;
        report = intent.getStringExtra("LoanReport");

        String monthlyPay;
        monthlyPay = intent.getStringExtra("MonthlyPayment");

        loanReportET.setText(report);
        monthlyPayET.setText(monthlyPay);
    }
    public void goDataEntry(View view){
        finish();
    }
}
