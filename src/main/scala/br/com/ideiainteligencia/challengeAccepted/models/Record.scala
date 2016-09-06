package br.com.ideiainteligencia.challengeAccepted.models

import java.util.Calendar

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig

case class Record(var name: String, var email: String, var gender: String, var birthday: Calendar) {

  def this(name: String, email: String, gender: String) = this(name, email, gender, null)
  def this(name: String, email: String) = this(name, email, null, null)
  def this(name: String) = this(name, null, null, null)

  override def toString: String = {
    if( birthday != null ) {
      "(" + name + ", " + email + ", " + gender + ", "  + AppConfig.dateFormat.format(birthday.getTime()) + ")"
    } else {
      "(" + name + ", " + email + ", " + gender + ", null )"
    }
  }
}

