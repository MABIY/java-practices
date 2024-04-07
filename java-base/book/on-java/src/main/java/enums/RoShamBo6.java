package enums;

/**
 * @author lh
 * Enums using "tables" instead of multiple dispatch
 */
enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER,SCISSORS,ROCK;
    private static OutCome[][] table = {
            {OutCome.DRAW,OutCome.LOSE,OutCome.WIN}, // PAPER
            {OutCome.WIN,OutCome.DRAW,OutCome.LOSE}, // SCISSORS
            {OutCome.LOSE,OutCome.WIN,OutCome.DRAW}, // ROCK
    };


    @Override
    public OutCome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class,20);
    }
}
