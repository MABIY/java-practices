package interfaces.music4;

import mucis.Note;

/**
 * @author lh
 */
abstract class Instrument{
    private int i;
    public abstract void play(Note n);

    public String what() {
        return "Instrument";
    }
    public abstract void adjust();
}

class Wind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Wind.play()" + n);
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument{
    @Override
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    public String what() {
        return "Percussion";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed extends Instrument {
    @Override
    public String what() {
        return "Stringed";
    }

    @Override
    public void play(Note n) {
        System.out.println("Stringed.play() "+n);
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Brass");
    }
}

class Woodwind extends Wind{
    @Override
    public void play(Note n) {
        super.play(n);
    }

    @Override
    public String what() {
        return super.what();
    }
}

public class Music4 {
}
