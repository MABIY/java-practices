package annotations;

import onjava.ConvertTo;
import onjava.atunit.Test;
import onjava.atunit.TestObjectCreate;
import onjava.atunit.TestProperty;

import java.util.*;

/**
 * @author lh
 */
public class AtUnitExample4 {
    static String theory = "All brontosauruses " +
            "are thin at one end, much MUCH thicker in the " +
            "middle, and then thin again at the far end.";
    private String word;
    private Random rand = new Random(); // Time-based seed

    public AtUnitExample4(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String scrambleWord() {
        List<Character> chars = Arrays.asList(ConvertTo.boxed(word.toCharArray()));
        Collections.shuffle(chars, rand);
        StringBuilder resultBuilder = new StringBuilder();
        for (Character aChar : chars) {
            resultBuilder.append(aChar);
        }
        return resultBuilder.toString();
    }

    @TestProperty
    static List<String> input = Arrays.asList(theory.split(" "));
    @TestProperty
    static Iterator<String> words = input.iterator();

    @TestObjectCreate
    static AtUnitExample4 create() {
        if(words.hasNext()) {
            return new AtUnitExample4(words.next());
        } else {
            return null;
        }
    }

    @Test
    boolean worlds(){
        System.out.println("'" + getWord() +"'");
        return getWord().equals("are");
    }

    @Test
    boolean scramble1() {
        // Use specific seed to get verifiable results:
        rand = new Random(47);
        System.out.println("'" + getWord() +"'");
        String scrambled = scrambleWord();
        System.out.println(scrambled);
        return scrambled.equals("All");
    }
    @Test
    boolean scramble2() {
        rand = new Random(74);
        System.out.println("'" + getWord() +"'");
        String scrambled = scrambleWord();
        System.out.println(scrambled);
        return scrambled.equals("tsaeborornussu");
    }

    
}

