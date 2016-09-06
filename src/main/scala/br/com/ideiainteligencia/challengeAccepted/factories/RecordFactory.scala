package br.com.ideiainteligencia.challengeAccepted.factories

import java.util.Calendar

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.models.Record
import com.typesafe.scalalogging._

object RecordFactory extends LazyLogging{

  def getRecordFromLine(fileLine: String): Record = {
    val tokens = fileLine.split(",")

    if (tokens.length == 4) {
      val name = tokens(0)
      val email = tokens(1)
      val gender = tokens(2)

      val dateAsString = tokens(3)
      val birthday = Calendar.getInstance()
      birthday.setTime(AppConfig.dateFormat.parse(dateAsString))

      new Record(name, email, gender, birthday)
    } else {
      logger.error( "Record \"" + fileLine + "\" is incomplete and will be ignored" )
      null
    }
  }
}

