package br.com.ideiainteligencia.challengeAccepted

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.processors.{MultiThreadProcessor, SingleThreadProcessor}

import scala.io.Source

object ChallengeAccepted {
  def main(args: Array[String]) : Unit = {
    if(AppConfig.runInSingleThreadMode){
      SingleThreadProcessor.processFile()
    } else {
      MultiThreadProcessor.processFile()
    }
  }
}
