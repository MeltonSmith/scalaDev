ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

lazy val root = (project in file("."))
  .settings(
    name := "scalaDev",
    idePackagePrefix := Some("r.ian")
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16" % "test"