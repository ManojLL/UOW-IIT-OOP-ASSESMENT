name := """premier-league-manager"""
organization := "lk.iit.oop.w1761261"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava).settings(
  watchSources ++= (baseDirectory.value / "ui/src" ** "*").get
)

scalaVersion := "2.13.3"

libraryDependencies += guice
// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.199"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.12.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "3.1.6" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
