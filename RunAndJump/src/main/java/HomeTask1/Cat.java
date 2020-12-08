package HomeTask1;

public class Cat implements Actions {

    private String name;
    private int canJump;
    private int canRun;

    public Cat(String name, int canJump, int canRun) {

        this.name = name;
        this.canJump = canJump;
        this.canRun = canRun;
    }

    public int getCanJump() {
        return canJump;
    }

    public int getCanRun() {
        return canRun;
    }
    public String getName() {
        return name;
    }

    @Override
    public void isRun() {
        System.out.println(getName() + " может пробежать " + getCanRun() + " метра!");
    }

    @Override
    public void isJump() {
        System.out.println(getName() + " может перепрыгнуть " + getCanJump() + " метра!");
    }

    @Override
    public void checkIsRun(int getDistance) {

        while (getCanRun() >= getDistance) {
            if (getCanRun() >= getDistance) {
                System.out.println(getName() + " пробежал дистанцию в " + getDistance + " метров!");
            } else System.out.println("Для " + getName() + " это слишком далеко!");
            break;
        }
    }

    @Override
    public void checkIsJump(int getHeight) {

        while (getCanJump() >= getHeight) {
            if (getCanJump() >= getHeight) {
                System.out.println("\n" + getName() + " перепрыгнул стену высотой " + getHeight + " метров!");
            } else System.out.println("Для " + getName() + " это слишком высоко!");
            break;
        }
    }
}
