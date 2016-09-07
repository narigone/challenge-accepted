package br.com.ideiainteligencia.challengeAccepted.filters

import br.com.ideiainteligencia.challengeAccepted.factories.RecordFactory
import br.com.ideiainteligencia.challengeAccepted.models.Record

import org.scalatest._
import Matchers._

class BornOnFirstSemesterFilterTest extends FunSuite {
  test("BornOnFirstSemesterFilter should return TRUE when record birthday is after/equal June") {
    val record = RecordFactory.getRecordFromLine( "Timothy Pierce,tpierce1@ovh.net,Male,1982-01-09" );
    val isValid = BornOnFirstSemesterFilter.isValid(record)
    isValid shouldBe true
  }

  test("BornOnFirstSemesterFilter should return FALSE when record birthday is after June") {
    val record = RecordFactory.getRecordFromLine( "Timothy Pierce,tpierce1@ovh.net,Male,1982-07-01" );
    val isValid = BornOnFirstSemesterFilter.isValid(record)
    isValid shouldBe false
  }
}
