package chapter10;


import java.util.ArrayList;
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
        //test
        Account test = new Account("George", 1122, 1000);
        test.setInterest(1.5 /100);
        test.deposit(30);
        test.deposit(40);
        test.deposit(50);
        test.withdraw(5);
        test.withdraw(4);
        test.withdraw(2);
        System.out.println(test);
    }
    
    private int id = 0;
    private String name;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    
    //constructors
    Account(){
        this.dateCreated = new Date();
    }
    
    Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }
    
    Account(String name, int id, double balance){
        this.name = name;
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
        transactions.add(new Transaction('W', amount, this.balance, ""));
        this.balance = this.balance - amount;
    }
    
    public void deposit(double amount){
        transactions.add(new Transaction('D', amount, this.balance, ""));
        this.balance = this.balance + amount;
    }
    
    @Override
    public String toString(){
        String output = this.name + "\n" + "rate: " + this.annualInterestRate + "\n" + "balance: " + this.balance +"\n";
        for (Transaction trans: transactions){
            output = output  + trans.toString();
        }
        
        return output;
    }
}

class Transaction{
    private java.util.Date date;
    private char type;
    private final char withdrawal = 'W';
    private final char deposit = 'D';
    private double amount;
    private double balance;
    private String description;
    
    //constructor
    Transaction(char type, double amount, double balance, String description){
        if (type == withdrawal || type == deposit) this.type = type;
        else System.out.println("Wrong type!");
        this.balance = balance;
        this.amount = amount;
        this.description = description;
        this.date = new Date();
    }
    
    //setters
    public void setDate(Date newDate){
        this.date = newDate;
    }
    
    public void setType(char Type){
        if (type != withdrawal && type != deposit) System.out.println("wrong type!");
        else this.type = type;
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    //getters
    public Date getDate(){
        return this.date;
    }
    
    public char getType(){
        return this.type;
    }
    
    public double getAmount(){
        return this.amount;
    }
    
    public double geBalance(){
        return this.balance;
    }
    
    public String setDescription(){
        return this.description;
    }
    
    @Override
    public String toString(){
        String output = "Transactions: ";
        output = output + this.date + " " + type + " " +amount +" " + description +"\n";
        return output;
    }
}

