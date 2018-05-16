package com.missouristate.davis916.autopurchase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/*
* Laura Davis CIS 262-902
* 2 March 2018
* This is the app's main java file
* and is responsible for creating
* auto objects and instantiating intents.
*/

//The application's main activity
public class PurchaseActivity extends AppCompatActivity {

    //The auto object contains the info about vehicle being purchased
    Auto mAuto;

    //The data to be passed to the loan activity
    String loanReport;
    String monthlyPayment;

    //Layout input references
    private EditText carPriceET;
    private EditText downPayET;
    private RadioGroup loanTermRG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_purchase);

        //Establish references to editable text fields and radio button
        carPriceET = (EditText)findViewById(R.id.editText);
        downPayET = (EditText)findViewById(R.id.editText2);
        loanTermRG = (RadioGroup)findViewById(R.id.radioGroup);

        //Create an auto object to store data
        mAuto = new Auto();

    }//end onCreate()

    //Collects input data for auto object created in onCreate()
    private void collectAutoInputData(){
        //Set car price
        mAuto.setPrice((double)Integer.valueOf(carPriceET.getText().toString()));

        //Set down payment
        mAuto.setDownPayment((double)Integer.valueOf(downPayET.getText().toString()));

        //Set the loan term
        Integer radioId = loanTermRG.getCheckedRadioButtonId();
        RadioButton term = (RadioButton)findViewById(radioId);
        mAuto.setLoanTerm(term.getText().toString());
    }//end collectAutoInputData()

    //Constructs monthly payment and loan report
    private void buildLoanReport(){

        //Construct monthly payment
        Resources res = getResources();
        monthlyPayment = res.getString(R.string.report_line1)
                + String.format("%.02f", mAuto.monthlyPayment());

        //Construct the loan report
        loanReport =
                String.format("%-20s %8s %.02f\n", res.getString(R.string.report_line6), " $", mAuto.getPrice());
        loanReport +=
                String.format("%-20s %5s %.02f\n", res.getString(R.string.report_line7), " $", mAuto.getDownPayment());
        loanReport +=
                String.format("%-20s %6s %.02f\n", res.getString(R.string.report_line9), " $", mAuto.taxAmount());
        loanReport +=
                String.format("%-20s %12s %.02f\n", res.getString(R.string.report_line10), " $", mAuto.totalCost());
        loanReport +=
                String.format("%-20s %s %.02f\n", res.getString(R.string.report_line11), " $", mAuto.borrowedAmount());
        loanReport +=
                String.format("%-20s %6s %.02f\n", res.getString(R.string.report_line12), " $", mAuto.interestAmount());

        loanReport += "\n" + res.getString(R.string.report_line8)
                + " " + mAuto.getLoanTerm() + " years.";
        loanReport += "\n" + res.getString(R.string.report_line2);
        loanReport += res.getString(R.string.report_line3);
        loanReport += res.getString(R.string.report_line4);
        loanReport += res.getString(R.string.report_line5);

    }//end buildLoanReport()

    //Builds loan report, creates intent for loan summary activity, and
    //passes activity into loan report with details and monthly payment.
    public void activateLoanSummary(View view){

        //Build a loan report from input data
        collectAutoInputData();
        buildLoanReport();

        //Create an intent to display the loan summary activity
        Intent launchReport = new Intent(this, LoanSummaryActivity.class);

        //Pass the loan summary activity two pieces of data:
        //The loan report containing details and the monthly payment
        launchReport.putExtra("LoanReport", loanReport);
        launchReport.putExtra("MonthlyPayment", monthlyPayment);

        //Start the loan activity
        startActivity(launchReport);
    }//end activateLoanSummary()

    //Menu settings
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }//end createOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button,
        //as long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }//end onOptionsItemSelected


}//end PurchaseActivity
