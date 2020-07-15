import java.time.{Duration, Instant}
import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

case class MyRecord(id: String, time: Instant)

object Consumer {

  def main(args: Array[String]): Unit = {
    consumeFromKafka()
  }
  def consumeFromKafka(): Unit = {

    val props = Properties.props
    val consumer: KafkaConsumer[String, MyRecord] = new KafkaConsumer[String, MyRecord](props)
    consumer.subscribe(util.Arrays.asList(Properties.topic))
    while (true) {
      val record = consumer.poll(Duration.ofMillis(1000)).asScala
      for (data <- record.iterator) {
        val myRecord = data.value()
        println(myRecord)
      }
    }
  }
}

