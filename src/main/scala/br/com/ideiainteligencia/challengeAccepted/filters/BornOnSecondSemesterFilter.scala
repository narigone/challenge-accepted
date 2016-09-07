package br.com.ideiainteligencia.challengeAccepted.filters

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.models.Record

import com.typesafe.scalalogging._

object BornOnSecondSemesterFilter extends FilterTrait with LazyLogging {
  override def isValid(record: Record): Boolean = {
    if (record.birthday == null) {
      logger.warn( "Record \"" + record + "\" doesn't have a date and will be ignored" )
      return false
    }

    val birthMonthAsString = AppConfig.monthFormat.format(record.birthday.getTime())
    val birthMonth = birthMonthAsString.toInt
    if ( birthMonth <= 6) {
      logger.info( "Record \"" + record + "\" doesn't match filter criteria (Born on second semester) and will be ignored" )
      return false
    }

    true
  }
}

