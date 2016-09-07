package br.com.ideiainteligencia.challengeAccepted.formatters

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.models.Record

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.native.JsonMethods._

object RecordJsonFormatter {
  def getJsonFromList(recordList: List[Record]) : String = {
    val json = recordList.map { record =>
      (
        ("name" -> record.name) ~
        ("email" -> record.email) ~
        ("gender" -> record.gender) ~
        ("birthday" -> AppConfig.dateFormat.format(record.birthday.getTime))
      )
    }
    return pretty(render(json))
  }
}
