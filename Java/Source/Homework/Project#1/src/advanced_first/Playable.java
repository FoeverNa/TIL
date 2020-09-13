package advanced_first;

public interface Playable<T> {
    boolean play(T move, Player player);
}
