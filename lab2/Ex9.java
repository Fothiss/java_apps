package lab2;
import java.lang.Math;

abstract class ShapeNew {
    protected String color;
    
    public ShapeNew(String color) {
        this.color = color;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
}

class CircleNew extends ShapeNew {
    private double radius;
    
    public CircleNew(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class SquareNew extends ShapeNew {
    private double side;
    
    public SquareNew(String color, double side) {
        super(color);
        this.side = side;
    }
    
    @Override
    public double getArea() {
        return side * side;
    }
    
    @Override
    public double getPerimeter() {
        return 4 * side;
    }
    
    public double getSide() {
        return side;
    }
    
    public void setSide(double side) {
        this.side = side;
    }
}

class TriangleNew extends ShapeNew {
    private double sideA;
    private double sideB;
    private double sideC;
    
    public TriangleNew(String color, double sideA, double sideB, double sideC) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    
    public double getSideA() {
        return sideA;
    }
    
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    
    public double getSideB() {
        return sideB;
    }
    
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
    
    public double getSideC() {
        return sideC;
    }
    
    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
}

public class Ex9 {
    public static void main(String[] args) {
        CircleNew circle = new CircleNew("Красный", 5);
        SquareNew square = new SquareNew("Синий", 4);
        TriangleNew triangle = new TriangleNew("Зеленый", 3, 4, 5);
        
        System.out.println("=== Круг ===");
        System.out.println("Цвет: " + circle.getColor());
        System.out.println("Радиус: " + circle.getRadius());
        System.out.println("Площадь: " + circle.getArea());
        System.out.println("Периметр: " + circle.getPerimeter());
        
        System.out.println("\n=== Квадрат ===");
        System.out.println("Цвет: " + square.getColor());
        System.out.println("Сторона: " + square.getSide());
        System.out.println("Площадь: " + square.getArea());
        System.out.println("Периметр: " + square.getPerimeter());
        
        System.out.println("\n=== Треугольник ===");
        System.out.println("Цвет: " + triangle.getColor());
        System.out.println("Стороны: " + triangle.getSideA() + ", " + triangle.getSideB() + ", " + triangle.getSideC());
        System.out.println("Площадь: " + triangle.getArea());
        System.out.println("Периметр: " + triangle.getPerimeter());
    }
}