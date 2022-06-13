//Написать программу вычисления n-ого треугольного числа.
import java.util.Scanner;
public class homework1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер треугольного числа: ");
        int x = in.nextInt();
        System.out.println(x+"-е треугольное число: "+ x*(x+1)/2);
    }

}
