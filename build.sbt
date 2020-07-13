lazy val supportedScalaVersions = List("2.12.10")
crossScalaVersions := supportedScalaVersions
name := "connect-to-kafka"

version := "0.1"

scalaVersion := crossScalaVersions.value.head

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.4.1"
// https://mvnrepository.com/artifact/com.sksamuel.avro4s/avro4s-kafka
//libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-kafka" % "3.0.0-RC1"
//libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-kafka" % "3.0.9"
libraryDependencies += "com.typesafe" % "config" % "1.4.0"
libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-core" % "3.1.1"
libraryDependencies += "org.apache.avro" % "avro" % "1.8.2"