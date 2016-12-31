package week02;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author Purush Swaminathan
 */
public class Currying {

  @FunctionalInterface
  interface RecursiveBiFunction<F, A, B, R> {

    public R apply(F f, A a, B b);
  }

  static BiFunction<Integer, Integer, Integer> sum(
      Function<Integer, Integer> mapper) {
    RecursiveBiFunction<RecursiveBiFunction, Integer, Integer, Integer> summer = (f, a, b) -> {
      if (a > b) {
        return 0;
      } else {
        return (Integer) mapper.apply(a)
            + (Integer) f.apply(f, a + 1, b);
      }
    };
    BiFunction<Integer, Integer, Integer> sum = (a, b) -> summer.apply(summer, a, b);
    return sum;
  }

  public static void main(String[] args) {
    int x = sum(y -> y).apply(1, 5);
    System.out.println(x);
  }

}
