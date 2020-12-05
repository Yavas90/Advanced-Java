package HomeTask2;

public class MyArrayDataEception extends Throwable {


    public MyArrayDataEception(int i, int j) {
        super("Ошибка в (" + i + "," + j + ")");
    }

}
