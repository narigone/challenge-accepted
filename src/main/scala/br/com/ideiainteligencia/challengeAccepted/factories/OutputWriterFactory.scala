package br.com.ideiainteligencia.challengeAccepted.factories

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.outputWriters.JsonOutputWriter
import br.com.ideiainteligencia.challengeAccepted.outputWriters.OutputWriterTrait

/**
  * Using Factory pattern for OutputWriters. Removes the responsibility from user of
  * building the filter and makes it easier to be parametrized
  */
object OutputWriterFactory {

  /**
    * Factory method for OutputWriter to be applied on record list
    *
    * @param outputWriterName:String Name of the OutputWriter that muse be built
    * @return FilterTrait
    */
  def buildOutputWriter(outputWriterName: String): OutputWriterTrait = {
    /**
      * @todo add more output writer types
      */
    val outputWriter = JsonOutputWriter
    outputWriter.setDestinationFile(AppConfig.outputFile)
    return outputWriter
  }
}
