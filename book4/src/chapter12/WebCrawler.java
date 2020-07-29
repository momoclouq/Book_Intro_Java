/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class WebCrawler {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        
        System.out.print("Enter the string to find: ");
        String whatToFind = input.nextLine();
        if (whatToFind.length() == 0){
            System.out.println("String is empty");
        } else
            crawler(url, whatToFind);
    }
    
    public static void crawler(String startingURL, String whatToFind) {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();
        
        listOfPendingURLs.add(startingURL);
        boolean what2do = false;
        while(!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100){
            String urlString = listOfPendingURLs.remove(0);
            
            try{
                URL url = new URL(urlString);
                Scanner input = new Scanner(url.openStream());
                
                
                while (input.hasNext()){
                         String line = input.nextLine();
                         if (line.contains(whatToFind)) {
                            System.out.println("Found -" + whatToFind  +"- at " + urlString);
                            what2do = true;
                            break;
                         }       
                }
               if (what2do) break;
            }
            catch (MalformedURLException ex){
                System.out.println(ex.getMessage());
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
                    
                    
            
            if (!listOfTraversedURLs.contains(urlString)){
                listOfTraversedURLs.add(urlString);
                System.out.println("Crawl " + urlString);
                
                for (String s: getSubURLs(urlString)){
                    if (!listOfTraversedURLs.contains(s))
                        listOfPendingURLs.add(s);
                }
            }
        }
        if (!what2do)
            System.out.println("Dont find anything in 100 links");
    }
    
    public static ArrayList<String> getSubURLs(String urlString){
        ArrayList<String> list = new ArrayList<>();
        
        try{
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while(input.hasNext()){
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while(current > 0){
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0){
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else current = -1;
                }
            }
        }
        catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
        
        return list;
    }
    
}
