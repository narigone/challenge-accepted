package br.com.ideiainteligencia.challengeAccepted.filters

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.models.Record

import com.typesafe.scalalogging._


object BornOnFirstSemesterFilter extends FilterTrait with LazyLogging {

  /**
    * Validates if person was born on first semester
    *
    * @param record Record to be validated
    * @return Boolean
    */
  override def isValid(record: Record): Boolean = {
    this.synchronized {
      if (record.birthday == null) {
        logger.warn("Record \"" + record + "\" doesn't have a date and will be ignored")
        return false
      }

      if (record.month > 6) {
        logger.info("Record \"" + record + "\" doesn't match filter criteria (Born on first semester) and will be ignored")
        return false
      }

      true
    }
  }
}

