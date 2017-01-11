package io.purush.java.functional.week01;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author Purush Swaminathan
 */
public class HelperFunctions {

  static Function<Integer, Integer> factorialFunction() {
    BiFunction<BiFunction, Integer, Integer> helper =
        (f, x) -> (x == 0) ? 1 : x * (Integer) f.apply(f, x - 1);
    Function<Integer, Integer> factorial = x -> helper.apply(helper, x);
    return factorial;
  }


  @FunctionalInterface
  interface RecursiveTriFunction<F, A, B, C, R> {

    public R apply(F f, A a, B b, C c);
  }

  static Function<Integer, Integer> fibanocciFunction() {
    RecursiveTriFunction<RecursiveTriFunction, Integer, Integer, Integer, Integer> helper = (f, a, b, c) -> {
      switch (a) {
        case 0:
          return b != null ? b : 0;
        case 1:
          return c != null ? c : 1;
        default:
          int t = c != null && b != null ? (c + b) : 1;
          return (Integer) f.apply(f, a - 1, c != null ? c : 1, t);
      }
    };
    return (x -> helper.apply(helper, x, null, null));
  }

  public static void main(String[] args) {
    // Borrowed with thanks from http://stackoverflow.com/a/22953285

    //System.out.println(factorialFunction().apply(5));
    System.out.println(fibanocciFunction().apply(9));
  }
}
