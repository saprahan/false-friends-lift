package cc.bask.service

import cc.bask.squeryl.{DatabaseSchema, FalseFriendId, FalseFriend}
import java.util.Calendar


trait FalseFriendService extends CRUDService[FalseFriend, FalseFriendId] {
  def searchBy(searchText: String): Seq[FalseFriend]
}

class FalseFriendServiceImpl extends FalseFriendService with DatabaseSchema {
  def create(entity: FalseFriend) = inTransaction {
    val createDate = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    entity.createdate = createDate
    falseFriends.insert(entity).typedId
  }

  def update(entity: FalseFriend) = inTransaction {
    falseFriends.update(entity)
  }

  def lookup(entityId: FalseFriendId) = inTransaction {
    falseFriends.lookup(entityId.id)
  }

  def delete(entityId: FalseFriendId) = inTransaction {
    falseFriends.delete(entityId.id)
  }

  def searchBy(searchText: String) = inTransaction {
    from(falseFriends)((friend) =>
      select (friend)).distinct.toSeq
  }
}