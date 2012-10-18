package com.opower.trianglejava

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class TriangleNumberSuite extends FunSuite {
  
  val triangle = new TriangleNumber()

  test("The 1st triangle number is 1") {
    assert(1 == triangle(1))
  }
  
  test("The 2nd triangle number is 3") {
    assert(3 == triangle(2))
  }
  
  test("The 3rd triangle number is 6") {
    assert(6 == triangle(3))
  }
  
  // Skip asking for 4 to make sure the "walk backwards" functionality works
  test("The 5th triangle number is 15") {
    assert(15 == triangle(5))
  }
}
