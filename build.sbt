
lazy val root = (project in file(".")).
  settings(
    name := "challenge-accepted",
    version := "0.1",
    scalaVersion := "2.11.8",
    scalacOptions += "-feature",
    libraryDependencies ++= {
      Seq(
        "ch.qos.logback" % "logback-classic" % "1.1.2",
        "com.typesafe.akka" % "akka-actor_2.11" % "2.4.1",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
        "org.json4s" % "json4s-native_2.11" % "3.4.0",
        "org.scala-lang.modules" %% "scala-xml" % "1.0.2",
        "org.scalactic" %% "scalactic" % "3.0.0",
        "org.scalatest" %% "scalatest" % "3.0.0" % "test"
      )
    }
  )
