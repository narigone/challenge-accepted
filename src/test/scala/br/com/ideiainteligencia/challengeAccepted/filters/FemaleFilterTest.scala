package br.com.ideiainteligencia.challengeAccepted.filters

import br.com.ideiainteligencia.challengeAccepted.factories.RecordFactory
import br.com.ideiainteligencia.challengeAccepted.models.Record

import org.scalatest._
import Matchers._

class FemaleFilterTest extends FunSuite {
  test("FemaleFilter should return TRUE when gender is FEMALE") {
    val record = RecordFactory.getRecordFromLine( "Timothy Pierce,tpierce1@ovh.net,Female,1982-01-09" );
    val isValid = FemaleFilter.isValid(record)
    isValid shouldBe true
  }

  test("FemaleFilter should return FALSE when gender is not FEMALE") {
    val record = RecordFactory.getRecordFromLine( "Timothy Pierce,tpierce1@ovh.net,Male,1982-07-01" );
    val isValid = FemaleFilter.isValid(record)
    isValid shouldBe false
  }
}
