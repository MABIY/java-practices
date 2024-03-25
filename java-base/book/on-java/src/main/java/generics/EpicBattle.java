package generics;

import java.util.List;

/**
 * @author lh
 *
 */
interface SuperPower {}

interface XRayVision extends SuperPower{
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower{
    void hearSubtleNoise();
}

interface SuperSmell extends SuperPower {
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
    POWER power;

    public SuperHero(POWER power) {
        this.power = power;
    }

    POWER getPower(){
        return power;
    }
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER>{
    public SuperSleuth(POWER power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {
    public CanineHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hearSubtleNoise();
    }

    void smell() {
        power.trackBySmell();
    }
}

class SuperHearSmell implements SuperHearing, SuperSmell {
    @Override
    public void hearSubtleNoise() {

    }

    @Override
    public void trackBySmell() {

    }
}

class DogPerson  extends CanineHero<SuperHearSmell> {
    public DogPerson() {
        super(new SuperHearSmell());
    }
}
public class EpicBattle {
    // Bounds in generic methods:
    static <POWER extends SuperHearing>  void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoise();
    }

    static <POWER extends SuperHearing & SuperSmell > void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoise();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogPerson dogPerson = new DogPerson();
        useSuperHearing(dogPerson);
        superFind(dogPerson);

        // you can do this:
        List<? extends SuperHearing> audioPeople;
        // But you can't do this:
//        List<? extends SuperHearing & SuperSmell> dogPs;
    }
}
