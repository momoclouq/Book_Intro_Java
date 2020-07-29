/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter11;

import java.util.ArrayList;

/**
 *
 * @author cis2mye
 */
public class MyStack implements Cloneable{
    private ArrayList<Object> list = new ArrayList<>();
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public int getSize(){
        return list.size();
    }
    
    public Object peek(){
        return list.get(getSize() - 1);
    }
    
    public Object pop(){
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    
    public void push(Object o){
        list.add(o);
    }
    
    @Override
    public String toString(){
        return "stack: " + list.toString();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        MyStack stackClone = (MyStack)super.clone();
        stackClone.list = (ArrayList<Object>) (list.clone());
        return stackClone;
    }
}
