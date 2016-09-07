package br.com.ideiainteligencia.challengeAccepted.factories

import br.com.ideiainteligencia.challengeAccepted.filters.{BornOnFirstSemesterFilter, BornOnSecondSemesterFilter, FemaleFilter, FilterTrait, MaleFilter}

object FilterFactory {
  def getFilterFromConfig(filterName : String): FilterTrait ={
    if( filterName == "MaleFilter"){
      return MaleFilter
    } else if( filterName == "FemaleFilter" ){
      return FemaleFilter
    } else if( filterName == "BornOnSecondSemesterFilter" ){
      return BornOnSecondSemesterFilter
    } else {
      return BornOnFirstSemesterFilter
    }
  }
}
