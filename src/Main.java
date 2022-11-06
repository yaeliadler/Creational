public class Main {
    public static void main(String[] args) {
        Agency agency = new Agency();
        Passanger[] passangers = new Passanger[]{
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS),
                new Passanger("Moshe", VehicleType.BUS)
        };
        for (Passanger p : passangers) {
            agency.AddPassanger(p);
        }
    }
}