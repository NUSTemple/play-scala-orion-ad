import com.typesafe.config._

val conf = ConfigFactory.parseFile(new File("conf/application.conf")).resolve()
val appName    = conf.getString("app.name")
val appVersion = conf.getString("app.version")

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-scala-orion-ad""",
    organization := "com.micron.f10ds",
    version := appVersion,
    scalaVersion := "2.13.1",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
