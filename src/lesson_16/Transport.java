package lesson_16;

public class Transport {

    /////// fields ///////
    private final String brand;
    private final String model;
    private final int releaseYear;
    private final String productionCountry;
    private String bodyColor;
    private int maxSpeed;

    ////////////////////////////////// class for default values ///////////////////////////
    protected static class Default_Values{
        static String default_brand = "default_brand";
        static String default_model = "default_model";
        static int default_year = 2000;
        static String default_country = "default_country";
        static String default_Color = "default_white";
        static int default_max_speed = 170;
    } // Default_Values

    /////// constructor /////
    public Transport(String brand,String model, int releaseYear, String productionCountry, String bodyColor, int maxSpeed) {


        java.time.LocalDate date = java.time.LocalDate.now();
        int currentYear = date.getYear();
        releaseYear = (releaseYear>1920 && releaseYear<(currentYear+1))? releaseYear : Default_Values.default_year;

        this.brand= simpleCheckString(brand,Default_Values.default_brand);
        this.model= simpleCheckString(model,Default_Values.default_model);
        this.releaseYear=releaseYear;
        this.productionCountry= simpleCheckString(productionCountry,Default_Values.default_country);
        this.setBodyColor(bodyColor);
        this.setMaxSpeed(maxSpeed);
    }
    /////// utility ////////

    protected String simpleCheckString(String forCheck, String default_value) {
        if(forCheck==null || forCheck.isBlank()) {
            System.out.println("Некорректный ввод. Значение будет измененено на: "+default_value);
            return default_value;
        }
        return forCheck.trim().replace("\\s+"," ");
    }
    @Override
    public String toString() {
        return String.format("Brand[%1$s], Model[%2$s], Year[%3$d], Country[%4$s], Color[%5$s], MaxSpeed[%6$d]", brand, model, releaseYear, productionCountry, bodyColor, maxSpeed);
    }
    /////// setters ///////

    public void setBodyColor(String bodyColor) {
        if (bodyColor!=null && !bodyColor.isBlank()) {
            this.bodyColor = bodyColor;
        } else  {
            this.bodyColor=Default_Values.default_Color;
        }

    }

    public void setMaxSpeed(int maxSpeed) {
        if(maxSpeed>0 && maxSpeed<400){
            this.maxSpeed = maxSpeed;
        }
        else {
            this.maxSpeed = Default_Values.default_max_speed;
        }
    }


    /////// getters //////

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
} // Transport
