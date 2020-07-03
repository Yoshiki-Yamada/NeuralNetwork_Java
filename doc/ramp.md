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

![ramp関数のグラフ]()  
