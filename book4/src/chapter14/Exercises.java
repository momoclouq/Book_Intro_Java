/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author cis2mye
 */
public class Exercises extends Application{
    @Override
    public void start(Stage primaryStage){
        //Create a pane
        //Ex1 pane = new Ex1();
        //Ex2 pane = new Ex2();
        //Ex4 pane = new Ex4();
        //Ex5 pane = new Ex5();
        //Ex6 pane = new Ex6();
        //Ex7 pane = new Ex7();
        //Ex8 pane = new Ex8();
        //Ex9 pane = new Ex9();
        //Ex10 pane = new Ex10();
        //Ex11 pane = new Ex11();
        //Ex12 pane = new Ex12();
        //Ex13 pane = new Ex13();
        //Ex14 pane = new Ex14();
        //Ex15 pane = new Ex15();
        //Ex16 pane = new Ex16();
        //Ex17 pane = new Ex17();
        //Ex18 pane = new Ex18();
        //Ex19 pane = new Ex19();
        //Ex20 pane = new Ex20();
        //Ex21 pane  = new Ex21();
        //Ex22 pane = new Ex22();
        double center1X = 1 + Math.random() * 500;
        double center1Y = 1 + Math.random() * 500;
        double center2X = 1 + Math.random() * 500;
        double center2Y = 1 + Math.random() * 500;
        double width1 = 1 + Math.random() * 500;
        double height1 = 1 + Math.random() * 500;
        double width2 = 1 + Math.random() * 500;
        double height2 = 1 + Math.random() * 500;
        Ex23 pane = new Ex23(center1X, center1Y, center2X, center2Y, width1, height1, width2, height2);
        
        //Create a scene and add the scene to the stage
        String title = pane.getName();
        Scene scene = new Scene(pane, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}

class Ex1 extends GridPane implements Epane{
    public Ex1(){
        this.setHgap(5.0);
        this.setVgap(5.0);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(110.5, 120.5, 130.5, 140.5));
        
        //setting the images
        Image[] imList = new Image[4];
        ImageView[] imVList = new ImageView[4];
        for (int i = 0; i < imList.length; i++){
            String location = "photos/im" + (i+1) +".jpg";
            imList[i] = new Image(location);
            imVList[i] = new ImageView(imList[i]);
            imVList[i].fitHeightProperty().bind(this.heightProperty().divide(2));
            imVList[i].fitWidthProperty().bind(this.widthProperty().divide(2));
            this.add(imVList[i],(i / 2) , (i % 2));
        }
        
 
    }
    
    @Override
    public String getName(){
        return "Exercise 14.1";
    }
}

class Ex2 extends GridPane implements Epane{
    public Ex2(){
        this.setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(100, 100, 100, 100));
        setStyle("-fx-border-color: black");
        
        //setting the images
        Image x = new Image("photos/image/x.gif");
        Image o = new Image("photos/Image/o.gif");
                
        //randomly set the cells
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int value = (int) Math.floor(Math.random() * 3);
                //if(value == 0) add(null, i, j);
                if(value == 1) {
                    ImageView xV = new ImageView(x);
                    add(xV, i, j);
                }
                if(value == 2) {
                    ImageView oV = new ImageView(o);
                    add(oV, i, j);
                }
            }
        }
    }
    
    @Override
    public String getName(){
        return "Exercise 14.2";
    }
}

class Ex4 extends FlowPane implements Epane{
    public Ex4(){
        String value = "Yuuko";
        setPadding(new Insets(50, 5, 50, 50));
        setHgap(5);
        setVgap(5);
        setStyle("-fx-border-color: black");
        Font defaultFont = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24.0);
        
        for (int i = 0; i < 5; i++){
            Label input = new Label(value);
            input.setRotate(90);
            input.setFont(defaultFont);
            
            Color wishColor = (new Color(Math.random(), Math.random(), Math.random(), Math.random()));
            input.setTextFill(wishColor);
            
            getChildren().add(input);
        }
        
    }
    
    @Override
    public String getName(){
        return "Exercise 14.4";
    }
}

class Ex5 extends Pane implements Epane{
    public Ex5(){
        String value = "Learning JavaFX";
        Text[] valueT = new Text[value.length()];
        
        Circle circle = new Circle();
        circle.setFill(Color.TRANSPARENT);
        circle.setRadius(200);
        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(heightProperty().divide(2));
        if(widthProperty().greaterThan(heightProperty()).getValue()) circle.radiusProperty().bind(heightProperty().divide(5).multiply(2));
        else circle.radiusProperty().bind(widthProperty().divide(5).multiply(2));
        getChildren().add(circle);
        
        //setting the texts
        double rotation = 0; 
        Font font1 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
        for (int i = 0; i< valueT.length; i++){
            valueT[i] = new Text(Character.toString(value.charAt(i)));
            valueT[i].setFont(font1);
            valueT[i].xProperty().bind(circle.centerXProperty().add(circle.radiusProperty().multiply(Math.sin(rotation))));
            valueT[i].yProperty().bind(circle.centerXProperty().subtract(circle.radiusProperty().multiply(Math.cos(rotation))));
            valueT[i].setRotate(Math.toDegrees(rotation));
            rotation += Math.PI / (valueT.length) * 2;
            getChildren().add(valueT[i]);
        }
    }
    
