# ramp関数の実装

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
