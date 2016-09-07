package br.com.ideiainteligencia.challengeAccepted.factories

import br.com.ideiainteligencia.challengeAccepted.filters.{BornOnFirstSemesterFilter, BornOnSecondSemesterFilter, FemaleFilter, FilterTrait, MaleFilter}

/**
  * Using Factory pattern for Filters. Removes the responsibility from user of
  * building the filter and makes it easier to be parametrized
  */
object FilterFactory {

  /**
    * Factory method for filter to be applied on record list
    *
    * @param filterName:String Name of the filter that muse be built
    * @return FilterTrait
    */
  def buildFilter(filterName: String): FilterTrait = {
    if (filterName == "MaleFilter") {
      return MaleFilter
    } else if (filterName == "FemaleFilter") {
      return FemaleFilter
    } else if (filterName == "BornOnSecondSemesterFilter") {
      return BornOnSecondSemesterFilter
    } else {
      return BornOnFirstSemesterFilter
    }
  }
}
