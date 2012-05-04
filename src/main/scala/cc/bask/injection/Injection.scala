package cc.bask.injection

import com.google.inject.Guice

trait Injection {
  Injection.inject(this)
}

object Injection {
  private val injector = Guice.createInjector(new InjectionConfig)

  def inject(obj: AnyRef) = injector.injectMembers(obj)
}
