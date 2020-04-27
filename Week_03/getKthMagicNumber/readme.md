```java
动态规划

public int getKthMagicNumber(int k) {
        int p3=0,p5=0,p7=0;
        int[] a = new int[k];
        a[0] = 1;
        for (int i=1;i<a.length;i++){
            a[i] = Math.min(a[p3]*3,Math.min(a[p5]*5,a[p7]*7));
            if (a[i] == a[p3]*3) p3++;
            if (a[i] == a[p5]*5) p5++;
            if (a[i] == a[p7]*7) p7++;
        }
        return a[k-1];
    }
```