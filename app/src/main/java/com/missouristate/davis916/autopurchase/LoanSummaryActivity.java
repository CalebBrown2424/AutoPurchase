package com.missouristate.davis916.autopurchase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

/**
 * Laura Davis CIS 262-902
 * 26 February 2018
 * Passes data from intent to display
 */


public class LoanSummaryActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loansummary_layout);
        TextView monthlyPayET = (TextView)findViewById(R.id.textView2_2);
        TextView loanReportET = (TextView)findViewById(R.id.textView3_2);

        //Pass data
        Intent intent = getIntent();

        String report;
        report = intent.getStringExtra("LoanReport");

        String monthlyPay;
        monthlyPay = intent.getStringExtra("MonthlyPayment");
        monthlyPayET.setText(monthlyPay);
        loanReportET.setText(report);
    }//end onCreate()

    public void goDataEntry(View view){
        finish();
    }
}//end LoanSummaryActivity
