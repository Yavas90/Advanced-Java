package HomeTask2;

public class TestExcep {


    public static void checkMyArray(String[][] args) throws Exception, MyArraySizeException, MyArrayDataEception {
        int sum = 0;

        if (args.length > 4)
            throw new MyArraySizeException();


        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                try {
                    sum +=Integer.parseInt(args[i][j]);
                } catch (NumberFormatException e){
                    System.out.println();
                    throw new MyArrayDataEception(i, j);
                }
            }
        }
        System.out.println("\nСумма элементов массива: " + sum);
    }
}