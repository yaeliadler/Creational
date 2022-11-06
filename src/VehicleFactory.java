public class VehicleFactory {
    private static VehicleFactory instance;

    public static VehicleFactory getInstance() {
        if (instance == null) {
            instance = new VehicleFactory();
        }
        return instance;
    }

    private VehicleFactory() {}

    public Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case PLANE:
                return new Plane();
            case BUS:
                return new Bus();
            case BOAT:
                return new Boat();
            case TAXI:
                return new Taxi();
            default:
                throw new IllegalArgumentException("Vehicle does not exist");
        }
    }

}
