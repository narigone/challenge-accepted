package br.com.ideiainteligencia.challengeAccepted.filters

import br.com.ideiainteligencia.challengeAccepted.models.Record

trait FilterTrait {
  def isValid(x: Record): Boolean
}

