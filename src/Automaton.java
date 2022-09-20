import java.io.FileReader;
import java.util.*;

public class Automaton {

    public class State {
        public boolean isFinal = false;
        private ArrayList<Map.Entry<Integer, Integer>> transitions = new ArrayList<>();

        public void AddTransition(int alphabetSymbol, int toState) {
            transitions.add(new AbstractMap.SimpleEntry<>(alphabetSymbol, toState));
        }

        public int go(int alphabetSymbol) {
            if(transitions.containsKey(alphabetSymbol))
            {
                return transitions.get(alphabetSymbol);
            }

            return -1;
        }
    }

    private int alphabetCount, statesCount, startState;
    private ArrayList<State> states;
    public Automaton(String filepath) {
        try(Scanner in = new Scanner(new FileReader(filepath))) {
            alphabetCount = in.nextInt();
            statesCount = in.nextInt();
            startState = in.nextInt();

            states = new ArrayList<>();
            for(int i = 0; i < statesCount; i++) {
                states.add(new State());
            }

            int finalStatesCount = in.nextInt();
            while(finalStatesCount > 0) {
                states.get(in.nextInt()).isFinal = true;
                finalStatesCount--;
            }

            while(in.hasNext()) {
                states.get(in.nextInt()).AddTransition(in.nextInt(), in.nextInt());
            }
        } catch (Exception e) {
            System.out.println("Can`t read file");
            System.exit(0);
        }
    }
    public boolean IsContained(String w) {

        return true;
    }
}
