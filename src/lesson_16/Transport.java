package lesson_16;

public class Transport {

    /////// fields ///////
    protected String brand;
    protected String model;
    protected final int releaseYear;
    protected final String productionCountry;
    protected String bodyColor;
    protected int maxSpeed;

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
    Transport(String brand,String model, int releaseYear, String productionCountry, String bodyColor, int maxSpeed) {


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

    public double getMaxSpeed() {
        return maxSpeed;
    }
} // Transport
