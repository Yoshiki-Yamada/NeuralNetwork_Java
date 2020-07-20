# ramp関数

## ramp関数の実装
Javaコード  

```java
public double ramp(double i){
        if (i <= 0){
            return 0;
        }else if (i > 0){
            return i;
        }
        System.out.println("error in ramp function!!");
        return -1;
    }
```

![ramp関数のグラフ](https://github.com/Yoshiki-Yamada/NeuralNetwork_Java/blob/master/doc/%E3%82%B9%E3%82%AF%E3%83%AA%E3%83%BC%E3%83%B3%E3%82%B7%E3%83%A7%E3%83%83%E3%83%88%202020-07-03%2017.58.43.png)  


## 結果

```
【ramp関数の実行結果】
--学習開始--
step:0, loss=0.4680538739561724
step:100, loss=0.016034031750340197
step:200, loss=0.0025239916572844675
step:300, loss=9.193802352748237E-4
step:400, loss=4.651131338712486E-4
step:500, loss=2.788201380167053E-4
step:600, loss=1.852690952872509E-4
step:700, loss=1.3189036346351377E-4
--学習終了--
--推論開始--
⼊⼒データ
0 1 1 1 1 0
0 1 0 0 1 0
0 1 0 0 1 0
0 1 0 0 1 0
0 1 0 0 1 0
0 0 1 1 0 0
期待する値（⽂字）：0
ニューラルネットワークが予測した値（⽂字）：0
⼊⼒データ
0 0 0 0 0 0
0 0 1 1 0 0
0 0 1 1 0 0
0 0 1 1 0 0
0 0 1 1 0 0
0 0 1 1 0 0
期待する値（⽂字）：1
ニューラルネットワークが予測した値（⽂字）：1
```
