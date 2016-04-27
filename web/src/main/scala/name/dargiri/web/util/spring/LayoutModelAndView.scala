package name.dargiri.web.util.spring

import org.springframework.web.servlet.ModelAndView

object LayoutModelAndView {
  private def layout(string: String) = "layout:" + string
}

/**
 * Created by dionis on 2/2/14.
 */
class LayoutModelAndView(val viewName: String)
  extends
  ModelAndView(
    if (viewName != null) LayoutModelAndView.layout(viewName)
    else null
  ) {
  def this() = this(null)

  override def setViewName(viewName: String): Unit = super.setViewName(LayoutModelAndView.layout(viewName))
}
