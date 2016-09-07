package br.com.ideiainteligencia.challengeAccepted.factories


import br.com.ideiainteligencia.challengeAccepted.models.Record
import com.typesafe.scalalogging._

/**
  * Using Factory pattern for Records. Removes the responsibility from Record class to
  * know what kind of input method will be used
  */
object RecordFactory extends LazyLogging {

  /**
    * Factory method for Record objects.
    *
    * @param fileLine CSV file line containing record's data
    * @return Record
    */
  def getRecordFromLine(fileLine: String): Record = {
    this.synchronized {
      try {
        val tokens = fileLine.split(",")

        if (tokens.length == 4) {
          val name = tokens(0)
          val email = tokens(1)
          val gender = tokens(2)
          val birthday = tokens(3)

          new Record(name, email, gender, birthday)
        } else {
          logger.warn("Record \"(" + fileLine + ")\" is incomplete and will be ignored")
          null
        }
      } catch {
        case e: Exception => {
          println("Record \"(" + fileLine + ")\" cause error: " + e.getMessage())
          return null
        }
      }
    }
  }
}
