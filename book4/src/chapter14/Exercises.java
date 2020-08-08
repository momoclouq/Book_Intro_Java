/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
        Ex14 pane = new Ex14();
        
        //Create a scene and add the scene to the stage
        String title = pane.getName();
        Scene scene = new Scene(pane, 500, 500);
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