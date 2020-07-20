package ai;

import java.util.Arrays;
import java.util.Random;

public class NeuralNet {
    final int N_INPUT;
    final int N_HIDDEN;
    final int N_OUTPUT;
    double w1[][];
    double w2[][];
    double b1[];
    double b2[];
    double input[];
    double hidden[];
    double output[];
    /**
     * 3
     */
    double alpha = 0.1;

    public NeuralNet(int nInput, int nHidden, int nOutput) {
        N_INPUT = nInput;
        N_HIDDEN = nHidden;
        N_OUTPUT = nOutput;
        input = new double[N_INPUT];
        hidden = new double[N_HIDDEN];
        output = new double[N_OUTPUT];

        Random rnd = new Random();
        /**
         * 1
         */
        w1 = new double[N_INPUT][N_HIDDEN];
        for (int i = 0; i < N_INPUT; i++) {
            for (int j = 0; j < N_HIDDEN; j++) {
                w1[i][j] = (rnd.nextDouble() * 2.0 - 1.0) * 0.1;
            }
        }
        b1 = new double[N_HIDDEN];
        w2 = new double[N_HIDDEN][N_OUTPUT];
        for (int i = 0; i < N_HIDDEN; i++) {
            for (int j = 0; j < N_OUTPUT; j++) {
                w2[i][j] = (rnd.nextDouble() * 2.0 - 1.0) * 0.1;
            }
        }

        b2 = new double[N_OUTPUT];
    }

    public double[] compute(double x[]) {

        for (int i = 0; i < N_INPUT; i++) {
            input[i] = x[i];
        }

        /**
         * 4
         */
        for (int i = 0; i < N_HIDDEN; i++) {
            hidden[i] = 0.0;
            for (int j = 0; j < N_INPUT; j++) {
                hidden[i] += w1[j][i] * input[j];
            }
            /**
             * 5
             */
            hidden[i] += b1[i];
            hidden[i] = sigmoid(hidden[i]);
//            hidden[i] = ramp(hidden[i]);
        }

        /**
         * 6
         */
        for (int i = 0; i < N_OUTPUT; i++) {
            output[i] = 0.0;
            for (int j = 0; j < N_HIDDEN; j++) {
                output[i] += w2[j][i] * hidden[j];
            }
            /**
             * 7
             */
            output[i] += b2[i];
//            output[i] = sigmoid(output[i]);
//            output[i] = ramp(output[i]);
        }
        output = softmax(output);
        return output;
    }

    public double sigmoid(double i) {
        double a = 1.0 / (1.0 + Math.exp(-i));
        return a;
    }

    public double ramp(double i){
        if (i <= 0){
            return 0;
        }else if (i > 0){
            return i;
        }
        System.out.println("error in ramp function!!");
        return -1;
    }

    public double[] softmax(double[] x){
        double[] y = new double[x.length];
        double sum = 0;

        for (int i=0; i<x.length; i++){
            sum += Math.exp(x[i]);
        }

        for (int i=0; i<x.length; i++){
            y[i] = Math.exp(x[i])/sum;
        }

        return y;
    }

    public void backPropagation(double teach[]) {

        double[] deltas = new double[N_OUTPUT];

        /**
         * 8
         */
        for (int j = 0; j < N_OUTPUT; j++) {
//            deltas[j] = (teach[j] - output[j]) * output[j] * (1.0 - output[j]);
            deltas[j] = (teach[j] - output[j]);
            for (int i = 0; i < N_HIDDEN; i++) {
                w2[i][j] += alpha * deltas[j] * hidden[i];
            }
            b2[j] += alpha * deltas[j];
        }

        /**
         * 9
         */
        for (int i = 0; i < N_HIDDEN; i++) {
            double sum = 0.0;
            for (int j = 0; j < N_OUTPUT; j++) {
                sum += w2[i][j] * deltas[j];
            }
            double delta = hidden[i] * (1.0 - hidden[i]) * sum;
            for (int j = 0; j < N_INPUT; j++) {
                w1[j][i] += alpha * delta * input[j];
            }
            b1[i] += alpha * delta;
        }
    }

    public double calcError(double teach[]) {
        double e = 0.0;
        /**
         * 10
         */
        for (int i = 0; i < teach.length; i++) {
            e += Math.pow(teach[i] - output[i], 2.0);
        }
        e *= 0.5;
        return e;
    }

    public void learn(double[][] knownInputs, double[][] teach) {
        int step = 0;
        while (true) {
            double e = 0.0;
                for (int i = 0; i < knownInputs.length; i++) {
                    compute(knownInputs[i]);
                    backPropagation(teach[i]);
                    e += calcError(teach[i]);
                }

            if (step % 10 == 0) {
                System.out.println("step:" + step + ", loss=" + e);
            }

            /**
             * 11
             */
            if (e < 0.0001) {
                break;
            }
            step++;
        }
    }
}