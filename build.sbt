name := "connect-to-kafka"

version := "0.1"

scalaVersion := "2.12.11"

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.4.1"
// https://mvnrepository.com/artifact/com.sksamuel.avro4s/avro4s-kafka
libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-kafka" % "3.0.0-RC1"

libraryDependencies += "com.typesafe" % "config" % "1.4.0"