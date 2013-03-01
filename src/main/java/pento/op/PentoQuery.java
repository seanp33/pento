package pento.op;

/**
 * Defines a query were the query expression is of type T
 */
public interface PentoQuery<T> {

    T getExpression();
}
