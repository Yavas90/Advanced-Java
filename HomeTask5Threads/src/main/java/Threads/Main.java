package Threads;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr1 = new float[size];
        float[] arr2 = new float[size];

        methodArr1(arr1);
        methodArr2(arr2);
    }

    private static void methodArr1(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long start1 = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = formula(arr[i], i);
        }

        System.out.println("Время исполнения 1го метода: " + (System.currentTimeMillis() - start1));
    }

    private static void methodArr2(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long start2 = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread tr1  =   new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a1[i] = formula(a1[i], i);
                //System.out.println("Thread1 " + a1[i]);
            }
        });
        Thread tr2  =   new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a2[i] = formula(a2[i], i);
                //System.out.println("Thread2 " + a2[i]);
            }
        });

        tr1.start();
        tr2.start();

        /// Ожидаем пока потоки выполняться.
        /// 1-й метод. Ручной
        /*
        while
            (tr1.isAlive() || tr2.isAlive()){
        }
        */

        /// 2-й метод. встроенный.
        try {
            tr1.join();
            tr2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Время исполнения 2го метода: " + (System.currentTimeMillis() - start2));
    }

    private static float formula(float value, int index) {
        return (float) (value * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
    }
}
