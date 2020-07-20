package ai;

public class CRApp {
    static final int MASS_X = 6;
    static final int MASS_Y = 6;

    public static void main(String[] args) {
        NeuralNet nn = new NeuralNet(36, 36, 4);

        /**
         * 2
         */
        //訓練データ
        double knownInputs[][] = {
                {
                        0, 0, 1, 1, 0, 0,
                        0, 1, 0, 0, 1, 0,
                        0, 1, 0, 0, 1, 0,
                        0, 1, 0, 0, 1, 0,
                        0, 1, 0, 0, 1, 0,
                        0, 0, 1, 1, 0, 0
                },
                {
                        0, 0, 0, 1, 0, 0,
                        0, 0, 0, 1, 0, 0,
                        0, 0, 0, 1, 0, 0,
                        0, 0, 0, 1, 0, 0,
                        0, 0, 0, 1, 0, 0,
                        0, 0, 0, 1, 0, 0
                }
        };

        //教師データ
//        double t[][] = {
//                {0, 0, 0, 0},
//                {0, 0, 0, 1}
//        };
        double t[][] = {
                {0, 0, 0, 1},
                {0, 0, 1, 0}
        };

        System.out.println("--学習開始--");
        nn.learn(knownInputs, t);
        System.out.println("--学習終了--");
        System.out.println("\n--推論開始--");

        //入力データ
        double[][] unknownInputs = {
                {
                        0, 1, 1, 1, 1, 0,
                        0, 1, 0, 0, 1, 0,
                        0, 1, 0, 0, 1, 0,
                        0, 1, 0, 0, 1, 0,
                        0, 1, 0, 0, 1, 0,
                        0, 0, 1, 1, 0, 0
                },
                {
                        0, 0, 0, 0, 0, 0,
                        0, 0, 1, 1, 0, 0,
                        0, 0, 1, 1, 0, 0,
                        0, 0, 1, 1, 0, 0,
                        0, 0, 1, 1, 0, 0,
                        0, 0, 1, 1, 0, 0
                }
        };

//        double expects[][] = {
//                {0, 0, 0, 0},
//                {0, 0, 0, 1}
//        };
        double expects[][] = {
                {0, 0, 0, 1},
                {0, 0, 1, 0}
        };
        for (int i = 0; i < unknownInputs.length; i++) {
            double[] output = nn.compute(unknownInputs[i]);
            print(unknownInputs[i], output, expects[i]);
        }
        System.out.println("\n--推論終了--");
    }


    public static void print(double[] input, double[] output, double[] expect) {
        System.out.println();
        System.out.println("⼊⼒データ");
        for (int j = 0; j < MASS_Y; j++) {
            for (int k = 0; k < MASS_X; k++) {
                System.out.print((int) input[j * MASS_X + k]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("期待する値（⽂字）：" + value(expect));
        System.out.println("ニューラルネットワークが予測した値（⽂字）：" +
                value(output));
    }


    public static int value(double[] a) {
        int v1 = (int) (a[0] + 0.5);
        int v2 = (int) (a[1] + 0.5);
        int v3 = (int) (a[2] + 0.5);
        int v4 = (int) (a[3] + 0.5);
//        return v1 * 8 + v2 * 4 + v3 * 2 + v4 * 1;
        return v1 * 3 + v2 * 2 + v3 * 1 + v4 * 0;
    }
}