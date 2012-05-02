package cc.bask.service

import cc.bask.squeryl.{DatabaseSchema, LanguageId, Language}

trait LanguageService extends CRUDService[Language, LanguageId] {
  def selectAll: Seq[Language]
}

class LanguageServiceImpl extends LanguageService with DatabaseSchema {
  def create(entity: Language) = inTransaction {
    languages.insert(entity).typedId
  }

  def update(entity: Language) = inTransaction {
    languages.update(entity)
  }

  def lookup(entityId: LanguageId) = inTransaction {
    languages.lookup(entityId.id)
  }

  def delete(entityId: LanguageId) = inTransaction {
    languages.delete(entityId.id)
  }

  def selectAll = inTransaction {
    from(languages)(l =>
      select(l)
        orderBy (l.code)).toSeq
  }
}