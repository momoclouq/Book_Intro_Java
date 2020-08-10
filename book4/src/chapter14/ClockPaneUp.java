/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;

/**
 *
 * @author cis2mye
 */
public class ClockPaneUp extends Pane{
    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;
    
    public ClockPaneUp(){
        setCurrentTime();
    }
    
    public ClockPaneUp(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public boolean getHourHandVisible(){
        return hourHandVisible;
    }
    
    public void setHourHandVisible(boolean hand){
        hourHandVisible = hand;
    }
    
    public boolean getMinuteHandVisible(){
        return minuteHandVisible;
    }
    
    public void setMinuteHandVisible(boolean hand){
        minuteHandVisible = hand;
    }
    
    public boolean getSecondHandVisible(){
        return secondHandVisible;
    }
    
    public void setSecondHandVisible(boolean hand){
        secondHandVisible = hand;
    }
    
    public int getHour(){
        return hour;
    }
    
    public void setHour(int hour){
        this.hour = hour;
        paintClock();
    }
    
    public int getMinute(){
        return minute;
    }
    
    public void setMinute(int minute){
        this.minute = minute;
        paintClock();
    }
    
    public int getSecond(){
        return second;
    }
    
    public void setSecond(int second){
        this.second = second;
        paintClock();
    }
    
    public void setCurrentTime(){
        Calendar calendar = new GregorianCalendar();
        
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        
        paintClock();
    }
    
    private void paintClock(){
        getChildren().clear();
        
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() /2;
        
        //draw the circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        //draw the number and the big lines
        Group numbers = new Group();
        double startAngle = 90;
        double numberRadius = clockRadius * 0.85;
        double bigLineRadius = clockRadius * 0.92;
        for (int i = 0; i < 12; i++){
            double pX = centerX + numberRadius * Math.cos(i * Math.toRadians(30) + Math.PI / 2);
            double pY = centerY - numberRadius * Math.sin(i * Math.toRadians(30) + Math.PI / 2);
            
            double lineX = centerX + bigLineRadius * Math.cos(i * Math.toRadians(30) + Math.PI / 2);
            double lineY = centerY - bigLineRadius * Math.sin(i * Math.toRadians(30) + Math.PI / 2);
            
            double outerX = centerX + clockRadius * Math.cos(i * Math.toRadians(30) + Math.PI / 2);
            double outerY = centerY - clockRadius * Math.sin(i * Math.toRadians(30) + Math.PI / 2);
            
            Text t = new Text(pX - 5, pY + 3, Integer.toString(12 - i));
            Polyline line = new Polyline(outerX, outerY, lineX, lineY);
            line.setStroke(Color.BLACK);
            numbers.getChildren().addAll(t, line);
        }
        
        //draw the small lines
        double smallLineRadius = clockRadius * 0.96;
        for (int i = 0; i < 60; i++){
            double pX = centerX + smallLineRadius * Math.cos(i * Math.toRadians(6));
            double pY = centerY - smallLineRadius * Math.sin(i * Math.toRadians(6));
            
            double outerX = centerX + clockRadius * Math.cos(i * Math.toRadians(6));
            double outerY = centerY - clockRadius * Math.sin(i * Math.toRadians(6));
            
            Polyline line = new Polyline(outerX, outerY, pX, pY);
            line.setStroke(Color.BLACK);
            numbers.getChildren().add(line);
        }
        getChildren().addAll(circle, numbers);
        
        //draw second hand
        if(secondHandVisible){
            double sLength = clockRadius * 0.8;
            double secondX = centerX + sLength* Math.sin(second *(2 * Math.PI / 60));
            double secondY = centerY -sLength * Math.cos(second * (2 * Math.PI/ 60));
            Line sLine= new Line(centerX, centerY, secondX, secondY);
            sLine.setStroke(Color.RED);
            getChildren().add(sLine);
        }
            

        
        //Draw minute hand
        if(minuteHandVisible){
            double mLength = clockRadius * 0.65;
            double minuteX = centerX + mLength * Math.sin(minute * ( 2 * Math.PI / 60));
            double minuteY = centerY - mLength * Math.cos(minute * ( 2 * Math.PI / 60));
            Line mLine = new Line(centerX, centerY, minuteX, minuteY);
            mLine.setStroke(Color.BLUE);
            getChildren().add(mLine);
        }
            

        
        //Draw hour hand
        if(hourHandVisible){
            double hLength = clockRadius * 0.5;
            double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2* Math.PI / 12));
            double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2* Math.PI / 12));
            Line hLine = new Line(centerX, centerY, hourX, hourY);
            hLine.setStroke(Color.GREEN);
            getChildren().add(hLine);
        }

    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paintClock();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paintClock();
    }
}
