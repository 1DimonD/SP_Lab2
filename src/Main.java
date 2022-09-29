import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Automaton au;
    private static String w_0 = "", currWord = "";
    static boolean IsSubpath(int currState) {
        if(currWord.length() > au.statesCount) {
            return false;
        }

        if(au.states.get(currState).isFinal && currWord.contains(w_0)) {
            return true;
        }

        for(Map.Entry<Integer, Integer> x : au.states.get(currState).transitions) {
            currWord = currWord + (currWord.isEmpty() ? "" : " ") + x.getKey();
            if(IsSubpath(x.getValue())) {
                return true;
            }
            currWord = currWord.substring(0, (currWord.length()>1 ? currWord.length()-2 : currWord.length()-1));
        }

        return false;
    }

    public static void main(String[] args) {
        au = new Automaton("resources/Automaton_2.txt");

        Scanner in = new Scanner(System.in);
        System.out.println("Enter any num sequence: ");
        int tmp = 0;
        while (in.hasNextInt()) {
            tmp = in.nextInt();

            if(tmp >= au.alphabetCount || tmp < 0) {
                System.out.println("Wrong input");
                System.exit(0);
            }

            w_0 += tmp + " ";
        }
        if(!w_0.isEmpty()) {
            w_0 = w_0.substring(0, w_0.length()-1);
        }

        System.out.println(IsSubpath(au.startState));
    }
}