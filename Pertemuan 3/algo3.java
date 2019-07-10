import java.util.Scanner;

public class algo3 {
    public static void main (String[] args){
        double r, luas, keliling;
        double phi = 3.14;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Jari-jari : ");
        r = input.nextInt();

        luas = phi * r * r;
        keliling = 2 * phi * r;

        System.out.println("Luas lingkarannya adalah " +luas);
        System.out.println("Keliling lingkarannya adalah " +keliling);

    }
}
