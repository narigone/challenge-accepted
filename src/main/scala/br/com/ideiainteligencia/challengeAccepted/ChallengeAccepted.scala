package br.com.ideiainteligencia.challengeAccepted

import java.io.PrintWriter

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.factories.RecordFactory
import br.com.ideiainteligencia.challengeAccepted.filters.{BornOnFirstSemesterFilter, FemaleFilter, FilterTrait, MaleFilter}
import br.com.ideiainteligencia.challengeAccepted.formatters.RecordJsonFormatter
import br.com.ideiainteligencia.challengeAccepted.models.Record
import com.typesafe.scalalogging._

import scala.io.Source

object ChallengeAccepted extends LazyLogging {
  def main(args: Array[String]): Unit = {
    val filter = getFilterFromConfig()

    print( filter );
    var recordList: Array[Record] = Array()

    logger.info( "Opening CSV file " + AppConfig.inputFile )
    for (line <- Source.fromFile(AppConfig.inputFile).getLines().drop(1)) {
      val record = processLine(line, filter)
      if (record != null) {
        recordList = recordList :+ record
      }
    }

    val jsonAsString = RecordJsonFormatter.getJsonFromList(recordList.toList)
    saveResult(jsonAsString)
  }

  def getFilterFromConfig(): FilterTrait ={
    if(AppConfig.filter == "MaleFilter"){
      return MaleFilter
    } else if( AppConfig.filter == "FemaleFilter" ){
      return FemaleFilter
    } else {
      return BornOnFirstSemesterFilter
    }
  }

  def processLine(line: String, filter: FilterTrait): Record = {
    val record = RecordFactory.getRecordFromLine(line)
    if (record == null) {
      return null
    }

    if (filter.isValid(record)) {
      return record
    }

    return null
  }

  def saveResult(jsonAsString: String) = {
    new PrintWriter(AppConfig.outputFile) { write(jsonAsString); close }
  }
}

