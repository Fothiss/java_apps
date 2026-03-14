package lab2;

class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}

class Dog extends Animal {
    private String breed;
    private String foodType;
    
    public Dog(String name, int age, String breed, String foodType) {
        super(name, age);
        this.breed = breed;
        this.foodType = foodType;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " лает: Гав-гав!");
    }
    
    public void guard() {
        System.out.println(name + " охраняет дом");
    }
    
    public String getBreed() {
        return breed;
    }
    
    public String getFoodType() {
        return foodType;
    }
}

class Cat extends Animal {
    private String breed;
    private String foodType;
    
    public Cat(String name, int age, String breed, String foodType) {
        super(name, age);
        this.breed = breed;
        this.foodType = foodType;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: Мяу-мяу!");
    }
    
    public void climb() {
        System.out.println(name + " лазает по деревьям");
    }
    
    public String getBreed() {
        return breed;
    }
    
    public String getFoodType() {
        return foodType;
    }
}

class Bird extends Animal {
    private boolean canFly;
    private String foodType;
    
    public Bird(String name, int age, boolean canFly, String foodType) {
        super(name, age);
        this.canFly = canFly;
        this.foodType = foodType;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " чирикает: Чик-чирик!");
    }
    
    public void fly() {
        if (canFly) {
            System.out.println(name + " летает");
        } else {
            System.out.println(name + " не умеет летать");
        }
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    public String getFoodType() {
        return foodType;
    }
}

public class Ex8 {
    public static void main(String[] args) {
        Dog dog = new Dog("Рекс", 3, "Овчарка", "Мясо");
        Cat cat = new Cat("Мурка", 2, "Сиамская", "Рыба");
        Bird bird = new Bird("Кеша", 1, true, "Зерно");
        Bird penguin = new Bird("Пингвин", 5, false, "Рыба");
        
        System.out.println("=== Собака ===");
        System.out.println("Имя: " + dog.getName() + ", Возраст: " + dog.getAge());
        System.out.println("Порода: " + dog.getBreed() + ", Корм: " + dog.getFoodType());
        dog.makeSound();
        dog.guard();
        
        System.out.println("\n=== Кошка ===");
        System.out.println("Имя: " + cat.getName() + ", Возраст: " + cat.getAge());
        System.out.println("Порода: " + cat.getBreed() + ", Корм: " + cat.getFoodType());
        cat.makeSound();
        cat.climb();
        
        System.out.println("\n=== Птица ===");
        System.out.println("Имя: " + bird.getName() + ", Возраст: " + bird.getAge());
        System.out.println("Корм: " + bird.getFoodType() + ", Летает: " + bird.canFly());
        bird.makeSound();
        bird.fly();
        
        System.out.println("\n=== Пингвин ===");
        System.out.println("Имя: " + penguin.getName() + ", Возраст: " + penguin.getAge());
        System.out.println("Корм: " + penguin.getFoodType() + ", Летает: " + penguin.canFly());
        penguin.makeSound();
        penguin.fly();
    }
}
