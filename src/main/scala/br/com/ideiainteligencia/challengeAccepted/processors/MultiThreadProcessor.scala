package br.com.ideiainteligencia.challengeAccepted.processors

import java.io.PrintWriter

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.factories.FilterFactory
import br.com.ideiainteligencia.challengeAccepted.filters.FilterTrait
import br.com.ideiainteligencia.challengeAccepted.formatters.RecordJsonFormatter
import br.com.ideiainteligencia.challengeAccepted.models.Record
import com.typesafe.scalalogging._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

import scala.io.Source

import scala.language.postfixOps

object MultiThreadProcessor extends LazyLogging {
  def processFile() = {
    val filter = FilterFactory.getFilterFromConfig(AppConfig.filter)

    logger.info( "Opening CSV file " + AppConfig.inputFile + " in multi-threaded processing mode" )

    val futures = Source.fromFile(AppConfig.inputFile).getLines.drop(1).map{ s => Future{ LineProcessor.processLine(s, filter) } }.toIndexedSeq

    val results = Await.result(Future.sequence(futures), 100 seconds)

    val recordList = results.toList

    val jsonAsString = RecordJsonFormatter.getJsonFromList(recordList.filter(null !=))

    saveResult(jsonAsString)
  }

  def saveResult(jsonAsString: String) = {
    new PrintWriter(AppConfig.outputFile) { write(jsonAsString); close }
  }
}