    @Override
    public String getName(){
        return "Exercise 14.5";
    }
}

class Ex6 extends GridPane implements Epane{
    
    public Ex6(){
        Rectangle[] board = new Rectangle[8*8];
        
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                int position = 8*i + j;
                add(addBlock(position, i), j, i);
                System.out.println(i + " - " + j);
            }
        }
    }
    
    private Rectangle addBlock(int position, int row){
        try{
            if (position >= 64) throw new Exception("position exceeds limit");
            
            Rectangle rec = new Rectangle();
            rec.widthProperty().bind(widthProperty().divide(8));
            rec.heightProperty().bind(heightProperty().divide(8));
            if (position % 2 == 0 && row % 2 == 0) rec.setFill(Color.WHITE);
            else if (row % 2 == 0) rec.setFill(Color.BLACK);
            else if (position % 2 == 1) rec.setFill(Color.WHITE);
            else rec.setFill(Color.BLACK);
            
            return rec; 
        } catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public String getName(){
        return "Exercise 14.6";
    }
}

class Ex7 extends GridPane implements Epane{
    public Ex7(){
        int number = 10;
        
        for (int i = 0; i < number; i++){
            for (int j = 0; j < number; j++){
                TextField text = new TextField(String.valueOf(getR()));
                text.setAlignment(Pos.CENTER);
                text.setPrefWidth(30);
                text.setPrefHeight(30);
                
                add(text, j, i);
            }
        }
        
        setAlignment(Pos.CENTER);
    }
    
    private int getR(){
        double value = Math.random();
        if (value <= 0.5) return 0;
        return 1;
    }
    
    @Override
    public String getName(){
        return "Exercise 14.7";
    }
}

class Ex8 extends GridPane implements Epane{
    public Ex8(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 9; j++){
                int position = 9*i + j;
                String image = "photos/image/card/" + (position+1) + ".png";
                add(new ImageView(image), j, i);
            }
        }
    }
    
    @Override
    public String getName(){
        return "Exercise 14.8";
    }
}

class Ex9 extends GridPane implements Epane{
    public Ex9(){
        setPadding(new Insets(20, 20, 20, 20));
        
        //create the board
        for (int row = 0; row < 2; row++){
            for (int col = 0; col < 2; col++){
                getTaichi taichi = new getTaichi();
                taichi.prefWidthProperty().bind(widthProperty().divide(2));
                taichi.prefHeightProperty().bind(heightProperty().divide(2));
                add(taichi, col, row);
            }
        }
    }
  
    @Override
    public String getName(){
        return "Exercise 14.9";
    }
}

class getTaichi extends Pane{
        private void paint(int x){
            
            getChildren().clear();
            //draw the circle
            Circle circle = new Circle();
            if (x == 1)
                circle.radiusProperty().bind(widthProperty().divide(2.1));
            else circle.radiusProperty().bind(heightProperty().divide(2.1));
            circle.centerXProperty().bind(widthProperty().divide(2));
            circle.centerYProperty().bind(heightProperty().divide(2));
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(Color.BLUE);
            getChildren().add(circle);
        
            //draw the round arcs
            Arc[] arcs = new Arc[4];
            double rotation = 30;
        
            for(int i = 0; i < 4; i++){
                getChildren().add(createArc(rotation, circle));
                rotation = rotation + 90;
            }
            
        }
        
        private Arc createArc(double rotation, Circle circle){
            Arc arc = new Arc();
            arc.centerXProperty().bind(circle.centerXProperty());
            arc.centerYProperty().bind(circle.centerYProperty());
            arc.radiusXProperty().bind(circle.radiusProperty().multiply(9).divide(10));
            arc.radiusYProperty().bind(circle.radiusProperty().multiply(9).divide(10));
            arc.setStartAngle(rotation);
            arc.setLength(30);
            arc.setType(ArcType.ROUND);
            arc.setStroke(Color.BEIGE);
            arc.setFill(Color.RED);
            System.out.println(arc.getCenterX() + " - " + arc.getCenterY() + " - " + arc.getRadiusX() + " - " + arc.getRadiusY() + " - " + circle.getRadius());
            System.out.println("Cradius: " + circle.getCenterX() + " - " + circle.getCenterY()); 
            return arc;  
        }
        
        @Override
        public void setWidth(double width){
            super.setWidth(width);
            if (getWidth() >= getHeight())
                paint(0);
            else paint(1);
        }
        
        @Override
        public void setHeight(double height){
            super.setHeight(height);
            if (getWidth() >= getHeight())
                paint(0);
            else paint(1);
        }
}

