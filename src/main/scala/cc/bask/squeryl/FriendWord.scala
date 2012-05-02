package cc.bask.squeryl

import org.squeryl.KeyedEntity


case class FriendWord(
                       friendId: Long,
                       languageId: Long,
                       word: String
                       ) extends KeyedEntity[Long] {
  val id: Long = 0

  def typedId = FriendWordId(id)

  def typedLanguageId = LanguageId(languageId)

  def typedFriendId = FalseFriendId(friendId)
}

case class FriendWordId(id: Long) extends LongTypedId





