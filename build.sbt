import Dependencies._

version := "0.1.0-SNAPSHOT"

val scalaVersionBuild = "2.12.6"
val organizationName = "com.avertia"

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := organizationName,
      scalaVersion := scalaVersionBuild
    )),
    name := "Formamus",
    organization := organizationName,
    libraryDependencies ++= Seq(
      scalaTest % "test"
    )
  )