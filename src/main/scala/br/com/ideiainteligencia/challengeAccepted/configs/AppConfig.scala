package br.com.ideiainteligencia.challengeAccepted.configs

import scala.xml.XML

/**
  * Singleton for storing configuration parameters coming from config.xml file
  */
object AppConfig {
  var configFile = "config.xml"

  val xml = XML.loadFile(configFile)

  var inputFile = (xml \\ "options" \\ "inputFile").text
  var outputFile = (xml \\ "options" \\ "outputFile").text
  val filter = (xml \\ "options" \\ "filter").text
  val runInSingleThreadMode = (xml \\ "options" \\ "singleThread").text.toBoolean

  var outputWriter = "JsonOutputWriter"
}
