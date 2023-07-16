package r.ian
package types

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import Solution._

class SolutionTest extends AnyFlatSpec {

  it should("build vects") in {

    assert(toList(StringVect("MyNameIsOlegAndThisIsMyCourseOnStepik")) == List('M', 'y', 'N', 'a', 'm', 'e', 'I', 's', 'O', 'l', 'e', 'g', 'A', 'n', 'd', 'T', 'h', 'i', 's', 'I', 's', 'M', 'y', 'C', 'o', 'u', 'r', 's', 'e', 'O', 'n', 'S', 't', 'e', 'p', 'i', 'k'))
    assert(toList(StringVect("MyNameIsOlegAndThisIsMyCourseOnStepik").set(0, 'P')) == List('P', 'y', 'N', 'a', 'm', 'e', 'I', 's', 'O', 'l', 'e', 'g', 'A', 'n', 'd', 'T', 'h', 'i', 's', 'I', 's', 'M', 'y', 'C', 'o', 'u', 'r', 's', 'e', 'O', 'n', 'S', 't', 'e', 'p', 'i', 'k'))
    assert(StringVect("MyNameIsOlegAndThisIsMyCourseOnStepik").get(15) == 'T')


    assert(toList(BoolVect8(4)) == List(false, false, true, false, false, false, false, false))
    assert(toList(BoolVect8(60).set(7, true)) == List(false, false, true, true, true, true, false, true))
    assert(toList(BoolVect8(4).set(3, true)) == List(false, false, true, true, false, false, false, false))
    assert(toList(BoolVect8(4).set(8, true)) == List(false, false, true, false, false, false, false, false))
    assert(toList(BoolVect8(4).set(9999, true)) == List(false, false, true, false, false, false, false, false))
    assert(toList(BoolVect8(4).set(-1, true)) == List(false, false, true, false, false, false, false, false))
    assert(!BoolVect8(4).get(0))
    assert(!BoolVect8(4).get(1))
    assert(BoolVect8(4).get(2))

    assert(toList(BoolVect8(3)) == List(true, true, false, false, false, false, false, false))
    assert(BoolVect8(3).get(0))
    assert(BoolVect8(3).get(1))
    assert(!BoolVect8(3).get(2))
    assert(!BoolVect8(3).get(3))
    assert(!BoolVect8(3).get(6))

    assert(toList(BoolVect8(1)) == List(true, false, false, false, false, false, false, false))

    assert(toList(BoolVect8(0)) == List(false, false, false, false, false, false, false, false))

    assert(toList(BoolVect8(-1)) == List(true, true, true, true, true, true, true, true))
    assert(toList(BoolVect8(-1).set(0, false)) == List(false, true, true, true, true, true, true, true))
    assert(BoolVect8(-1).get(1))

    assert(toList(BoolVect8(-2)) == List(false, true, true, true, true, true, true, true))

    assert(toList(BoolVect64(3L)) == List(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false))

    assert(toList(BoolVect64(4L)) == List(false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false))
    assert(toList(BoolVect64(4L).set(3, true)) == List(false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false))
    assert(toList(BoolVect64(4).set(64, true)) == List(false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false))
    assert(toList(BoolVect64(4).set(9999, true)) == List(false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false))
    assert(toList(BoolVect64(4).set(-1, true)) == List(false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false))
  }


}
