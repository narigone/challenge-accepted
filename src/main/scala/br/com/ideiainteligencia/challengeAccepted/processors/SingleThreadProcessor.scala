package br.com.ideiainteligencia.challengeAccepted.processors

import java.io.PrintWriter

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.factories.{FilterFactory, OutputWriterFactory}
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
    val outputWriter = OutputWriterFactory.buildOutputWriter(AppConfig.outputWriter)

    logger.info("Opening CSV file " + AppConfig.inputFile + " in single-thread processing mode")

    for (line <- Source.fromFile(AppConfig.inputFile).getLines().drop(1)) {
      LineProcessor.processLine(line, filter, outputWriter)
    }

    outputWriter.endOutput()
  }
}
