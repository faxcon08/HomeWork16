package lesson_16;

public class Car extends Transport{
    /////////////////////////////////// class for default values ///////////////////////////
    protected static class Default_Values extends Transport.Default_Values{
        static double default_engine_volume = 1.5;
        static String default_body_type = "седан";
        static String default_transmission = "автоматическая";
        static String default_registration_number = "E000RR000";
        static int default_number_seats = 4;
        static boolean default_is_summer_wheels = true;
    }
    /////////////////////////////////////////// "old" elements /////////////////////////
    private double engineVolume;

    ////////////////////////////////////////// new elements ////////////////////////////
    private String transmission;
    final private String bodyType;            // final
    private String registrationNumber;   // M976MM777
    private final int numberSeats;                    // final
    private boolean isSummerWheels;

    boolean startMoving = false;

    public class  Key{
        final private boolean remoteStartEngine;
        final private boolean keylessAccess;


        public Key(boolean remoteStartEngine, boolean keylessAccess) {
            this.remoteStartEngine=remoteStartEngine;
            this.keylessAccess=keylessAccess;
        }

        public void startKey() {
            startMoving=true;
            System.out.println("Автомобиль "+getBrand()+" "+getModel()+ " начал движение. ");
        }

        public void stopKey() {
            startMoving=false;
            System.out.println("Автомобиль "+getBrand()+" "+getModel()+ " остановился. ");
        }
        @Override
        public String toString() {
            return "Данный автомобиль с опциями: "+ ((keylessAccess)? ("'Беслючевой доступ' и"):("без функции 'Бесключевой доступ' и")) + ((remoteStartEngine)?" 'Удаленный запуск двигателя'":
            " без функции 'Удаленный запуск двигателя'");
        }

        public boolean isRemoteStartEngine() {
            return remoteStartEngine;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    } // Key class


    public Car(String brand, String model, double engineVolume, String bodyColor, int releaseYear, String productionCountry,
               String transmission, String bodyType, String registrationNumber, int numberSeats, boolean isSummerWheels, int maxSpeed) {

        super( brand,
                model,
                releaseYear,
                productionCountry,
                bodyColor,
                maxSpeed);

       /* В конструкторе наследника  требуется, чтобы вызов super-конструктора был самым первым. Даже не допускается вызов методов-проверок в super-конструкторе.
        Как тогда реализовать проверку final-полей super-а  в наследнике , если потребуется, допустим, доп. проверка(доп. условия) при инициализации наследника? Пришлось Релизовывать проверку в родителе.*/

        setEngineVolume(engineVolume);
        setTransmission(transmission);
        setRegistrationNumber(registrationNumber);

        if(bodyType==null || bodyType.isBlank())
            this.bodyType=Default_Values.default_body_type;
        else {
           bodyType=bodyType.trim().replace("\\s+","").toLowerCase();
           switch (bodyType){
               case ("седан"):
               case ("универсал"):
               case ("хэтчбек"):
               case ("лимузин"):
               case ("внедорожник"):
               case ("кроссовер"):
               case ("купе"):
               case ("микроавтобус"):
               case ("минивэн"):
               case ("кабриолет"):
               case ("пикап"):
               case ("фургон"):
               case ("родстер"):

                   this.bodyType=bodyType;
                   break;
               default:
                   this.bodyType=Default_Values.default_body_type;
                   break;
           }// switch
        }// bodyType


        if(numberSeats>1 && numberSeats<=7)  {this.numberSeats=numberSeats;}
        else { this.numberSeats=Default_Values.default_number_seats;
        }
        this.isSummerWheels=isSummerWheels;
    } // constructor

    @Override
    public String toString() {
        String wheelsType = (isSummerWheels) ? "Летня резина" : "Зимняя резина";
        return String.format("Brand: [%1$s] model:[%2$s] Volume: [%3$.2f] Color: [%4$s]" +
                " Year: %5$d Country: [%6$7s] Тип Кузова: [%7$s] Коробка передач: [%8$s] Регистрационный номер: [%9$s] Количество мест: [%10$d] [%11$s] Скорость:[%12$d]","'"+getBrand()+"'","'"+getModel()+"'",
                engineVolume, getBodyColor(), getReleaseYear(),getProductionCountry(),bodyType,transmission, registrationNumber, numberSeats, wheelsType,getMaxSpeed());
    }
    ///////////////// getters  ///////////

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public boolean isSummerWheels() {
        return isSummerWheels;
    }


    //////////////////// utility  ///////////////

    /////////////////////////////////////// setters /////////////////////////

    public void setEngineVolume(double engineVolume) {
        if(engineVolume>0)
            this.engineVolume=engineVolume;
        else {
            System.out.println("Некорректный ввод. Значение будет измененено на :"+Default_Values.default_engine_volume);
            this.engineVolume=Default_Values.default_engine_volume;
        }
    }// setEngineVolume

    public void setTransmission(String transmission) {
        transmission = simpleCheckString(transmission, Default_Values.default_transmission).toLowerCase();
        switch(transmission) {
            case ("механическая"):
            case("гидромеханическая"):
            case("гидравлическая"):
            case("электромехнаическая"):
            case("автоматическая"):
                this.transmission=transmission;
                break;
            default:
                this.transmission=Default_Values.default_transmission;
                System.out.println("Некорректный ввод. Значение будет измененено на: "+Default_Values.default_transmission);
                break;
        }

    }

    public void setRegistrationNumber(String registrationNumber) { ///// M976MM777

        if(registrationNumber== null || registrationNumber.isBlank()){
            this.registrationNumber=Default_Values.default_registration_number;
            System.out.println("Некорректный ввод. Значение будет измененено на :"+Default_Values.default_registration_number);
            return;
        }
        registrationNumber = registrationNumber.trim().replaceAll("\\s+", "");
        if (registrationNumber.length() != 9 || !Character.isLetter(registrationNumber.charAt(0))) {
            this.registrationNumber=Default_Values.default_registration_number;
            System.out.println("Некорректный ввод. Значение будет измененено на: "+Default_Values.default_registration_number);
            return;
        }
        if(  Character.isDigit(registrationNumber.charAt(1)) && Character.isDigit(registrationNumber.charAt(2)) && Character.isDigit(registrationNumber.charAt(3)) &&
                Character.isLetter(registrationNumber.charAt(4)) && Character.isLetter(registrationNumber.charAt(5)) && Character.isDigit(registrationNumber.charAt(6)) &&
                Character.isDigit(registrationNumber.charAt(7)) && Character.isDigit(registrationNumber.charAt(8))) {
            this.registrationNumber = registrationNumber.toUpperCase();
        }
        else {
            this.registrationNumber=Default_Values.default_registration_number;
            System.out.println("Некорректный ввод. Значение будет измененено на: "+Default_Values.default_registration_number);
        }
    }

    public void setSummerWheels(boolean summerWheels) {
        isSummerWheels = summerWheels;
    }

    public void changeWheelsBySeason(int month) {
        if (month <= 0 || month > 12) {
            System.out.println("Неверный номер месяца: "+month);
            return;
        }
        switch (month) {
            case (11):
            case (12):
            case (1):
            case (2):
                this.isSummerWheels=false;
                break;
            default:
                this.isSummerWheels=true;
                break;
        }
    }
} // Car
