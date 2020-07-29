/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter9_test;

/**
 *
 * @author cis2mye
 */
public class C1 {
    public C1(){
        C2 c2 = new C2();
        c2.showTent();
    }
}

class C2{
    private int tent = 1;
    
    C2(){
        
    }
    
    void showTent(){
        System.out.println(tent);
    }
}