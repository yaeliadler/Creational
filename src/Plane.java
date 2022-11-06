public class Plane implements Vehicle {

    @Override
    public void transport(Passanger passanger) {
        System.out.println(passanger.name);
    }
}
