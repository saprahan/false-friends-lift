package cc.bask.squeryl

import org.squeryl.KeyedEntity

case class LanguageId(id: Long) extends LongTypedId

case class Language(
                     name: String,
                     nameEnglish: String,
                     code: String
                     ) extends KeyedEntity[Long] {
  val id: Long = 0

  def typedId = LanguageId(id)
}