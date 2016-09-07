package br.com.ideiainteligencia.challengeAccepted.factories

import br.com.ideiainteligencia.challengeAccepted.models.Record

import org.scalatest._
import Matchers._

class RecordFactoryTest extends FunSuite {
  test("RecordFactory should return Record when valid record is passed as parameter") {
    val record = RecordFactory.getRecordFromLine( "Timothy Pierce,tpierce1@ovh.net,Male,1982-01-09" );
    record shouldBe a [Record]
  }

  test("RecordFactory should return NULL when incomplete record is passed as parameter") {
    val record = RecordFactory.getRecordFromLine( "Susan Crawford,scrawfordz@ebay.co.uk,Female," );
    record shouldBe null
  }
}
