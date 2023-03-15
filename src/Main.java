import task1.ShipDock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ShipDock dock = new ShipDock(
                new double[]{
                        10, //0
                        8,  //1
                        2,  //2
                        1,  //3
                        5,  //4
                        7,  //5
                        12, //6
                        20, //7
                        19, //8
                        17, //9
                        21,//10
                        18,//11
                        15,//12
                        13,//13
                        11,//14
                        10,//15
                        9,//16
                        25,//17
                        30,//18
                        31,//19
                        25,//20
                        20,//21
                        17,//22
                        12,//23
                },
                new double[]{
                        1,//0
                        0,//1
                        0,//2
                        0,//3
                        0,//4
                        2,//5
                        3,//6
                        4,//7
                        4,//8
                        3,//9
                        2,//10
                        1,//11
                        0,//12
                        0,//13
                        2,//14
                        2,//15
                        3,//16
                        5,//17
                        6,//18
                        3,//19
                        0,//20
                        0,//21
                        0,//22
                        2,//23
                });
        dock.start();
    }
}
