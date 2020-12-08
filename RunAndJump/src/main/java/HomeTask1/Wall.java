package HomeTask1;

public class Wall implements DoActions {


    private int height;

    public Wall(int height) {
       this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void doThis(Actions actions) {
         actions.isJump();
    }

    @Override
    public void checkDoThis(Actions actions) {
            actions.checkIsJump(height);
    }
}
