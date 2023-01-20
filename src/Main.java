import lesson_16.*;

public class Main {
    static public void printSeparator() {
        System.out.println("------------------------------------------------------------------------");
    }
    public static void main(String[] args) {
        Car simpleCar1 = new Car("Lada", "Granta", 1.7, "Желтый", 2015,
                "Россия", "ручная", "седан", "Н666СР777", 4, true , 105);
        Car simpleCar2 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "Черный", 2020,
                "Германия", "автоматическая", "седан", "О626СР347", 5, true,200);
        Car simpleCar3 = new Car("BMW", "Z8", 3.0, "Красный", 2021,
                "Германия", "автоматическая", "родстер", "С333СР341", 5, false,270);

        printSeparator();
        System.out.println(simpleCar1);
        System.out.println(simpleCar2);
        System.out.println(simpleCar3);


        Bus simpleBus1 = new Bus("Лиаз","677", 1960, "USSR", "Yellow", 70, 60);
        Bus simpleBus2 = new Bus("Зил","158", 1957, "USSR", "Green", 65, 65);
        Bus simpleBus3 = new Bus("Раф","251", 1955, "USSR", "White", 70, 40);

        printSeparator();
        System.out.println(simpleBus1);
        System.out.println(simpleBus2);
        System.out.println(simpleBus3);
    }
}