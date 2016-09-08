package br.com.ideiainteligencia.challengeAccepted.processors

import java.util.concurrent.Executors

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.factories.{FilterFactory, OutputWriterFactory}
import com.typesafe.scalalogging._

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.io.Source
import scala.language.postfixOps

/**
  * File processor that filters records concurrently and afterwards saves it in json format
  */
object MultiThreadProcessor extends LazyLogging {
  def processFile() = {
    val filter = FilterFactory.buildFilter(AppConfig.filter)
    val outputWriter = OutputWriterFactory.buildOutputWriter(AppConfig.outputWriter)

    implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(10))

    logger.info("Opening CSV file " + AppConfig.inputFile + " in multi-threaded processing mode")

    /* For each line in the file, creates a new Future that will
       process the line and get back with a result */
    val futures = Source.fromFile(AppConfig.inputFile).getLines.drop(1).map { s => Future {
      LineProcessor.processLine(s, filter, outputWriter)
    }
    }

    Await.result(Future.sequence(futures), 100 seconds)
    outputWriter.endOutput()
  }
}
