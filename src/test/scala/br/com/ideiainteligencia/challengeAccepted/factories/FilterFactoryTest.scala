package br.com.ideiainteligencia.challengeAccepted.factories

import br.com.ideiainteligencia.challengeAccepted.filters.{BornOnFirstSemesterFilter, BornOnSecondSemesterFilter, FemaleFilter, FilterTrait, MaleFilter}

import org.scalatest._
import Matchers._

class FilterFactoryTest extends FunSuite {
  test("FilterFactory should return MaleFilter when string MaleFilter is passed as parameter") {
    val filter = FilterFactory.getFilterFromConfig( "MaleFilter" );
    filter shouldBe MaleFilter
  }

  test("FilterFactory should return FemaleFilter when string FemaleFilter is passed as parameter") {
    val filter = FilterFactory.getFilterFromConfig( "FemaleFilter" );
    filter shouldBe FemaleFilter
  }

  test("FilterFactory should return BornOnSecondSemesterFilter when string BornOnSecondSemesterFilter is passed as parameter") {
    val filter = FilterFactory.getFilterFromConfig( "BornOnSecondSemesterFilter" );
    filter shouldBe BornOnSecondSemesterFilter
  }

  test("FilterFactory should return BornOnFirstSemesterFilter when string BornOnFirstSemesterFilter is passed as parameter") {
    val filter = FilterFactory.getFilterFromConfig( "BornOnFirstSemesterFilter" );
    filter shouldBe BornOnFirstSemesterFilter
  }

  test("FilterFactory should return BornOnFirstSemesterFilter when any other string is passed as parameter") {
    val filter = FilterFactory.getFilterFromConfig( "InvalidFilter" );
    filter shouldBe BornOnFirstSemesterFilter
  }
}