class Ex10 extends Pane implements Epane{
    public void paint(){
        //clear the children
        getChildren().clear();
        
        //draw the 2 ellipses, e2 is the dummy ellipse
        Ellipse e1 = new Ellipse();
        e1.centerXProperty().bind(widthProperty().divide(2));
        e1.centerYProperty().bind(heightProperty().multiply(0.2));
        e1.radiusXProperty().bind(widthProperty().divide(2).multiply(0.8));
        e1.radiusYProperty().bind(heightProperty().divide(2).multiply(0.3));
        e1.setFill(Color.TRANSPARENT);
        e1.setStroke(Color.BLACK);
        
        Ellipse e2 = new Ellipse();
        e2.centerXProperty().bind(e1.centerXProperty());
        e2.centerYProperty().bind(heightProperty().multiply(0.6).add(e1.centerYProperty()));
        e2.radiusXProperty().bind(e1.radiusXProperty());
        e2.radiusYProperty().bind(e1.radiusYProperty());
        e2.setFill(Color.TRANSPARENT);
        e2.setStroke(Color.TRANSPARENT);
        
        //draw the 2 lines
        Line l1 = new Line();
        l1.startXProperty().bind(e1.centerXProperty().subtract(e1.radiusXProperty()));
        l1.startYProperty().bind(e1.centerYProperty());
        l1.endXProperty().bind(e2.centerXProperty().subtract(e2.radiusXProperty()));
        l1.endYProperty().bind(e2.centerYProperty());
        
        Line l2 = new Line();
        l2.startXProperty().bind(e1.centerXProperty().add(e1.radiusXProperty()));
        l2.startYProperty().bind(e1.centerYProperty());
        l2.endXProperty().bind(e2.centerXProperty().add(e2.radiusXProperty()));
        l2.endYProperty().bind(e2.centerYProperty());
        
        //add the 2 final arcs
        Arc arc1 = new Arc();
        arc1.centerXProperty().bind(e2.centerXProperty());
        arc1.centerYProperty().bind(e2.centerYProperty());
        arc1.radiusXProperty().bind(e2.radiusXProperty());
        arc1.radiusYProperty().bind(e2.radiusYProperty());
        arc1.setStartAngle(0);
        arc1.setLength(180);
        arc1.getStrokeDashArray().addAll(12.0, 10.0);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStroke(Color.BLACK);
        
        Arc arc2 = new Arc();
        arc2.centerXProperty().bind(e2.centerXProperty());
        arc2.centerYProperty().bind(e2.centerYProperty());
        arc2.radiusXProperty().bind(e2.radiusXProperty());
        arc2.radiusYProperty().bind(e2.radiusYProperty());
        arc2.setStartAngle(180);
        arc2.setLength(180);
        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.BLACK);
        
        getChildren().addAll(e1, l1, l2, arc1, arc2);
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    
    @Override
    public String getName(){
        return "Exercise 14.10";
    }
}

class Ex11 extends Pane implements Epane{
    public void paint(){
        getChildren().clear();
        
        //draw the outer circle
         Circle c = drawOuterCircle();
         
         //draw the eyelids
         Ellipse e1 = drawEye(0.35);
         Ellipse e2 = drawEye(0.65);
         
         //draw the eyeball
         Circle eb1 = drawEyeBall();
         eb1.centerXProperty().bind(e1.centerXProperty());
         eb1.centerYProperty().bind(e1.centerYProperty());
         Circle eb2 = drawEyeBall();
         eb2.centerXProperty().bind(e2.centerXProperty());
         eb2.centerYProperty().bind(e2.centerYProperty());
         
         //draw the nose
         Polyline nose = drawNose();
         
         //draw the mouth
         Arc mouth = drawMouth();
         getChildren().addAll(c, e1, e2, eb1, eb2, nose, mouth);
    }
    
    private Circle drawOuterCircle(){
        Circle c = new Circle();
        c.radiusProperty().bind(widthProperty().divide(2).multiply(0.8));
        c.centerXProperty().bind(widthProperty().divide(2));
        c.centerYProperty().bind(heightProperty().divide(2));
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        
        return c;
    }
    
    private Ellipse drawEye(double locationEyeX){
        Ellipse e = new Ellipse();
        e.centerXProperty().bind(widthProperty().multiply(locationEyeX));
        e.centerYProperty().bind(heightProperty().divide(3));
        e.radiusXProperty().bind(widthProperty().divide(10));
        e.radiusYProperty().bind(heightProperty().divide(15));
        e.setFill(Color.RED);
        
        return e;
    }
    
    private Circle drawEyeBall(){
        Circle c = new Circle();
        c.setFill(Color.BLACK);
        c.radiusProperty().bind(widthProperty().divide(20));
        
        return c;
    }
    
    private Polyline drawNose(){
        Polyline nose = new Polyline();
        DoubleProperty px1 = new SimpleDoubleProperty(1.0);
        DoubleProperty py1 = new SimpleDoubleProperty(1.0);
        DoubleProperty px2 = new SimpleDoubleProperty(1.0);
        DoubleProperty py2 = new SimpleDoubleProperty(1.0);
        DoubleProperty px3 = new SimpleDoubleProperty(1.0);
        DoubleProperty py3 = new SimpleDoubleProperty(1.0);
        
        py1.bind(heightProperty().multiply(0.4));
        px1.bind(widthProperty().divide(2));
        px2.bind(widthProperty().multiply(0.55));
        py2.bind(heightProperty().multiply(0.6));
        px3.bind(widthProperty().multiply(0.45));
        py3.bind(heightProperty().multiply(0.6));
        
        nose.getPoints().add(px1.getValue());
        nose.getPoints().add(py1.getValue());
        nose.getPoints().add(px2.getValue());
        nose.getPoints().add(py2.getValue());
        nose.getPoints().add(px3.getValue());
        nose.getPoints().add(py3.getValue());
        
        return nose;
    }
    
