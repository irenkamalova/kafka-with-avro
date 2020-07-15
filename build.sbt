lazy val supportedScalaVersions = List("2.12.10")
crossScalaVersions := supportedScalaVersions
name := "connect-to-kafka"

version := "0.1"

scalaVersion := crossScalaVersions.value.head
resolvers += "Confluent" at "https://packages.confluent.io/maven/"

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.4.1"
// https://mvnrepository.com/artifact/com.sksamuel.avro4s/avro4s-kafka

libraryDependencies += "com.typesafe" % "config" % "1.4.0"

libraryDependencies += "io.confluent" % "kafka-avro-serializer" % "5.5.1"
