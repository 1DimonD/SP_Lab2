import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Automaton au = new Automaton("resources/Automaton_1.txt");

        Scanner in = new Scanner(System.in);
        String w_0 = in.nextLine();

        System.out.println(au.IsContained(w_0));
    }
}