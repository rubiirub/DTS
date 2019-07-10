import java.util.Scanner;

public class algo4 {
    public static void main (String[] args){
        int bil1, bil2;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Bilangan 1 : ");
        bil1 = input.nextInt();
        System.out.print("Masukkan Bilangan 2 : ");
        bil2 = input.nextInt();

        if (bil1==bil2){
            System.out.println("Sama Besar");
        }else if (bil1<bil2){
            System.out.println("Bilangan 1 kurang dari Bilangan 2");

        }else if (bil1>bil1) {
            System.out.println("Bilangan 1 lebih besar dari Bilangan 2");
        }

    }
}
