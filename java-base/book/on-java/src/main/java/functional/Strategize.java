package functional;

/**
 * @author lh
 */
interface Stratety {
    String approach(String msg);
}

class Soft implements Stratety {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {
    Stratety stratety;
    String msg;

    public Strategize(String msg) {
        stratety = new Soft();
        this.msg = msg;
    }

    public static void main(String[] args) {
        Stratety[] strateties = {
            new Stratety() {
                @Override
                public String approach(String msg) {
                    return msg.toUpperCase() + "!";
                }
            },
            msg -> msg.substring(0, 5),
            Unrelated::twice
        };

        Strategize s = new Strategize("Hello there");
        s.communicate();
        for (Stratety newStrategy : strateties) {
            s.changeStrategy(newStrategy);
            s.communicate();
        }
    }

    void communicate() {
        System.out.println(stratety.approach(msg));
    }

    void changeStrategy(Stratety stratety) {
        this.stratety = stratety;
    }
}
