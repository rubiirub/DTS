import java.util.Scanner;

public class algo1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a, y, x;
        System.out.print("Masukkan Angka :");
        a = input.nextInt();
        x =1;
        y = x*x;

        while (y!=a){
            x=x+1;
            y=x*x;


        }
        System.out.println("Akar :" + x);


    }
}
