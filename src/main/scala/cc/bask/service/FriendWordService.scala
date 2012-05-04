package cc.bask.service

import cc.bask.squeryl.{DatabaseSchema, FriendWordId, FalseFriendId, FriendWord}

trait FriendWordService extends CRUDService[FriendWord, FriendWordId] {
  def selectBy(falseFriendId: FalseFriendId): Seq[FriendWord]
}

class FriendWordServiceImpl extends FriendWordService with DatabaseSchema {
  def create(entity: FriendWord) = inTransaction {
    friendWords.insert(entity).typedId
  }

  def update(entity: FriendWord) = inTransaction {
    friendWords.update(entity)
  }

  def lookup(entityId: FriendWordId) = inTransaction {
    friendWords.lookup(entityId.id)
  }

  def delete(entityId: FriendWordId) = inTransaction {
    friendWords.delete(entityId.id)
  }

  def selectBy(falseFriendId: FalseFriendId) = inTransaction {
    from(friendWords)(fW =>
      where(fW.friendId === falseFriendId.id)
        select (fW)
        orderBy (fW.languageId)).toSeq
  }
}