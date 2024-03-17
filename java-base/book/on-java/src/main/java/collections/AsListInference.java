package collections;

import javax.swing.*;
import javax.swing.plaf.SliderUI;
import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 */
class Snow{{}}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Stush extends Snow{}
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(),new Stush(),new Powder());
        System.out.println(snow1);
        List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());
        System.out.println(snow2);

        List<Snow> snow4 = Arrays.<Snow>asList(new Light(),new Heavy(),new Stush());
        System.out.println(snow4);
    }
}
