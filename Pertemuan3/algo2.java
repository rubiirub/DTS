import java.util.Scanner;

public class algo2 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int a;
        System.out.print("Masukkan Bilangan : ");
        a = input.nextInt();
        if (a%2 == 0){
            System.out.println("Genap");

        }else{
            System.out.println("Ganjil");
        }

    }
}
