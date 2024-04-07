package enums;

/**
 * @author lh
 */
public enum RoShamBo4 implements Competitor<RoShamBo4>{

    ROCK {
        @Override
        public OutCome compete(RoShamBo4 opponent) {
            return compete(SCISSORS,opponent);
        }
    },
    SCISSORS{
        @Override
        public OutCome compete(RoShamBo4 opponent) {
            return compete(PAPER,opponent);
        }
    },
    PAPER {
        @Override
        public OutCome compete(RoShamBo4 opponent) {
            return compete(ROCK,opponent);
        }
    }
    ;

    OutCome compete(RoShamBo4 loser,RoShamBo4 opponent ){
        return ((opponent == this) ? OutCome.DRAW : ((opponent == loser) ? OutCome.WIN : OutCome.LOSE));
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class,20);
    }
}
