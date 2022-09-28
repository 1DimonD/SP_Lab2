import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Automaton au;
    private static String w_0, currWord = "";
    static boolean IsSubpath(int currState) {
        if(currWord.length() > au.states.size()) {
            return false;
        }

        if(au.states.get(currState).isFinal && currWord.contains(w_0)) {
            return true;
        }

        for(Map.Entry<Integer, Integer> x : au.states.get(currState).transitions) {
            currWord = currWord + x.getKey();
            if(IsSubpath(x.getValue())) {
                return true;
            }
            currWord = currWord.substring(0, currWord.length()-1);
        }

        return false;
    }

    public static void main(String[] args) {
        au = new Automaton("resources/Automaton_1.txt");

        Scanner in = new Scanner(System.in);
        System.out.println("Enter any num sequence: ");
        w_0 = in.nextLine().replaceAll(" ", "");

        System.out.println(IsSubpath(au.startState));
    }
}