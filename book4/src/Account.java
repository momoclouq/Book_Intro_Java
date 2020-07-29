
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cis2mye
 */
public class Account {
    
    public static void main(String[] args){
        //just do it
    }
    
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;
    
    Account(){
        this.dateCreated = new Date();
    }
    
    Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }
    
    //accessors
    public int getId(){
        return this.id;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public static double getInterest(){
        return annualInterestRate;
    }
    
    public Date getDate(){
        return dateCreated;
    }
    
    //mutators
    public void setId(int id){
         this.id = id;
    }
    
    public void getBalance(double balance){
        this.balance = balance;
    }
    
    public static void setInterest(double interest){
        annualInterestRate = interest;
    }
    
    //methods
    public double getMonthlyInterestRate(){
        return getInterest() / 12;
    }
    
    public double getMonthlyInterest(){
        return this.getBalance() * this.getMonthlyInterestRate();
    }
    
    public void withdraw(double amount){
        this.balance = this.balance - amount;
    }
    
    public void deposit(double amount){
        this.balance = this.balance + amount;
    }
}
