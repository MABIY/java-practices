package enums;

/**
 * @author lh
 */
public interface Competitor<T extends Competitor<T>> {
    OutCome compete(T competitor);
}
