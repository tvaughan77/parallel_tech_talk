package com.opower.trianglejava

import scala.collection.mutable.ListBuffer


/**
 * <p>Class that implements a dynamic programming solution to computing triangle numbers.</p>
 * <p>The sequence of triangle numbers is generated by adding the natural numbers.<br/>
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. </p>
 *
 * <p>Usage:
 * <pre>
 * val triangle = new TriangleNumber()
 * val foo = triangle(7)    // foo is 28
 * </pre>
 */
class TriangleNumber {

  private val triangleNumbers = new ListBuffer[Long]
  triangleNumbers.insert(0, 0)

  /**
   * <p>Computing triangle numbers is a perfect dynamic programming problem: computing the Nth triangle
   * number requires the computation of all the 0...(N-1)th numbers.  To do this in Scala without streams, I'm
   * using a ListBuffer where the index of the ListBuffer contains the triangle number associated to that N.</p>
   * <p>This method seeds the 0th element with 0 and then for any other call to {@code triangle(n)} will search
   * backwards until it finds a defined element at some index I.  Once a defined number is found at index I, the
   * algorithm "walks forward" to the requested index N, accumulating and storing the answer in the backing
   * ListBuffer[I], ListBuffer[I+1], etc. until ListBuffer[N] is computed and returned.</p>
   *
   * @param n The nth triangle number you want.
   * @return The nth triangle number.
   */
  def apply(n: Int): Long = {
    require(n >= 0)  // don't allow negative numbers, that doesn't make sense

    if(n > 0) {      // assumes we've seeded our backing ListBuffer with 0
      while(! triangleNumbers.isDefinedAt(n - 1)) {
        apply(n - 1)
      }
      triangleNumbers.insert(n, triangleNumbers(n - 1) + n)
    }

    triangleNumbers(n)
  }
}