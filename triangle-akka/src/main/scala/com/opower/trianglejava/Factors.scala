package com.opower.trianglejava

object Factors {

  def factor(number: Long): List[Int] = {

    val limit = Math.sqrt(number).toInt + 1
    
    def innerFactor(number: Long, i: Integer): Set[Int] = {
      if (number == 1) 
        Set(1)
      else if (i >= limit) 
        Set()
      else if (number % i == 0) 
        innerFactor(number / i, i + 1) + i + (number / i).toInt
      else
        innerFactor(number, i + 1)
    }
    
    innerFactor(number, 1).toList.sorted
  }
}
