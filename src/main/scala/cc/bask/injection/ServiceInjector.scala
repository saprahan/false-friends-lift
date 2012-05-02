package cc.bask.injection

import com.google.inject.{AbstractModule, Guice}

trait ServiceInjector {
  ServiceInjector.inject(this)
}

object ServiceInjector {
  private val injector = Guice.createInjector(new InjectionConfig)

  def inject(obj: AnyRef) = injector.injectMembers(obj)
}
