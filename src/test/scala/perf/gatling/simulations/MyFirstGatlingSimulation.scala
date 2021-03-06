package perf.gatling.simulations

import scala.concurrent.duration._ 

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class MyFirstGatlingSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
        .doNotTrackHeader("1")
        .acceptLanguageHeader("en-US,en;q=0.5")
        .acceptEncodingHeader("gzip, deflate")
        .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

    val scn = scenario("MyFirstGatlingSimulation")
        .exec(
            http("request_0")
                .get("/computers")
        )
        .pause(5)
    
    setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}