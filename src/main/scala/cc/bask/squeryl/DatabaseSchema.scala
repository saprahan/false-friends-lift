package cc.bask.squeryl

import org.squeryl.{PrimitiveTypeMode, Schema}


trait DatabaseSchema extends Schema with PrimitiveTypeMode {
  val languages = table[Language]
  val falseFriends = table[FalseFriend]
  val friendWords = table[FriendWord]
}

object DatabaseSchema extends DatabaseSchema

trait TypedId[T] {
  def id: T
}

trait LongTypedId extends TypedId[Long]