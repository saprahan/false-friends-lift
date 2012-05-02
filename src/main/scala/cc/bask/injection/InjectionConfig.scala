package cc.bask.injection

import com.google.inject.{Binder, AbstractModule}
import cc.bask.service.{LanguageServiceImpl, LanguageService}

class InjectionConfig extends AbstractModule {
  protected def configure() {
    bind(classOf[LanguageService]).to(classOf[LanguageServiceImpl])
  }
}
