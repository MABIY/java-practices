package enums;

import static enums.OutCome.*;

/**
 * @author lh
 */
public enum RoShamBo2 implements Competitor<RoShamBo2>{
    PAPER(DRAW,LOSE,WIN),
    SCISSORS(WIN,DRAW,LOSE),
    ROCK(LOSE,WIN,DRAW);
    private OutCome vPAPER,vSCISSORS,vROCk;

    RoShamBo2(OutCome vPAPER, OutCome vSCISSORS, OutCome vROCk) {
        this.vPAPER = vPAPER;
        this.vSCISSORS = vSCISSORS;
        this.vROCk = vROCk;
    }

    @Override
    public OutCome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER: return PAPER.vPAPER;
            case SCISSORS: return vSCISSORS;
            case ROCK: return ROCK.vROCk;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class,20);
    }
}
