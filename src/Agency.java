import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Agency {
    final static int busses = 4;
    final static int taxis = 8;
    final static int boats = 3;
    final static int planes = 1;

    private static class PassangerInVehicle {
        Passanger passanger;
        Vehicle vehicle;

        PassangerInVehicle(Passanger passanger, Vehicle vehicle) {
            this.passanger = passanger;
            this.vehicle = vehicle;
        }
    }

    private List<Vehicle> vehicles;
    private List<PassangerInVehicle> passangerInVehicle;

    public Agency(){
        vehicles = new ArrayList<>();
        passangerInVehicle = new ArrayList<>();
        VehicleFactory factory = VehicleFactory.getInstance();
        for (int i = 0; i < busses; i++) {
            vehicles.add(factory.createVehicle(VehicleType.BUS));
        }
        for (int i = 0; i < taxis; i++) {
            vehicles.add(factory.createVehicle(VehicleType.TAXI));
        }
        for (int i = 0; i < boats; i++) {
            vehicles.add(factory.createVehicle(VehicleType.BOAT));
        }
        for (int i = 0; i < planes; i++) {
            vehicles.add(factory.createVehicle(VehicleType.PLANE));
        }
    }

    public void AddPassanger(Passanger passanger) {
        if (vehicles.size() < 1) {
            throw new ArrayIndexOutOfBoundsException("There are no vehicles left");
        }

        int targetIndex = -1;
        for (int i = 0; i < vehicles.size() && targetIndex < 0; i++) {
            switch (passanger.favoriteVehicle) {
                case BOAT:
                    if (vehicles.get(i) instanceof Boat) {
                        targetIndex = i;
                        break;
                    }
                case TAXI:
                    if (vehicles.get(i) instanceof Taxi) {
                        targetIndex = i;
                        break;
                    }
                case BUS:
                    if (vehicles.get(i) instanceof Bus) {
                        targetIndex = i;
                        break;
                    }
                case PLANE:
                    if (vehicles.get(i) instanceof Plane) {
                        targetIndex = i;
                        break;
                    }
            }
        }
        if (targetIndex < 0) {
            targetIndex = new Random().nextInt(vehicles.size());
        }
        passangerInVehicle.add(new PassangerInVehicle(passanger, vehicles.get(targetIndex)));
        vehicles.remove(targetIndex);

        if (vehicles.isEmpty()) {
            for (PassangerInVehicle piv : passangerInVehicle) {
                piv.vehicle.transport(piv.passanger);
            }
        }
    }


}
