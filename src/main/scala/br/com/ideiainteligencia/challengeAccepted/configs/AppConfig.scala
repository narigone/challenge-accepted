package br.com.ideiainteligencia.challengeAccepted.configs

import java.text.SimpleDateFormat
import java.util.Locale

import scala.xml.XML

/**
  * Singleton for storing configuration parameters coming from config.xml file
  */
object AppConfig {
  var configFile = "config.xml"

  val xml = XML.loadFile(configFile)

  var inputFile = (xml \\ "options" \\ "inputFile").text
  var outputFile = (xml \\ "options" \\ "outputFile").text
  val dateMask = (xml \\ "options" \\ "dateFormat").text
  val filter = (xml \\ "options" \\ "filter").text
  val runInSingleThreadMode = (xml \\ "options" \\ "singleThread").text.toBoolean

  var dateFormat = new SimpleDateFormat(dateMask, Locale.US)
  var monthFormat = new SimpleDateFormat("mm", Locale.US)
}
