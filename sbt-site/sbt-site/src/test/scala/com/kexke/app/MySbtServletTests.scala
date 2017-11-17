package com.kexke.app

import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike

class MySbtServletTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[MySbtServlet], "/*")

  test("GET / on MySbtServlet should return status 200"){
    get("/"){
      status should equal (200)
    }
  }

}
