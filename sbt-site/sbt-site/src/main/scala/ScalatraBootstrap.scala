import com.kexke.app._
import com.kexke.controller._
import org.scalatra._
import javax.servlet.ServletContext


class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new MySbtServlet, "/hello")
    context.mount(new ApiController, "/api/v3")
  }
//  context.mount(new IndexController, "/")
}