    private Arc drawMouth(){
        Arc mouth = new Arc();
        
        mouth.centerXProperty().bind(widthProperty().divide(2));
        mouth.centerYProperty().bind(heightProperty().divide(2));
        mouth.radiusXProperty().bind(widthProperty().multiply(0.45));
        mouth.radiusYProperty().bind(heightProperty().multiply(0.3));
        mouth.setStartAngle(240);
        mouth.setLength(60);
        mouth.setType(ArcType.OPEN);
        mouth.setFill(Color.TRANSPARENT);
        mouth.setStroke(Color.BLACK);
        
        return mouth;
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    @Override
    public String getName(){
        return "Exercise 14.11";
    }
}

class Ex12 extends HBox implements Epane{
    public void paint(){
        getChildren().clear();
        //create panes
        setAlignment(Pos.BOTTOM_LEFT);
        Pane p1 = new Bar("Apple", 20, Color.RED);
        p1.prefWidthProperty().bind(widthProperty().divide(4));
        
        Pane p2 = new Bar("HTC", 26, Color.BLUE);
        p2.prefWidthProperty().bind(widthProperty().divide(4));
        
        Pane p3 = new Bar("Samsung", 28, Color.GREEN);
        p3.prefWidthProperty().bind(widthProperty().divide(4));
        
        Pane p4 = new Bar("Others", 26, Color.ORANGE);
        p4.prefWidthProperty().bind(widthProperty().divide(4));
        setStyle("-fx-background-color: white");
        setSpacing(10);
        
        
        //setSpacing(20);
        //Rectangle r1 = createRectangle(Color.RED);
        //Rectangle r2 = createRectangle(Color.BLUE);
        
        getChildren().addAll(p1, p2, p3, p4);
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    @Override
    public String getName(){
        return "Exercise 14.12";
    }
}

class Bar extends Pane {
    public Bar(String name, double percentage, Color color){
        //Create the rectangle
        Rectangle rec = new Rectangle();
        rec.xProperty().bind(new SimpleDoubleProperty(0));
        rec.yProperty().bind(heightProperty().subtract(heightProperty().multiply(percentage/100)));
        rec.widthProperty().bind(widthProperty());
        rec.heightProperty().bind(heightProperty().multiply(percentage).divide(100));
        rec.setFill(color);
        
        //create text
        Text text = new Text();
        text.setText(name + " -- " + percentage + "%");
        text.xProperty().bind(rec.xProperty());
        text.yProperty().bind(rec.yProperty().subtract(10));
        text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        
        getChildren().add(rec);
        getChildren().add(text);
    }
}

class Ex13 extends Pane implements Epane{
    public void paint(){
        getChildren().clear();
        
        Group arcGroup = new Group();
        double startAngle = 0;
        Arc arc1 = setArc("Apple", 20, Color.RED, startAngle);
        Text t1 = setText("Apple", startAngle);
        startAngle += (20.0/100 * 360);
        
        Arc arc2 = setArc("HTC", 26, Color.BLUE, startAngle);
        Text t2 = setText("HTC", startAngle);
        startAngle += (26.0/100 * 360);

        Arc arc3 = setArc("Samsung", 28, Color.GREEN, startAngle);
        Text t3 = setText("Samsung", startAngle);
        startAngle += (28.0/100 * 360);

        Arc arc4 = setArc("Others", 26, Color.ORANGE, startAngle);
        Text t4 = setText("Others", startAngle);
        //startAngle += 20/100 * 360;
        
        
        setStyle("-fx-background-color: white");
        arcGroup.getChildren().addAll(arc1, arc2, arc3, arc4, t1, t2, t3, t4);
        
        getChildren().add(arcGroup);
    }
    
    private Arc setArc(String name, double percentage, Color color, double startAngle){
        Arc arc = new Arc();
        
        double length = percentage/100 * 360;
        arc.centerXProperty().bind(widthProperty().divide(2));
        arc.centerYProperty().bind(heightProperty().divide(2));
        arc.radiusXProperty().bind(widthProperty().multiply(0.8).divide(2));
        arc.radiusYProperty().bind(arc.radiusXProperty());
        arc.setStartAngle(startAngle);
        arc.setLength(length);
        arc.setType(ArcType.ROUND);
        arc.setFill(color);
        
        return arc;
    }
    
    private Text setText(String name, double startAngle){
        Text text = new Text();
        text.setText(name);
        
        DoubleProperty pX = new SimpleDoubleProperty(0);
        DoubleProperty pY = new SimpleDoubleProperty(0);
        DoubleProperty radius = new SimpleDoubleProperty(0);
        pX.bind(widthProperty().divide(2));
        pY.bind(heightProperty().divide(2));
        radius.bind(widthProperty().multiply(0.8).divide(2));
        
        text.xProperty().bind(pX.add(radius.multiply(Math.cos(Math.toRadians(startAngle)))));
        text.yProperty().bind(pY.subtract(radius.multiply(Math.sin(Math.toRadians(startAngle)))));
        
        return text;
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    @Override
    public String getName(){
        return "Exercise 14.13";
    }
}

class Ex14 extends Pane implements Epane{
    
