package lab2;

interface Shape {
    double getArea();
    double getPerimeter();
}

class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
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
}

class Square implements Shape {
    private double side;
    
    public Square(double side) {
        this.side = side;
    }
    
    public double getSide() {
        return side;
    }
    
    public void setSide(double side) {
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
}

class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
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
    
    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
}

public class Ex6 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Square square = new Square(4);
        Triangle triangle = new Triangle(3, 4, 5);
        
        System.out.println("Круг: площадь = " + circle.getArea() + ", периметр = " + circle.getPerimeter());
        System.out.println("Квадрат: площадь = " + square.getArea() + ", периметр = " + square.getPerimeter());
        System.out.println("Треугольник: площадь = " + triangle.getArea() + ", периметр = " + triangle.getPerimeter());
    }
}