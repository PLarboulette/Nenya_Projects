name := "Nenya_Projects"

version := "1.0"

scalaVersion := "2.11.8"

lazy val versions = new {
  val finatra = "2.0.0"
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com",
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(

  "io.reactivex" %% "rxscala" % "0.26.2",

  "com.rabbitmq" % "amqp-client" % "3.6.1",
  "com.typesafe.play" %% "play-json" % "2.3.4",

  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.scalatest" %% "scalatest" % "2.2.3" % "test",
  "org.specs2" %% "specs2" % "2.3.12" % "test",

  "net.debasishg" %% "redisclient" % "3.0",
  "joda-time" % "joda-time" % "2.9.2",

  "org.mongodb" %% "casbah" % "3.1.1"
)

