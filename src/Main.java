import lesson_16.Car;
import lesson_16.Transport;
public class Main {
    public static void main(String[] args) {
        Car simpleCar1 = new Car("Lada", "Granta", 1.7, "Желтый", 2015,
                "Россия", "ручная", "седан", "Н666СР777", 4, true , 105);
        Car simpleCar2 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "Черный", 2020,
                "Германия", "автоматическая", "седан", "О626СР347", 5, true,200);
        Car simpleCar3 = new Car("BMW", "Z8", 3.0, "Красный", 2021,
                "Германия", "автоматическая", "родстер", "С333СР341", 5, false,270);

        System.out.println(simpleCar1);
        System.out.println(simpleCar2);
        System.out.println(simpleCar3);
    }
}