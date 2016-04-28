package my.scala.web.util

import org.fusesource.scalate.servlet.ServletRenderContext._

/**
 * Utility class to be used in Scalate views
 * Created by dionis on 2/2/14.
 */
object ScalateUtil {
  def url(url: String) : Unit = {
    request.getServletPath + "/" + url
  }
}
