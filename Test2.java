1.
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int count=0;
    while(n!=0){
        count++;
        n&=(n-1);
    }
        sc.close();
    System.out.println(count);
    
}
}

2.
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        n=n^m;
        m=n^m;
        n=n^m;
        System.out.printf("%d %d",n,m);
        sc.close();
    }
}

3.
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(a>b?a:b) ;
    }
}

