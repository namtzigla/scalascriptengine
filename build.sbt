import sbt.cross.CrossVersionUtil

name := "scalascriptengine"

organization := "com.googlecode.scalascriptengine"

scalaVersion := "2.10.4"

crossScalaVersions := Seq("2.10.4","2.11.2")

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _ )

libraryDependencies ++= Seq(
  "commons-io"      % "commons-io"      % "2.1",
  "org.slf4j"       % "slf4j-api"       % "1.6.4",
  "ch.qos.logback"  % "logback-classic" % "1.0.0",
  "joda-time"       % "joda-time"       % "2.5",
  "junit"           % "junit"           % "4.10"   % "test",
  "org.scalatest"  %% "scalatest"       % "2.2.2"  % "test"
)

libraryDependencies <++= (scalaVersion) { (v) =>
  val scalaVersionString = v match {
    case "2.10.4" => "2.10"
    case "2.11.2" => "2.11"
  }
  Seq(
    "com.googlecode.classgenerator"   % "classgenerator"   %  s"0.7.0-${scalaVersionString}",
    "com.googlecode.scalaconcurrency" % "scalaconcurrency" %  s"0.9.0-${scalaVersionString}"
  )
}

fork := true
