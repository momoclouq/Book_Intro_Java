/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10;

import java.util.ArrayList;

/**
 *
 * @author cis2mye
 */
public class Course implements Cloneable{
    public static void main(String[] args){
        
    }
    
    private String courseName;
    private ArrayList<String> students = new ArrayList<>();
    
    public Course(String courseName){
        this.courseName = courseName;
    }
    
    public void addStudent(String student){
        students.add(student);
    }
    
    public ArrayList getStudents(){
        return students;
    }
    
    public void setStudents(ArrayList<String> students){
        this.students = students;
    }
    
    public int getNumberOfStudents(){
        return students.size();
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public void dropStudent(String student){
        students.remove(student);
    }
    
    public void clear(){
        students.clear();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Course courseClone = (Course)super.clone();
        courseClone.setStudents((ArrayList<String>)this.getStudents().clone());
        return courseClone;
    }
    //there is another answer for this!
}
