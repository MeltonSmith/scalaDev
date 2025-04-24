ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.16"

lazy val root = (project in file("."))
  .settings(
    name := "scalaDev",
    idePackagePrefix := Some("r.ian")
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16" % "test"
libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.2" % Test