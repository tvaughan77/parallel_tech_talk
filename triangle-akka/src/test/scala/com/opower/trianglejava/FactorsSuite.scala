package com.opower.trianglejava

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class FactorsSuite extends FunSuite {

  test("The factors of 1 are [1]") {
    assert(List(1) == Factors.factor(1))
  }
  
  
  test("The factors of 2 are [1, 2]") {
    println("the factors of 2 are = " + Factors.factor(2))
    assert(List(1, 2) == Factors.factor(2))
  }
  
  test("The factors of 3 are [1, 3]") {
    println("the factors of 3 are = " + Factors.factor(3))
    assert(List(1, 3) == Factors.factor(3))
  }
  
  test("The factors of 4 are [1, 2, 4]") {
    println("the factors of 4 are = " + Factors.factor(4))
    assert(List(1, 2, 4) == Factors.factor(4))
  }
  
  test("The factors of 5 are [1, 5]") {
    println("the factors of 5 are = " + Factors.factor(5))
    assert(List(1, 5) == Factors.factor(5))
  }
  
  test("The factors of 6 are [1, 2, 3, 6]") {
    println("the factors of 3 are = " + Factors.factor(6))
    assert(List(1, 2, 3, 6) == Factors.factor(6))
  }
}
