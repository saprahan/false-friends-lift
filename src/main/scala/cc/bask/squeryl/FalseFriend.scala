package cc.bask.squeryl

import java.sql.Timestamp
import org.squeryl.KeyedEntity

case class FalseFriendId(id: Long) extends LongTypedId

case class FalseFriend(
                        text: String,
                        var createdate: Timestamp = null
                        ) extends KeyedEntity[Long] {
  val id: Long = 0

  def typedId = FalseFriendId(id)

  def this() = this(null)
}