import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(calc(string));
    }
    public static String calc(String string) throws Exception {
        Calc romCalc = new Calc();
        romCalc.Caculate(string);
        return romCalc.Caculate(string);
    }
}

