package HomeTask2;


public class Main {
    public static void main(String[] args) throws Exception, MyArraySizeException, MyArrayDataEception {
        String[][] myArr = new String[4][4];
        for (int i = 0; i < myArr.length; i++) {
            for (int j = 0; j < myArr.length; j++) {
                myArr[i][j] = "2";
                System.out.print(myArr[i][j] + " ");
            }
            System.out.println();
        }

        try {

            TestExcep.checkMyArray(myArr);
        } catch (MyArraySizeException e) {
            System.out.println("Длина массива больше четырех элементов!");
        } catch (MyArrayDataEception e) {

        }
    }
}

