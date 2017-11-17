package com.kexke.app

import org.scalatra._

class MySbtServlet extends ScalatraServlet {

  get("/hello") {
    html.hello.render(new java.util.Date())
  }
  get("/about") {
    "about"
  }

  get("/aaa/:name") {
    // Matches "GET /hello/foo" and "GET /hello/bar"
    // params("name") is "foo" or "bar"
    val name = params("name")
    views.html.hello(name)
  }


}
