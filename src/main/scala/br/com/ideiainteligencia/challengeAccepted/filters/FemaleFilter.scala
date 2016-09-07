package br.com.ideiainteligencia.challengeAccepted.filters

import br.com.ideiainteligencia.challengeAccepted.models.Record

import com.typesafe.scalalogging._

object FemaleFilter extends FilterTrait with LazyLogging {

  /**
    * Validates if person is female
    *
    * @param record Record to be validated
    * @return Boolean
    */
  override def isValid(record: Record): Boolean = {
    this.synchronized {
      if (record.gender == null) {
        logger.warn("Record \"" + record + "\" doesn't have a defined gender and will be ignored")
        return false
      }

      if (record.gender != "Female") {
        logger.info("Record \"" + record + "\" doesn't match filter criteria (Female) and will be ignored")
        return false
      }

      true
    }
  }
}

