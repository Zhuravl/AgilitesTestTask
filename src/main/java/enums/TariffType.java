package enums;

/**
 * Class contains all tariffs
 */
public enum TariffType {

    FREE(30, "64", 0),
    T320(30, "320", 300),
    T416(30, "416", 350),
    T512(30, "512", 400),
    T640(30, "640", 450),
    T768(30, "768", 500),
    T896(30, "896", 550),
    T1000(30, "1000", 600),
    T1300(30, "1300", 650),
    T1700(30, "1700", 700),
    T2100(30, "2100", 750),
    T3100(30, "3100", 800),
    T4100(30, "4100", 850),
    T5000(30, "5000", 900),
    T5700(30, "5700", 950),
    T6400(30, "6400", 1000),
    T7100(30, "7100", 1050),
    T7800(30, "7800", 1100),
    T8500(30, "8500", 1150),
    T9200(30, "9200", 1200),
    T10000(30, "10000", 1250),
    T12000(30, "12000", 1300),
    T15000(30, "15000", 1350),
    TMax(30, "Макс", 1400);

    private int time;
    private String speed;
    private int cost;

    TariffType(int time, String speed, int cost){
        this.time = time;
        this.speed = speed;
        this.cost = cost;
    }

    public int getTime(){
        return time;
    }

    public String getSpeed(){
        return speed;
    }

    public int getCost(){
        return cost;
    }

    public static TariffType getTariffType(int time, String speed, int cost){
        TariffType tariffTypeResult = null;

        for (TariffType tariff : TariffType.values()){

            if ((tariff.getSpeed().equals(speed)) && (tariff.getCost() == cost)){
                tariffTypeResult = tariff;
                break;
            }
        }
        return tariffTypeResult;
    }

    @Override
    public String toString(){
        return "Tariff parameters: Time: " + time + ", Speed: " + speed + ", Cost: " + cost + ".";
    }
}
