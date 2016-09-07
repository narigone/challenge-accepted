package br.com.ideiainteligencia.challengeAccepted.processors

import br.com.ideiainteligencia.challengeAccepted.factories.RecordFactory
import br.com.ideiainteligencia.challengeAccepted.filters.FilterTrait
import br.com.ideiainteligencia.challengeAccepted.models.Record

object LineProcessor {

  def processLine(line: String, filter: FilterTrait): Record = {
    val record = RecordFactory.getRecordFromLine(line)
    if (record == null) {
      return null
    }

    if (filter.isValid(record)) {
      return record
    }

    return null
  }

}
