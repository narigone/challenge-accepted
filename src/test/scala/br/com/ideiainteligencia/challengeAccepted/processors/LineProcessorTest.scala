package br.com.ideiainteligencia.challengeAccepted.processors

import br.com.ideiainteligencia.challengeAccepted.filters.{BornOnFirstSemesterFilter, BornOnSecondSemesterFilter, FemaleFilter, FilterTrait, MaleFilter}
import br.com.ideiainteligencia.challengeAccepted.models.Record

import org.scalatest._
import Matchers._

class LineProcessorTest extends FunSuite {
  test("LineProcessor should return Record when valid record is passed as parameter and record matches filter") {
    val filter = BornOnFirstSemesterFilter;
    val record = LineProcessor.processLine( "Timothy Pierce,tpierce1@ovh.net,Male,1982-01-09", filter );
    record shouldBe a [Record]
  }

  test("LineProcessor should return NULL when valid record is passed as parameter and record doesn't match filter") {
    val filter = BornOnSecondSemesterFilter;
    val record = LineProcessor.processLine( "Susan Crawford,scrawfordz@ebay.co.uk,Female,1982-01-09", filter );
    record shouldBe null
  }
}
