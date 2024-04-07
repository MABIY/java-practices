package enums;

/**
 * @author lh
 */
public enum RoShamBo3 implements Competitor<RoShamBo3>{
   PAPER {
       @Override
       public OutCome compete(RoShamBo3 it) {
           switch (it) {
               default:
               case PAPER: return OutCome.DRAW;
               case SCISSORS: return OutCome.LOSE;
               case ROCK: return OutCome.WIN;
           }
       }
   },
    SCISSORS{
        @Override
        public OutCome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return OutCome.WIN;
                case SCISSORS: return OutCome.DRAW;
                case ROCK: return OutCome.LOSE;
            }
        }
    },
    ROCK {
        @Override
        public OutCome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return OutCome.LOSE;
                case SCISSORS: return OutCome.WIN;
                case ROCK: return OutCome.DRAW;
            }
        }
    }
    ;
    @Override
    public abstract OutCome compete(RoShamBo3 competitor);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class,20);
    }
}
