public class Boat implements Vehicle {

    @Override
    public void transport(Passanger passanger) {
        System.out.println(passanger.name);
    }
}