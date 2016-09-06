package br.com.ideiainteligencia.challengeAccepted.configs

import java.text.SimpleDateFormat
import java.util.Locale

import scala.xml.XML

object AppConfig {
  var configFile = "config.xml"

  val xml = XML.loadFile(configFile)

  var inputFile = (xml \\ "files" \\ "inputFile").text
  var outputFile = (xml \\ "files" \\ "outputFile").text
  val dateMask = (xml \\ "files" \\ "dateFormat").text
  val filter = (xml \\ "files" \\ "filter").text

  var dateFormat = new SimpleDateFormat(dateMask, Locale.US)
  var monthFormat = new SimpleDateFormat("mm", Locale.US)
}

