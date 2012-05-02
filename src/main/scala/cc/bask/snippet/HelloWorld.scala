package cc.bask {
package snippet {

import _root_.scala.xml.{NodeSeq, Text}
import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.java.util.Date
import cc.bask.lib._
import Helpers._
import service.LanguageService
import com.google.inject.Inject
import injection.ServiceInjector

class HelloWorld extends ServiceInjector {

  @Inject private var languageService: LanguageService = _

  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  // bind the date into the element with id "time"
  def howdy = "#time *" #> (languageService == null).toString

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
}

}
}
