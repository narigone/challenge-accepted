package br.com.ideiainteligencia.challengeAccepted.factories

import br.com.ideiainteligencia.challengeAccepted.configs.AppConfig
import br.com.ideiainteligencia.challengeAccepted.filters.{BornOnFirstSemesterFilter, FemaleFilter, FilterTrait, MaleFilter}

object FilterFactory {
  def getFilterFromConfig(): FilterTrait ={
    if(AppConfig.filter == "MaleFilter"){
      return MaleFilter
    } else if( AppConfig.filter == "FemaleFilter" ){
      return FemaleFilter
    } else {
      return BornOnFirstSemesterFilter
    }
  }
}
