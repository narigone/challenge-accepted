package br.com.ideiainteligencia.challengeAccepted.models

/**
  * Model for representing each individual record that is input into the program
  *
  * @param name
  * @param email
  * @param gender
  * @param birthday
  */
case class Record(var name: String, var email: String, var gender: String, var birthday: String) {
  var month = 0
  var day = 0
  var year = 0

  if(birthday != null ) {
    val tokens = birthday.split("-")
    year = tokens(0).toInt
    month = tokens(1).toInt
    day = tokens(2).toInt
  }

  def this(name: String, email: String, gender: String) = this(name, email, gender, null)

  def this(name: String, email: String) = this(name, email, null, null)

  def this(name: String) = this(name, null, null, null)
}

