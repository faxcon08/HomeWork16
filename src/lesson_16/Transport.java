package lesson_16;

public class Transport {

    /////// fields ///////
    protected String brand;
    protected String model;
    protected final int releaseYear;
    protected final String productionCountry;
    protected String bodyColor;
    protected int maxSpeed;

    /////// constructor /////
    Transport(String brand,String model, int releaseYear, String productionCountry, String bodyColor, int maxSpeed) {
        this.brand=brand;
        this.model=model;
        this.releaseYear=releaseYear;
        this.productionCountry=productionCountry;
        this.setBodyColor(bodyColor);
        this.setMaxSpeed(maxSpeed);
    }
    /////// setters ///////

    public void setBodyColor(String bodyColor) {
        String default_body_color = "white(default)";
        if (bodyColor!=null && !bodyColor.isBlank()) {
            this.bodyColor = bodyColor;
        } else  {
            this.bodyColor=default_body_color;
        }

    }

    public void setMaxSpeed(int maxSpeed) {
        int default_max_speed = 70;
        if(maxSpeed>0 && maxSpeed<400){
            this.maxSpeed = maxSpeed;
        }
        else {
            this.maxSpeed = default_max_speed;
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
