# softmax関数の実装

## softmax関数の仕組み
softmax関数は、ベクトルを入力として計算し、出力は合計したら1になる。
入力値ベクトルがn個からなる場合の入力ベクトルと出力ベクトルは、

入力値ベクトル (x1,x2,…,xn)(x1,x2,…,xn)
出力値ベクトル (y1,y2,…,yn)(y1,y2,…,yn)

とした場合、式は以下のようになる。

![softmax](a)  

## コード
softmax関数のコードは以下の通りである。  

```java
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
```

