package enums;

/**
 * @author lh
 */
enum Signal { GREEN, YELLOW,RED,}
public class TrafficLight {
    Signal color = Signal.RED;
    public void change() {
        switch (color) {
            // Note you don't have to say Signal.RED
            case RED: color = Signal.GREEN;
            break;
            case GREEN: color = Signal.YELLOW;
                break;
            case YELLOW: color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "color=" + color +
                '}';
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i <7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}

