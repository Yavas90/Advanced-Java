package HomeTask1;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Alex", 2, 250);
        Cat cat = new Cat("Morgenmuffel", 5, 300);
        Robot robot = new Robot("AR2D2", 20, 100);
        Wall wall = new Wall(5);
        Treadmill treadmill = new Treadmill(200);

            human.isRun();
            human.isJump();
        System.out.println(" ");
            cat.isRun();
            cat.isJump();
        System.out.println(" ");
            robot.isRun();
            robot.isJump();

        System.out.println(" ");
// Проходим по массивам классов
            Actions[] actions = new Actions[3];

            actions[0] = human;
            actions[1] = cat;
            actions[2] = robot;

            DoActions[] doActions = new DoActions[2];
            doActions[0] = wall;
            doActions[1] = treadmill;

        for (int i = 0; i < actions.length; i++) {
            for (int j = 0; j < doActions.length; j++) {
                doActions[j].doThis(actions[i]);
            }
        }

        System.out.println(" ");
//Проверяем кто, что может и останавливаем если не смог преодолеть препятствие.
        for (int i = 0; i < actions.length; i++) {
            for (int j = 0; j < doActions.length; j++) {
                doActions[j].checkDoThis(actions[i]);
            }
        }
    }
}
