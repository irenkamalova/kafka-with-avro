lazy val supportedScalaVersions = List("2.12.10", "2.11.12")
crossScalaVersions := supportedScalaVersions
name := "connect-to-kafka"

version := "0.1"

scalaVersion := crossScalaVersions.value.head

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.5.0"
// https://mvnrepository.com/artifact/com.sksamuel.avro4s/avro4s-kafka
//libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-kafka" % "3.0.0-RC1"
//libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-kafka" % "3.0.9"
libraryDependencies += "com.typesafe" % "config" % "1.4.0"
libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-core" % "1.8.3"
libraryDependencies += "org.apache.avro" % "avro" % "1.8.2"