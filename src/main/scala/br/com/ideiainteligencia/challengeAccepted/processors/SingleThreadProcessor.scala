package br.com.ideiainteligencia.challengeAccepted.processors

import java.io.PrintWriter

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.factories.FilterFactory
import br.com.ideiainteligencia.challengeAccepted.filters.FilterTrait
import br.com.ideiainteligencia.challengeAccepted.formatters.RecordJsonFormatter
import br.com.ideiainteligencia.challengeAccepted.models.Record

import com.typesafe.scalalogging._

import scala.io.Source

/**
  * File processor that filters records sequentially and afterwards saves it in json format
  */
object SingleThreadProcessor extends LazyLogging {
  def processFile() = {
    val filter = FilterFactory.buildFilter(AppConfig.filter)

    var recordList: Array[Record] = Array()

    logger.info("Opening CSV file " + AppConfig.inputFile + " in single-thread processing mode")

    for (line <- Source.fromFile(AppConfig.inputFile).getLines().drop(1)) {
      val record = LineProcessor.processLine(line, filter)
      if (record != null) {
        recordList = recordList :+ record
      }
    }

    val jsonAsString = RecordJsonFormatter.getJsonFromList(recordList.toList)
    saveResult(jsonAsString)
  }

  def saveResult(jsonAsString: String) = {
    new PrintWriter(AppConfig.outputFile) {
      write(jsonAsString); close
    }
  }
}
