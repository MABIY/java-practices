package mucis;

/**
 * @author lh
 */
public class Wind extends Instrument{
    public Wind() {
    }

    @Override
    public void play(Note n) {
        System.out.println("Wind.play()" + n);
    }
}
