import java.time.Duration
import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object Consumer {

  def main(args: Array[String]): Unit = {
    consumeFromKafka()
  }
  def consumeFromKafka(): Unit = {

    val props = KafkaProperties.props
    val consumer: KafkaConsumer[String, Object] = new KafkaConsumer[String, Object](props)
    consumer.subscribe(util.Arrays.asList(KafkaProperties.topic))
    while (true) {
      val record = consumer.poll(Duration.ofMillis(1000)).asScala
      for (data <- record.iterator) {
        println(data.key())
        println(data.value())
      }
    }
  }
}

