package br.com.ideiainteligencia.challengeAccepted.filters


import br.com.ideiainteligencia.challengeAccepted.factories.RecordFactory
import br.com.ideiainteligencia.challengeAccepted.models.Record

import org.scalatest._
import Matchers._

class BornOnSecondSemesterFilterTest extends FunSuite {
  test("BornOnSecondSemesterFilter should return TRUE when record birthday is after/equal July") {
    val record = RecordFactory.getRecordFromLine( "Timothy Pierce,tpierce1@ovh.net,Male,1982-07-01" );
    val isValid = BornOnSecondSemesterFilter.isValid(record)
    isValid shouldBe true
  }

  test("BornOnSecondSemesterFilter should return FALSE when record birthday is before July") {
    val record = RecordFactory.getRecordFromLine( "Timothy Pierce,tpierce1@ovh.net,Male,1982-01-01" );
    val isValid = BornOnSecondSemesterFilter.isValid(record)
    isValid shouldBe false
  }
}
