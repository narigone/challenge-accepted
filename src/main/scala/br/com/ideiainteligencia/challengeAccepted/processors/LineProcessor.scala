package br.com.ideiainteligencia.challengeAccepted.processors

import br.com.ideiainteligencia.challengeAccepted.factories.RecordFactory
import br.com.ideiainteligencia.challengeAccepted.filters.FilterTrait
import br.com.ideiainteligencia.challengeAccepted.models.Record
import br.com.ideiainteligencia.challengeAccepted.outputWriters.OutputWriterTrait

/**
  * Object responsible for receiving a line from CSV file, building
  * a record from it and checking if it matches the selected filter
  */
object LineProcessor {

  /**
    * This method tries to build a record from CSV file line and then
    * applies the selected filter on it. Returns resulting Record if
    * it survives the process. Muahahahaha
    *
    * @param line CSV line with record's data
    * @param filter filter to be applied to record
    * @param outputWriterTrait outputWriter responsible for saving file
    * @return Record
    */
  def processLine(line: String, filter: FilterTrait, outputWriterTrait: OutputWriterTrait) {
    val record = RecordFactory.getRecordFromLine(line)
    if (record == null) {
      return
    }

    if (!filter.isValid(record)) {
      return
    }

    outputWriterTrait.addRecord(record)
  }

}
