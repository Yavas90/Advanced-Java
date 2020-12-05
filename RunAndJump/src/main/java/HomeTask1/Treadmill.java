package HomeTask1;

public class Treadmill implements DoActions {


    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void doThis(Actions actions) {
        actions.isRun();
    }

    @Override
    public void checkDoThis(Actions actions) {
            actions.checkIsRun(distance);
    }
}