package week01;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author Purush Swaminathan
 */
public class HelperFunctions {

  public static void main(String[] args) {
    // Borrowed with thanks from http://stackoverflow.com/a/22953285
    BiFunction<BiFunction, Integer, Integer> helper =
        (f, x) -> (x == 0) ? 1 : x * (Integer) f.apply(f, x - 1);
    Function<Integer, Integer> factorial = x -> helper.apply(helper, x);
    System.out.println(factorial.apply(5));
  }
}