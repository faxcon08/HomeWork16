package lesson_16;

public class Bus extends Transport{
    private static int busCounter = 0;
    private int currentBusNumber;
    private final int seatAmount;
    protected static class Default_Values extends Transport.Default_Values {
        static int default_seat_amount = 50;
    }
    public Bus(String brand,String model, int releaseYear, String productionCountry, String bodyColor, int maxSpeed, int seatAmount) {

        super(brand,model,releaseYear,productionCountry,bodyColor,maxSpeed);
        currentBusNumber=++busCounter;
        if(seatAmount>1 && seatAmount < 200) {
            this.seatAmount = seatAmount;
        }
        else {
            this.seatAmount=Default_Values.default_seat_amount;
        }
    }

    @Override
    public String toString() {
        return "Bus №"+currentBusNumber+": "+super.toString()+", SeatAmount["+seatAmount+"]";
    }
}