    public void paint(){
        //clear the pane
        getChildren().clear();
        
        //set up the points
        DoubleProperty p1x = new SimpleDoubleProperty();
        p1x.bind(widthProperty().multiply(0.15));
        DoubleProperty p1y = new SimpleDoubleProperty();
        p1y.bind(heightProperty().multiply(0.05));
        
        DoubleProperty p2x = new SimpleDoubleProperty();
        p2x.bind(p1x.add(widthProperty().multiply(0.8)));
        DoubleProperty p2y = new SimpleDoubleProperty();
        p2y.bind(p1y);
        
        DoubleProperty p3x = new SimpleDoubleProperty();
        p3x.bind(widthProperty().multiply(0.05));
        DoubleProperty p3y = new SimpleDoubleProperty();
        p3y.bind(p1y.add(heightProperty().multiply(0.2)));
        
        DoubleProperty p4x = new SimpleDoubleProperty();
        p4x.bind(p3x.add(widthProperty().multiply(0.8)));
        DoubleProperty p4y = new SimpleDoubleProperty();
        p4y.bind(p3y);
        
        DoubleProperty p5x = new SimpleDoubleProperty();
        p5x.bind(p1x);
        DoubleProperty p5y = new SimpleDoubleProperty();
        p5y.bind(p1y.add(heightProperty().multiply(0.7)));
        
        DoubleProperty p6x = new SimpleDoubleProperty();
        p6x.bind(p2x);
        DoubleProperty p6y = new SimpleDoubleProperty();
        p6y.bind(p2y.add(heightProperty().multiply(0.7)));
        
        DoubleProperty p7x = new SimpleDoubleProperty();
        p7x.bind(p3x);
        DoubleProperty p7y = new SimpleDoubleProperty();
        p7y.bind(p3y.add(heightProperty().multiply(0.7)));
        
        DoubleProperty p8x = new SimpleDoubleProperty();
        p8x.bind(p4x);
        DoubleProperty p8y = new SimpleDoubleProperty();
        p8y.bind(p4y.add(heightProperty().multiply(0.7)));
        
        //prepare the values
        double p1xv = p1x.doubleValue();
        double p1yv = p1y.doubleValue();
        double p2xv = p2x.doubleValue();
        double p2yv = p2y.doubleValue();
        double p3xv = p3x.doubleValue();
        double p3yv = p3y.doubleValue();
        double p4xv = p4x.doubleValue();
        double p4yv = p4y.doubleValue();
        double p5xv = p5x.doubleValue();
        double p5yv = p5y.doubleValue();
        double p6xv = p6x.doubleValue();
        double p6yv = p6y.doubleValue();
        double p7xv = p7x.doubleValue();
        double p7yv = p7y.doubleValue();
        double p8xv = p8x.doubleValue();
        double p8yv = p8y.doubleValue();
        
        
        //prepare the polygons
        Polygon p1 = new Polygon(p1xv, p1yv, p2xv, p2yv, p4xv, p4yv, p3xv, p3yv );
        p1.setFill(Color.TRANSPARENT);
        p1.setStroke(Color.RED);
        
        Polygon p2 = new Polygon(p1xv, p1yv, p3xv, p3yv, p7xv, p7yv, p5xv, p5yv);
        p2.setFill(Color.TRANSPARENT);
        p2.setStroke(Color.BLACK);
        
        Polygon p3 = new Polygon(p2xv, p2yv, p4xv, p4yv, p8xv, p8yv, p6xv, p6yv);
        p3.setFill(Color.TRANSPARENT);
        p3.setStroke(Color.BLUE);
        
        Polygon p4 = new Polygon(p5xv, p5yv, p6xv, p6yv, p8xv, p8yv, p7xv, p7yv);
        p4.setFill(Color.TRANSPARENT);
        p4.setStroke(Color.GREEN);
        
        getChildren().addAll(p1, p2, p3, p4);
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public String getName(){
        return "Exercise 14.14";
    }
}

class Ex15 extends StackPane implements Epane{
    public void paint(){
        getChildren().clear();
        
        //create the stop text
        Text text = new Text("STOP");
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 60));
        text.setFill(Color.WHITE);
        
        //create the sign
        Polygon sign = new Polygon();
        sign.setFill(Color.RED);
        ObservableList<Double> list = sign.getPoints();
        
        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;
        
        for(int i = 0; i < 8; i++){
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8 + Math.PI/8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8 + Math.PI/8));
        }
        
        getChildren().add(sign);
        getChildren().add(text);
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    @Override
    public String getName(){
        return "Exercise 14.15";
    }
}

class Ex16 extends GridPane implements Epane{
    public void paint(){
        int size = 4;
        //clear the pane
        getChildren().clear();
        
        //prepare the gridpane
        setAlignment(Pos.CENTER);
        
        //add the empty rectangle
        for (int i = 0; i < size; i++){
            for (int k = 0; k < size; k++){
                add(createRec(size), i, k);
            }
        }
        
        
    }
    
