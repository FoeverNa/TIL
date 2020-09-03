package second;

public interface Playable<T> {
    boolean play(T move, Player player);
}
