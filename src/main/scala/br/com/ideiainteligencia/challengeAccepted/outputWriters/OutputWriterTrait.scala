package br.com.ideiainteligencia.challengeAccepted.outputWriters

import br.com.ideiainteligencia.challengeAccepted.models.Record

trait OutputWriterTrait {
  def setDestinationFile(destinationFile:String)
  def addRecord(record: Record)
  def endOutput()
}
