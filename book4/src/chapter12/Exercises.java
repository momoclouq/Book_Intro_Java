/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import chapter12.Exceptions.BinaryFormatException;
import chapter12.Exceptions.HexFormatException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class Exercises {
    public static void main(String[] args){
        //ArrayIndexOutOfBounds.start();
        //Hex2Dec.start();
        //Fraction.start();
        //bin2Dec.start();
        
       
        try{
            //removeText.start();
            //Reformat.start();
            //countFile.start();
            //readInSorted.start();
            //addPackage.start();
            //removePackage.start();
            //Ex12_22.start();
            //textFromInternet.start();
            //createDataset.start();
            //createDirectory.start();
            //replaceWord.start();
            //renameFiles.start();
            occurrencesLetter.start();
        } 
        catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class ArrayIndexOutOfBounds{
    public static void start(){
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] dom = {31,28,31,30,31,30,31,31,30,31,30,31};
        
        boolean correctInput = false;
        
        do{
            try {
                int value;
                System.out.print("Enter an integer between 1 and 12: ");
                value = getInput();
                correctInput = true;
                System.out.println("Months: " + months[value - 1] + ", with " + dom[value - 1] + " days");
            }
            catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("index out of bound");
            }
            catch(InputMismatchException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        } while (!correctInput);
        
    }
    
    public static int getInput(){
        int value = 0;
        

            Scanner input = new Scanner(System.in);
            value = input.nextInt();

        
        return value;
    }
}

class Hex2Dec{
    public static void start(){
        Scanner input = new Scanner(System.in);
        boolean correctInput = false;
        do{
            try {
                System.out.print("Enter a hex number: ");
                String hex = input.nextLine();

                checkHex(hex);
                
                correctInput = true;
                System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
            }
            catch (NumberFormatException ex){
                System.out.println("Error: " + ex.getMessage());
            }
            catch(HexFormatException ex){
                System.out.println(ex.getMessage());
            }
        } while (!correctInput);

        
    }      
    
    public static int hexToDecimal(String hex){
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++){
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    
    public static int hexCharToDecimal(char ch){
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else return ch - '0';
    }
    
    public static void checkHex(String hex) throws HexFormatException{
        if (!hex.matches("-?[0-9a-fA-F]+")) throw new HexFormatException();
    }
}

class Fraction{
    public static void start(){
        double num1;
        double num2;
        try{
           Scanner input = new Scanner(System.in);
           System.out.print("Enter upper number: ");
           num1 = input.nextDouble();
           System.out.print("Enter denominator: ");
           num2 = input.nextDouble();
           if (num2 == 0) throw new NullDenominatorException();
           
           System.out.println("Result: " + (num1 / num2));
        }
        catch(NullDenominatorException ex){
            System.out.println("Denominator is 0");
        }
        catch(InputMismatchException ex){
            System.out.println("Wrong input");
        }
    }
}

class bin2Dec{
    public static void start(){
        Scanner input = new Scanner(System.in);
        boolean correctInput = false;
        do{
            try {
                System.out.print("Enter a binary number: ");
                String bin = input.nextLine();

                checkBin(bin);
                
                correctInput = true;
                System.out.println("The decimal value for binary number " + bin + " is " + binToDecimal(bin));
            }
            catch (NumberFormatException ex){
                System.out.println("Error: " + ex.getMessage());
            }
            catch(BinaryFormatException ex){
                System.out.println(ex.getMessage());
            }
        } while (!correctInput);
    }
    
    public static void checkBin(String bin) throws BinaryFormatException{
        if (!bin.matches("[01]+")) throw new BinaryFormatException();
    }
    
    public static long binToDecimal(String bin){
        long result = 0;
        for (int i = 0; i < bin.length(); i++){
            result = result * 2 + bin.charAt(i);
        }
        return result;
    }
}

class removeText{
    public static void start() throws Exception{
        System.out.print("Enter the string and the file name: ");
        Scanner inputT = new Scanner(System.in);
        
        String text = inputT.next();
        String filename= inputT.next();
        System.out.println("text: " + text);
        System.out.println("name: " + filename);
        
        File file = new File(filename);
        if (!file.exists() ||  !file.canRead()){
            System.out.println("File cant be opened or read");
        }
        
        //input
        StringBuilder oldfile = new StringBuilder();
        try(        
                Scanner input = new Scanner(file);
                ){
            while (input.hasNext()){
                String newthings = input.nextLine();
                newthings = newthings.replaceAll(text, "");
                oldfile.append(newthings +"\n");
            }
        }
        
        System.out.println(oldfile);
        
        //output
        if (!file.canWrite()){
            System.out.println("File cannot be written to");
        }
        
        try(
                PrintWriter output = new PrintWriter(file);
                ){
            
            output.print(oldfile.toString());
        } 
    }
}

class Reformat{
    public static void start() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.print("Enter filename: ");
        
        String filename = input.nextLine();
        
        //check file
        File file = new File(filename);
        if(!file.exists() || !file.canRead() || !file.canWrite()){
            System.out.println("FIle cannot be opened or read or written in!");
        }
        
        //input
        String oldfile = "";
        try(
                Scanner Infile = new Scanner(file);
                ){
            while (Infile.hasNext()){
                String line = Infile.nextLine();
                oldfile = oldfile + line;
                oldfile = oldfile + "\n";
            }
            oldfile = oldfile.replaceAll("\n\\s*[{]", "{");
        }
        
        
        //output
        try(
                PrintWriter Outfile = new PrintWriter(file);
                ){
            Outfile.print(oldfile);
        }
        
        System.out.println(oldfile);
    }
}

class countFile{
    public static void start() throws Exception{
        System.out.print("Enter filename: ");
        Scanner input = new Scanner(System.in);
        
        String filename = input.nextLine();
        File file = new File(filename);
        if (!file.exists() || !file.canRead()){
            throw new Exception("file cannot be accessed or read");
        }
        
        //variables
        int numOfLines = 0;
        int numOfWords = 0;
        int numOfCharacters = 0;
        StringBuilder allChar = new StringBuilder();
        //input
        try(
                Scanner in = new Scanner(file);
                ){
            while (in.hasNext()){
                Scanner line = new Scanner(in.nextLine());
                numOfLines++;
                
                while(line.hasNext()){
                    allChar.append(line.next());
                    numOfWords++;
                }
            }
        }
        
        numOfCharacters = allChar.length();
        
        System.out.println("result: " + numOfLines + " lines, " + numOfWords + " words, " + numOfCharacters + " characters" );
    }
}

class readInSorted{
    public static void start() throws Exception{
        System.out.print("Enter filename: ");
        Scanner input = new Scanner(System.in);
        
        String filename = input.nextLine();
        System.out.print("Enter line: ");
        String line = input.nextLine();
        
        //check file
        File file = new File(filename);
        if (!file.exists() || !file.canRead()){
            throw new Exception("File cant be read");
        }
        
        System.out.println("line at: "+readInFile(line, file));
    }
    
    public static int readInFile(String line, File file) throws Exception{
        int num = 1;
        try(
                Scanner input = new Scanner(file);
                ){
            while (input.hasNext()){
                if (line.equals(input.nextLine())) return num;
                num++;
            }
        }
        
        return -1;
    }
}

class addPackage{
    public static void start() throws Exception{
        System.out.print("Enter directory: ");
        Scanner input = new Scanner(System.in);
        String directoryName = input.nextLine();
        
        File folder = new File(directoryName);
        if (!folder.exists() || !folder.isDirectory()){
            throw new Exception("folder does not exist");
        }
        
        for (final File fileEntry: folder.listFiles()){
            StringBuilder text = new StringBuilder();
            try(
                    Scanner In = new Scanner(fileEntry);
                    ){
                
                while(In.hasNext()){
                    text.append(In.nextLine());
                    text.append("\n");
                }
            }
            
            try(
                    PrintWriter Out = new PrintWriter(fileEntry);
                    ){
                Out.println("package chapteri");
                Out.print(text);
            }
        }
        
        System.out.println("Done!");
    }
}

class removePackage{
    public static void start() throws Exception{
        System.out.print("Enter directory: ");
        Scanner input = new Scanner(System.in);
        String directoryName = input.nextLine();
        
        File folder = new File(directoryName);
        changeFolder(folder);
        
        System.out.println("Done!");
    }
    
    public static void changeFolder(final File folder) throws Exception{

        if (!folder.exists() || !folder.isDirectory()){
            throw new Exception("folder does not exist");
        }
        
        for (final File fileEntry: folder.listFiles()){
            if (fileEntry.isDirectory()) {
                System.out.println("Directory: " + fileEntry.getName());
                changeFolder(fileEntry);
            }
            else
            {
                StringBuilder text = new StringBuilder();
                try(
                        Scanner In = new Scanner(fileEntry);
                        ){
                    if (In.hasNext()) {
                        String wtf = In.nextLine();
                        if (!wtf.equals("package chapteri")) {
                            text.append(wtf);
                            text.append("\n");
                        }
                    }
                    
                    while(In.hasNext()){
                        text.append(In.nextLine());
                        text.append("\n");
                    }
                }
            
                try(
                    PrintWriter Out = new PrintWriter(fileEntry);
                    ){
                        Out.print(text);
                    }
            }
        }
    }
}

class Ex12_22{
    public static void start() throws Exception{
        //get inputs
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter directory: ");
        String directoryName = input.nextLine();
        System.out.print("Enter old String: ");
        String oldString = input.nextLine();
        System.out.print("Enter new String: ");
        String newString = input.nextLine();
        
        File file = new File(directoryName);
        changeText(file, oldString, newString);
        
        System.out.println("Done");
    }
    
    public static void changeText(final File file, String oldString, String newString) throws Exception{
        if (!file.exists() || !file.isDirectory()){
            throw new Exception("this is not a file or nor a directory");
        }
        
        for (final File fileMember: file.listFiles()){
            if (fileMember.isDirectory()){
                System.out.println("Directory: " + fileMember.getName());
                changeText(fileMember, oldString, newString);
            }
            else
            {
            
            //get the file IN
            String text = "";
            try(
                    Scanner In = new Scanner(fileMember);
                    ){
                while (In.hasNext()){
                    text = text + (In.nextLine()) + "\n";
                }
            }
            
            text = text.replaceAll(oldString, newString);
            
            //output the Out file
            try(
                    PrintWriter Out = new PrintWriter(fileMember);
                    ){
                Out.print(text);
            }
            }
        }
    }
}

class textFromInternet{
    public static void start(){
        try{
            double sum = 0;
            int count = 0;
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Scores.txt");
            
            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()){
                double value = input.nextDouble();
                System.out.println(value);
                sum += value;
                count++;
            }
            if (count > 0)
                System.out.println("Result: " + count + " average: " + sum/count);
        }
        catch (MalformedURLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        
    }
}

class createDataset{
    public static void start() throws Exception{
        File file = new File("Salary.txt");
        String[] ranks = {"assistant", "associate", "full"};
        
        try(
                PrintWriter Out = new PrintWriter(file);
                ){
            for (int i = 1; i <= 1000; i++){
                int rankPos = (int)(Math.random() * 3);
                double salary = getSalary(rankPos);
                Out.print("FirstName" + i + " LastName" + i + " "+ ranks[rankPos]);
                Out.printf(" %.2f \n", salary);
            }
        }
    }
    
    public static double getSalary(int rankPos){        
        double salary = 0;
        switch (rankPos){
            case 0: 
                salary = (Math.random() * 30001) + 50000;
                break;
            case 1:
                salary = (Math.random() * 50001) + 60000;
                break;
            case 2:
                salary = (Math.random() * 55001) + 75000;
                break;
            default: 
                System.out.println("Rankpos wrong");
                break;
        }
        return salary;
    }
}

class processLargeDataset{
    public static void start(){
        try{
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Salary.txt");
            Scanner input= new Scanner(url.openStream());
            
            //easy :/
        }
        catch (MalformedURLException  ex){
            System.out.println(ex.getMessage());
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

class createDirectory{
    public static void start() throws Exception{
        //prep
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new directory path: ");
        String directoryName = input.nextLine();
        
        File directory = new File(directoryName);        
        System.out.println("absolute path: " + directory.getAbsolutePath());
        if (directory.mkdir()){
            System.out.println("Created successfully");
        } else System.out.println("Directory already exists");
    }
}

class replaceWord{
    public static void start() throws Exception{
        System.out.print("Enter directory: ");
        Scanner input = new Scanner(System.in);
        String directoryName = input.nextLine();
        
        File file = new File(directoryName);
        if(!file.exists() || !file.canRead() ||!file.isDirectory()){
            throw new Exception("File cant be opened or file is not a directory");
        }
        
        for (final File fileMember: file.listFiles()){
            String text = "";
            
            if(!file.canRead() || !file.canWrite()){
                throw new Exception("file member cannot be opened");
            }
            
            try(
                    Scanner In = new Scanner(fileMember);
                    ){
                while (In.hasNext()){
                    String temp = In.nextLine();
                    Scanner Inline = new Scanner(temp);
                
                while(Inline.hasNext()){
                    String wtf = Inline.next();
                    if (wtf.matches("Exercise[1-9][_][1-9]")){
                        StringBuilder wtfT = new StringBuilder(wtf);
                        wtfT.insert(8, '0');
                        wtfT.insert(11, '0');
                        temp = temp.replace(wtf, wtfT.toString());
                    }
                    
                    if (wtf.matches("Exercise[0-9][1-9][_][1-9]")){
                        StringBuilder wtfT = new StringBuilder(wtf);
                        wtfT.insert(10, '0');
                        temp = temp.replace(wtf, wtfT.toString());
                    }
                    
                    if (wtf.matches("Exercise[1-9][_][0-9][0-9]")){
                        StringBuilder wtfT = new StringBuilder(wtf);
                        wtfT.insert(8, '0');
                        temp = temp.replace(wtf, wtfT.toString());
                    }
                }
                
                text = text + temp + "\n";
            }
                }
                
            
            try(
                    PrintWriter Out = new PrintWriter(fileMember);
                    ){
                Out.print(text);
            }
        }
        
        
        System.out.println("Done");
    }
    
}

class renameFiles{
    public static void start() throws Exception{
        System.out.print("Enter directory: ");
        Scanner input = new Scanner(System.in);
        String directoryName = input.nextLine();
        
        File file = new File(directoryName);
        if(!file.exists() || !file.canRead() ||!file.isDirectory()){
            throw new Exception("File cant be opened or file is not a directory");
        }
        
        changeNames(file);

        System.out.println("Done");
    }
    
    public static void changeNames(final File file){
        for (final File fileMember: file.listFiles()){
            try{
                if (!fileMember.canRead() || !fileMember.canWrite())
                    throw new IOException("File member cant be read");
                String oldname = fileMember.getName();
                if(reName(fileMember, file.getName())) System.out.println("file " + oldname + " is changed");
            }
            catch (IOException ex){
                            System.out.println("file " + fileMember.getName() + " cant be read");
            }

        }
    }
    
    public static boolean reName(File file, String diName){
        String name = file.getName();
        System.out.println(name);
        try{
             if (name.matches("Exercise[1-9][_][1-9][.].*")){
                        StringBuilder newname = new StringBuilder(name);
                        newname.insert(8, '0');
                        newname.insert(11, '0');
                        
                        File newfile = new File(diName+"/"+newname.toString());
                        if(file.renameTo(newfile)) return true;
                        else throw new IOException("Name cant be changed");
        }
        
        if (name.matches("Exercise[0-9][1-9][_][1-9][.].*")){
                        StringBuilder newname = new StringBuilder(name);
                        newname.insert(11, '0');
                        
                        File newfile = new File(diName+"/"+newname.toString());
                        if(file.renameTo(newfile)) return true;
                        else throw new IOException("Name cant be changed");
        }
        
        if (name.matches("Exercise[1-9][_][0-9][0-9][.].*")){
                        StringBuilder newname = new StringBuilder(name);
                        newname.insert(8, '0');
                        
                        File newfile = new File(diName+"/"+newname.toString());
                        if(file.renameTo(newfile)) return true;
                        else throw new IOException("Name cant be changed");
        }
        }
        catch (IOException ex){
            System.out.println(file.getName() +" "+ ex.getMessage());
        }
       
        return false;
    }
}

class occurrencesLetter{
    public static void start() throws Exception{
        //prep
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: ");
        
        String filename = input.nextLine();
        File file = new File(filename);
        if(!file.exists() || !file.canRead()){
            throw new IOException("File cant be used");
        }
        
        int[] countAlpha = new int[26];
        prepareArray(countAlpha);
        countOccur(countAlpha, file);
        showResult(countAlpha);
    }
    
    public static void prepareArray(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = 0;
        }
    }
    
    public static void countOccur(int[] array, final File file){
        try(
                Scanner In = new Scanner(file);
                ){
            
            //each line
            while (In.hasNext()){
                String text = In.nextLine();
                text = text.toLowerCase();
                
                for(int i = 0; i < text.length(); i++){
                    if(Character.isLetter(text.charAt(i))){
                        int position = text.charAt(i) - 'a';
                        array[position]++;
                    }
                }
            }
        }
        catch (IOException | IndexOutOfBoundsException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public static void showResult(int[] array){
        for(int i = 0 ; i < array.length; i++){
            char value = (char)('a' + i);
            System.out.println("Number of " + Character.toUpperCase(value) +"s: " + array[i]);
        }
    }
}