    private Pane createRec(int size){
        Pane rec = new Pane();
        //rec.setFill(Color.WHITE);
        rec.setStyle("-fx-border-color: white blue red white; " +
                "-fx-border-width: 1;");
        rec.prefWidthProperty().bind(widthProperty().divide(size));
        rec.prefHeightProperty().bind(heightProperty().divide(size));
        return rec;
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public String getName(){
        return "Exercise 14.16";
    }
}

class Ex17 extends Pane implements Epane{
    public void paint(){
        getChildren().clear();
        
        //draw the stand
        Arc stand = drawStand();
        
        //draw the wholestand
        Polyline stand2 = drawStand2();
        
        //draw the head
        Circle head = drawHead();
        
        //draw the hands
        Polyline hand1 = drawHand1();
        Polyline hand2 = drawHand2();
        
        //draw the lower body
        Polyline body = drawBody();
        
        //draw the last leg
        Polyline leg = drawLeg();
        
        getChildren().addAll(stand, stand2, head, hand1, hand2, body, leg);
    }
    
    private Arc drawStand(){
        Arc stand = new Arc();
        
        stand.centerXProperty().bind(widthProperty().multiply(0.3));
        stand.centerYProperty().bind(heightProperty().multiply(0.9));
        stand.radiusXProperty().bind(widthProperty().multiply(0.15));
        stand.radiusYProperty().bind(heightProperty().multiply(0.1));
        stand.setStartAngle(0);
        stand.setLength(180);
        stand.setType(ArcType.OPEN);
        stand.setStroke(Color.BLACK);
        stand.setFill(Color.WHITE);
        
        return stand;
    }
    
    private Polyline drawStand2(){
        
        DoubleProperty p1x = new SimpleDoubleProperty();
        p1x.bind(widthProperty().multiply(0.3));
        double p1xv = p1x.doubleValue();
        DoubleProperty p1y = new SimpleDoubleProperty();
        p1y.bind(heightProperty().multiply(0.8));
        double p1yv = p1y.doubleValue();
        
        DoubleProperty p2x = new SimpleDoubleProperty();
        p2x.bind(p1x);
        double p2xv = p2x.doubleValue();
        DoubleProperty p2y = new SimpleDoubleProperty();
        p2y.bind(heightProperty().multiply(0.1));
        double p2yv = p2y.doubleValue();
        
        DoubleProperty p3x = new SimpleDoubleProperty();
        p3x.bind(p2x.add(widthProperty().multiply(0.5)));
        double p3xv = p3x.doubleValue();
        DoubleProperty p3y = new SimpleDoubleProperty();
        p3y.bind(p2y);
        double p3yv = p3y.doubleValue();
        
        DoubleProperty p4x = new SimpleDoubleProperty();
        p4x.bind(p3x);
        double p4xv = p4x.doubleValue();
        DoubleProperty p4y = new SimpleDoubleProperty();
        p4y.bind(heightProperty().multiply(0.2));
        double p4yv = p4y.doubleValue();
        
        Polyline stand = new Polyline(p1xv, p1yv, p2xv, p2yv, p3xv, p3yv, p4xv, p4yv);
       
        return stand;
    }
    
    private Circle drawHead(){
        Circle head = new Circle();
        
        head.centerXProperty().bind(widthProperty().multiply(0.8));
        head.centerYProperty().bind(heightProperty().multiply(0.3));
        head.radiusProperty().bind(heightProperty().multiply(0.1));
        head.setStroke(Color.BLACK);
        head.setFill(Color.WHITE);
        
        return head;
    }
    
    private Polyline drawHand1(){
        
        DoubleProperty radius = new SimpleDoubleProperty();
        radius.bind(heightProperty().multiply(0.1));
        DoubleProperty centerX = new SimpleDoubleProperty();
        centerX.bind(widthProperty().multiply(0.8));
        DoubleProperty centerY = new SimpleDoubleProperty();
        centerY.bind(heightProperty().multiply(0.3));
        
        DoubleProperty p1x = new SimpleDoubleProperty();
        DoubleProperty p1y = new SimpleDoubleProperty();
        p1x.bind(centerX.add(radius.multiply(Math.cos(2 * Math.PI / 1.5))));
        p1y.bind(centerY.subtract(radius.multiply(Math.sin(2 * Math.PI / 1.5))));
        
        double p2x = p1x.doubleValue() - getWidth() * 0.2;
        double p2y = p1y.doubleValue() + getHeight() * 0.15;
        
        
        Polyline hand1 = new Polyline(p1x.doubleValue(), p1y.doubleValue(), p2x, p2y);
        
        return hand1;
    }
    
    private Polyline drawHand2(){
        double radius = getHeight() * 0.1;
        double centerX = getWidth() * 0.8;
        double centerY = getHeight() * 0.3;
        
        double p1x = centerX + radius * Math.cos(2 * Math.PI / 1.2);
        double p1y = centerY - radius * Math.sin(2 * Math.PI / 1.2);
        double p2x = p1x + getWidth() * 0.2;
        double p2y = p1y + getHeight() * 0.15;
        
        Polyline hand2 = new Polyline(p1x, p1y, p2x, p2y);
        
        return hand2;
    }
    
