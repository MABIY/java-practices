package patterns.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author lh
 */
// The common strategy base type:
class FindMinima{
    Function<List<Double>,List<Double>> algorithm;
}
// the various strategies:
class LeastSquares extends FindMinima{
    public LeastSquares() {
        // line is a sequence of points (Dummy data):
        algorithm = (line)-> Arrays.asList(1.1,2.2);
    }
}

class Perturbation extends FindMinima{
    public Perturbation() {
        algorithm = (line) -> Arrays.asList(3.3,4.4);
    }
}

class Bisection extends FindMinima {
    public Bisection() {
        algorithm = (line) -> Arrays.asList(5.5,6.6);
    }
}

// The "Context" controls the strategy:
class MinimaSolver {
    private FindMinima strategy;

    public MinimaSolver(FindMinima strategy) {
        this.strategy = strategy;
    }

    List<Double> minimal(List<Double> line) {
        return strategy.algorithm.apply(line);
    }

    void changeAlgorithm(FindMinima newAlgorithm) {
        strategy = newAlgorithm;
    }
}
public class StrategyPattern {
    public static void main(String[] args) {
        MinimaSolver solver = new MinimaSolver(new LeastSquares());
        List<Double> line = Arrays.asList(1.0,2.0,1.0,2.0,-1.0,3.0,4.0,5.0,4.0);
        System.out.println(solver.minimal(line));
        solver.changeAlgorithm(new Bisection());
        System.out.println(solver.minimal(line));
    }
}
