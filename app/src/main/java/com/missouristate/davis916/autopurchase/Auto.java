package com.missouristate.davis916.autopurchase;

/**
 * Laura Davis CIS 262-902
 * 2 March 2018
 * Creates the data model for an auto
 */

public class Auto {
    //Declare and initialize final variables
    static final double STATE_TAX = 0.07;
    static final double INTEREST_RATE = 0.09;

    //Declare private variables
    private double mPrice;
    private double mDownPayment;
    private int mLoanTerm;

    //Sets price
    public void setPrice(double price){
        mPrice = price;
    }

    //Gets price
    //@Return mPrice
    public double getPrice(){
        return mPrice;
    }

    //Sets down payment
    public void setDownPayment(double down){
        mDownPayment = down;
    }

    //Gets down payment
    //@return mDownPayment
    public double getDownPayment(){
        return mDownPayment;
    }

    //Sets loan term according to if-else statement and char
    public void setLoanTerm(String term){
        if(term.contains("2"))
            mLoanTerm = 2;
        else if(term.contains("3"))
            mLoanTerm = 3;
        else
            mLoanTerm = 4;
    }//end setLoanTerm()

    //gets loan term
    //@return mLoanTerm
    public int getLoanTerm(){
        return mLoanTerm;
    }

    //Calculates tax amount
    //@return mPrice * STATE_TAX
    public double taxAmount(){
        return mPrice * STATE_TAX;
    }

    //Calculates total cost
    //@return mPrice + taxAmount()
    public double totalCost(){
        return mPrice + taxAmount();
    }

    //Calculates borrowed amount
    //@return totalCost() - mDownPayment
    public double borrowedAmount(){
        return totalCost() - mDownPayment;
    }

    //Calculates interest amount
    //@return borrowedAmount() * INTEREST_RATE
    public double interestAmount(){
        return borrowedAmount() * INTEREST_RATE;
    }

    //Calculates monthly payment
    //@return borrowedAmount() / mLoanTerm * 12
    public double monthlyPayment(){
        return borrowedAmount() / (mLoanTerm * 12);
    }

}//end Auto class