    private Polyline drawBody(){
        double radius = getHeight() * 0.1;
        double centerX = getWidth() * 0.8;
        double centerY = getHeight() * 0.3;
        
        double p1x = centerX;
        double p1y = centerY + radius;
        double p2x = centerX;
        double p2y = p1y + getHeight() * 0.4;
        double p3x = p2x + getWidth() * 0.15;
        double p3y = p2y + getHeight() * 0.1;
        
        Polyline body = new Polyline(p1x, p1y, p2x, p2y, p3x, p3y);
        
        return body;
    }
    
    private Polyline drawLeg(){
        double radius = getHeight() * 0.1;
        double centerX = getWidth() * 0.8;
        double centerY = getHeight() * 0.3;
        
        double p1x = centerX;
        double p1y = centerY + radius;
        double p2x = centerX;
        double p2y = p1y + getHeight() * 0.4;
        double p3x = p2x - getWidth() * 0.15;
        double p3y = p2y + getHeight() * 0.1;
        
        Polyline leg = new Polyline(p2x, p2y, p3x, p3y);
        
        return leg;
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    @Override
    public String getName(){
        return "Exercise 14.17";
    }
}

class Ex18 extends Pane implements Epane{
    public void paint(){
        getChildren().clear();
        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.005;
        for (int i = -100; i<=100; i++){
            list.add((double) i + getWidth() / 2);
            list.add((getHeight()/2 + (-1) * scaleFactor * i * i * i));
        }
        
        Polyline xAxis = xAxis();
        Polyline yAxis = yAxis();
        
        getChildren().addAll(polyline, xAxis, yAxis);
        //setRotate(180);
    }
    
    private Polyline xAxis(){
        
        double p1x = 0;
        double p1y = getHeight() / 2;
        double p2x = getWidth();
        double p2y = getHeight() / 2;
        
        Polyline ax = new Polyline(p1x, p1y, p2x, p2y);
        return ax;
    }
    
    private Polyline yAxis(){
        double p1x = getWidth() / 2;
        double p1y = 0;
        double p2x = getWidth() / 2;
        double p2y = getHeight();
        
        Polyline ax = new Polyline(p1x, p1y, p2x, p2y);
        return ax;
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    @Override
    public String getName(){
        return "Exercise 14.18";
    }
}

class Ex19 extends Pane implements Epane{
    public void paint(){
        //clear the pane
        getChildren().clear();
        
        //draw the axises
        Polyline xAxis = xAxis();
        Polyline yAxis = yAxis();
        
        //draw the functions
        Polyline sinL = new Polyline();
        sinL.setStroke(Color.RED);
        ObservableList<Double> list = sinL.getPoints();
        Polyline tanL = new Polyline();
        tanL.setStroke(Color.BLUE);
        ObservableList<Double> list2 = tanL.getPoints();
        double scaleFactor = 100;
        for (int x = -170; x <= 170; x++){
            double width = x + getWidth() / 2;
            double height = getHeight() / 2 + (-1) * scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI);
            list.add(width);
            list.add(height);
            
            double value = x % 50;
            if (value == 0) {
                String output;
                if (x == 0) output = "0";
                else output = (x / 50) + "\u03c0";
                Text text = new Text(width, height, output);
                getChildren().add(text);
            }
            
            list2.add(x + getWidth() / 2);
            list2.add(getHeight() / 2 +  scaleFactor * Math.tan((x / 100.0) * 2 * Math.PI));
        }
       
        
        getChildren().addAll(xAxis, yAxis, tanL);
    }
    
    private Polyline xAxis(){
        
        double p1x = 0;
        double p1y = getHeight() / 2;
        double p2x = getWidth();
        double p2y = getHeight() / 2;
        
        Polyline ax = new Polyline(p1x, p1y, p2x, p2y);
        ax.setStyle("-fx-border-width: 3");
        return ax;
    }
    
    private Polyline yAxis(){
        double p1x = getWidth() / 2;
        double p1y = 0;
        double p2x = getWidth() / 2;
        double p2y = getHeight();
        
        Polyline ax = new Polyline(p1x, p1y, p2x, p2y);
        ax.setStyle("-fx-border-width: 3");
        return ax;
    }
    
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
    
    @Override
    public String getName(){
        return "Exercise 14.19";
    }
}

class Ex20 extends Pane implements Epane{
    public Ex20(){
        double startX = Math.random() * 500;
        double startY = Math.random() * 500;
        double endX = Math.random() * 500;
        double endY = Math.random() * 500;
        
        drawArrowLine(startX, startY, endX, endY, this);
    }
    
