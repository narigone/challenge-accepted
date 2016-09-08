package br.com.ideiainteligencia.challengeAccepted.formatters

import br.com.ideiainteligencia.challengeAccepted.models.Record

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.native.JsonMethods._

/**
  * Object responsible for converting a record list to JSON format
  */
object RecordJsonFormatter {

  /**
    * Receives a record list and converts it to json format. Returns resulting string
    *
    * @param recordList Record list to be converted
    * @return String
    */
  def getJsonFromList(recordList: List[Record]): String = {
    val json = recordList.map { record =>
      (
        ("name" -> record.name) ~
          ("email" -> record.email) ~
          ("gender" -> record.gender) ~
          ("birthday" -> record.birthday)
        )
    }
    return pretty(render(json))
  }

  /**
    * Receives a record and converts it to json format. Returns resulting string
    *
    * @param record Record list to be converted
    * @return String
    */
  def getJsonFromRecord(record: Record): String = {
    val json =
      (
        ("name" -> record.name) ~
        ("email" -> record.email) ~
        ("gender" -> record.gender) ~
        ("birthday" -> record.birthday)
      )
    return pretty(render(json))
  }
}
