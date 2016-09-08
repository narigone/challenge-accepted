package br.com.ideiainteligencia.challengeAccepted.outputWriters
import java.io.FileWriter

import br.com.ideiainteligencia.challengeAccepted.formatters.RecordJsonFormatter
import br.com.ideiainteligencia.challengeAccepted.models.Record

/**
  * Output writer that receives one or more records and saves it to a JSON format file
  */
object JsonOutputWriter extends OutputWriterTrait {
  var isFirstRecord = true
  var destinationFile = null : String
  var fileWriter = null : FileWriter

  override def addRecord(record: Record): Unit = {
    this.synchronized{
      val json = RecordJsonFormatter.getJsonFromRecord(record)

      if(this.isFirstRecord){
        addHeaderToFile()
        this.fileWriter.write(json)
        this.isFirstRecord = false
      } else {
        this.fileWriter.write(",")
        this.fileWriter.write(json)
      }
    }
  }

  def addHeaderToFile() = {
    this.fileWriter.write("[")
  }
  override def endOutput(): Unit = {
    this.synchronized{

      this.fileWriter.write("]")
      this.fileWriter.close()
    }
  }

  override def setDestinationFile(destinationFile: String): Unit = {
    this.destinationFile = destinationFile
    this.fileWriter = new FileWriter(this.destinationFile, false)
  }
}