    public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane){
        // x+ by + c = 0
        // b = x2 - x1 / y1 - y2, c = -x2 - b * y2
        double b = (endX - startX) / (startY - endY);
        double c = (-1) * endX - b * endY;
        
        /*
        double p3x;
        double p3y;
        
        if (startX < endX){
            p3x = endX - 20;
            p3y = ((-1) * c - p3x) / b ;
        } else{
            p3x = endX + 20;
            p3y = ((-1) * c - p3x) / b ;
            
        }
*/
        double omega = Math.PI - Math.acos((endX - startX) / (Math.sqrt((endX - startX) * (endX - startX) + (endY - startY) * (endY -startY))));
        
        double startX3 = endX + Math.cos(Math.PI / 4 + omega) * 20;
        double startY3 = endY - Math.sin(Math.PI / 4 + omega) * 20;
        double startX4 = endX + Math.cos(-Math.PI / 4 + omega) * 20;
        double startY4 = endY - Math.sin(-Math.PI / 4 + omega) * 20;
  
        Polyline line1 = new Polyline(endX, endY, startX3, startY3);
        line1.setStroke(Color.BLUE);
        
        Polyline line2 = new Polyline(endX, endY, startX4, startY4);
        
        //the line
        Polyline line = new Polyline(startX, startY,endX, endY);
        line.setStroke(Color.RED);
        
        pane.getChildren().addAll(line, line1, line2);
    }
    
    @Override
    public String getName(){
        return "Exercise 14.20";
    }
}

class Ex21 extends Pane implements Epane{
    public Ex21(){
        //create the circles
        Circle c1 = new Circle();
        double c1x = Math.random() * 500;
        double c1y = Math.random() * 500;
        c1.setCenterX(c1x);
        c1.setCenterY(c1y);
        c1.setRadius(15);
        c1.setFill(Color.BLUE);
        
        Circle c2 = new Circle();
        double c2x = Math.random() * 500;
        double c2y = Math.random() * 500;
        c2.setCenterX(c2x);
        c2.setCenterY(c2y);
        c2.setRadius(15);
        c2.setFill(Color.BLUE);
        
        //Create the line
        Polyline line = new Polyline(c1x, c1y, c2x, c2y);
        
        //create the text
        double length = Math.sqrt((c1x - c2x) * (c1x - c2x) + (c1y - c2y) * (c1y - c2y));
        double tx = (c1x + c2x) / 2 + 5;
        double ty = (c1y + c2y) / 2 + 5;
        Text text = new Text(tx, ty, Double.toString(length));
        
        getChildren().addAll(c1, c2, line, text);
    }

    @Override
    public String getName(){
        return "Exercise 14.21";
    }
}

class Ex22 extends Pane implements Epane{
    public Ex22(){
        //draw the circles
        Circle c1 = new Circle();
        double c1x = Math.random() * 500;
        double c1y = Math.random() * 500;
        c1.setCenterX(c1x);
        c1.setCenterY(c1y);
        c1.setRadius(15);
        c1.setFill(Color.BLUE);
        
        Circle c2 = new Circle();
        double c2x = Math.random() * 500;
        double c2y = Math.random() * 500;
        c2.setCenterX(c2x);
        c2.setCenterY(c2y);
        c2.setRadius(15);
        c2.setFill(Color.BLUE);
        
        //Create the line
        Polyline line = new Polyline(c1x, c1y, c2x, c2y);
        
        getChildren().addAll(line, c1, c2);
    }
    
    @Override
    public String getName(){
        return "Exercise 14.22";
    }
}

class Ex23 extends Pane implements Epane{
    public Ex23(double center1X, double center1Y, double width1, double height1, double center2X, double center2Y, double width2, double height2){
        //draw the rectangle
        Rectangle r1 = new Rectangle(center1X - width1 / 2, center1Y - height1 / 2, width1, height1);
        r1.setFill(Color.TRANSPARENT);
        r1.setStroke(Color.BLACK);
        Rectangle r2 = new Rectangle(center2X - width2 / 2, center2Y - height2 / 2, width2, height2);
        r2.setFill(Color.TRANSPARENT);
        r2.setStroke(Color.BLACK);
        
        //initialize things
        double x1 = center1X - width1 / 2;
        double y1 = center1Y - height1 / 2;
        double x2 = center1X + width1 / 2;
        double y2 = center1Y + height1 /2;
        double x3 = center2X - width2 / 2;
        double y3 = center2Y - height2 / 2;
        double x4 = center2X + width2 / 2;
        double y4 = center2Y + height2 /2;
        
        String output;
        if (checkOverlap(x1, y1, x2, y2, x3, y3, x4, y4)){
            if (checkContain(x1, y1, x2, y2, x3, y3, x4, y4)) output = "One rectangle is contained in another";
            else output = "The rectangles overlap";
        } else output = "The rectangles do not overlap";
        
        Text text = new Text(500, 600 , output);
        
        getChildren().addAll(r1, r2, text);
    }
    
    private boolean checkOverlap(double x1,double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        if (x3 > x2 || x4 < x1 || y4 < y1 || y3 > y2) return false;
        else return true;
    }
    
    private boolean checkContain(double x1,double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        if (x1 < x3 && x2 > x4 && y1 < y3 && y2 > y4) return true;
        if (x3 < x1 && x4 > x2 && y3 < y1 && y4 > y2) return true;
        return false;
    }
    
    @Override
    public String getName(){
        return "Exercise 14.23";
    }
}