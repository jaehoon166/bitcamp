package control;

public interface Controller {
    /* public abstract */ void execute();

    default void init() {
    }

    default void destroy() {
    }
}
