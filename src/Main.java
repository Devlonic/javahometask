import math.matrices.MyMatrix;

public class Main {
    public static void main(String[] args) {
        // home task 4

//        // task1
//        MyArray<Integer> arr = new MyArray<Integer>();
//        arr.fill(10, MyArray.randomIntGenerator());
//        arr.print();
//
//        MyArray<Integer> arr3 = new MyArray<Integer>();
//        arr3.fill(4, MyArray.consoleInputIntGenerator());
//        arr3.print();
//
//        int min = arr3.getMin(MyArray.integerComparator());
//        System.out.println("Min is " + min);
//
//        int max = arr3.getMax(MyArray.integerComparator());
//        System.out.println("Max is " + max);
//
//        double avg = arr3.getAverage();
//        System.out.println("Avg is " + avg);
//
//        arr3.sortDesc();
//        arr3.print();
//
//        arr3.sortAsc();
//        arr3.print();
//
//        int key = -2;
//        int index = arr3.findIndex(key);
//        System.out.printf("Index of '%s' is '%d'\n", key, index);
//
//        try {
//            arr3.replace(key, -22222);
//            arr3.print();
//        } catch (ArrayStoreException e) {
//            System.out.println("ERROR " + e.toString());
//        }
//
//
//        int index2 = arr3.findIndex(-22222);
//        System.out.printf("Index of '%s' is '%d'\n", -22222, index2);

        // task2
        System.out.println("m1(4x3)");
        MyMatrix<Integer> m1 = new MyMatrix<>();
        m1.fill(4,3, MyMatrix.randomIntGenerator());
        m1.print();
        System.out.println("m1 * 2");
        m1.multiple(2).print();

        System.out.println("m2(4x3)");
        MyMatrix<Integer> m2 = new MyMatrix<>();
        m2.fill(4,3, MyMatrix.randomIntGenerator());
        m2.print();

        System.out.println("m1 + m2");
        m1.add(m2).print();

        System.out.println("m2 - m1");
        m2.subtract(m1).print();

        System.out.println("m4(4x3, double)");
        MyMatrix<Double> m4 = new MyMatrix<>();
        m4.fill(4,3, MyMatrix.randomDoubleGenerator());
        m4.print();

        System.out.println("m5(4x3, double)");
        MyMatrix<Double> m5 = new MyMatrix<>();
        m5.fill(4,3, MyMatrix.randomDoubleGenerator());
        m5.print();

        System.out.println("m4 + m5");
        var m6 = m4.add(m5);
        m6.print();

        Integer[][] arr1 = {
            { 1, 0, 2},
            {-1, 3, 1},
        };
        var m7 = new MyMatrix<Integer>(arr1);
        m7.print();


        Integer[][] arr2 = {
                { 3, 1 },
                { 2, 1 },
                { 1, 0 },
        };
        var m8 = new MyMatrix<Integer>(arr2);
        m8.print();

        System.out.println("Average=" + m8.getAverage());
        System.out.println("Min=" + m8.getMin(null));
        System.out.println("max=" + m8.getMax(null));


        System.out.println("m7 * m8");
        m7.multiple(m8).print();

        System.out.println("m9(6x7)");
        MyMatrix<Integer> m9 = new MyMatrix<>();
        m9.fill(6,7, MyMatrix.randomIntGenerator());
        m9.print();

        System.out.println("m9(7x6)");
        MyMatrix<Integer> m10 = new MyMatrix<>();
        m10.fill(7,6, MyMatrix.randomIntGenerator());
        m10.print();

        System.out.println("m9 * m10");
        m9.multiple(m10).print();

        System.out.println("m11(2x2)");
        MyMatrix<Integer> m11 = new MyMatrix<>();
        m11.fill(2,2, MyMatrix.randomIntGenerator());
        m11.print();

        System.out.println("m12(2*2)");
        MyMatrix<Integer> m12 = new MyMatrix<>();
        m12.fill(2,2, MyMatrix.randomIntGenerator());
        m12.print();

        //System.out.println("m11 / m12");
        //m12.divide(m11).print();
    }
}
