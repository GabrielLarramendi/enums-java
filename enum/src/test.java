import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Meu nome é: ");
        String name = sc.nextLine();

        String newName = name.substring(0, 1).toUpperCase().concat(name.substring(1));
        System.out.println(newName);

        sc.close();
    }
}
