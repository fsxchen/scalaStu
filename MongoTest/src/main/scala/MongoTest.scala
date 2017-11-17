import com.mongodb.casbah.Imports._


object MongoTest{
  def main(args: Array[String]): Unit = {
    val mongoClient =  MongoClient("192.168.228.132")
    println(mongoClient)
  }
}