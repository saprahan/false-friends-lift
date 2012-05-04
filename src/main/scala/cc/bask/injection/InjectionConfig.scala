package cc.bask.injection

import com.google.inject.AbstractModule
import cc.bask.service.{FalseFriendService, FalseFriendServiceImpl, LanguageServiceImpl, LanguageService}

class InjectionConfig extends AbstractModule {
  protected def configure() {
    bind(classOf[LanguageService]).to(classOf[LanguageServiceImpl])
    bind(classOf[FalseFriendService]).to(classOf[FalseFriendServiceImpl])
  }
}
