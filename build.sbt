
lazy val root = (project in file(".")).
  settings(
    name := "challenge-accepted",
    version := "0.1",
    scalaVersion := "2.11.8",
    libraryDependencies ++= {
      Seq(
        "org.scala-lang.modules" %% "scala-xml" % "1.0.2",
        "org.json4s" % "json4s-native_2.11" % "3.4.0",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
        "ch.qos.logback" % "logback-classic" % "1.1.2"
      )
    }
  )
