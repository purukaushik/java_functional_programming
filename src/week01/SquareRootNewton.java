package week01;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author Purush Swaminathan
 */
public class SquareRootNewton {

  static Double abs(Double x) {
    return x > 0 ? x : -x;
  }

  static Boolean isGoodEnough(Double guess, Double x) {
    return abs(guess * guess - x) < 0.001;
  }

  static Double improve(Double guess, Double x) {
    return (guess + x / guess) / 2;
  }

  static Double sqrtIter(Double guess, Double x) {
    if (isGoodEnough(guess, x)) {
      return guess;
    } else {
      return sqrtIter(improve(guess, x), x);
    }
  }

  static Double sqrt(Double x) {
    return sqrtIter(1.0, x);
  }

}
