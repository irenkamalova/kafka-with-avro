import java.time.Duration
import java.util

import com.sksamuel.avro4s.AvroInputStream
import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object Consumer {

  def main(args: Array[String]): Unit = {
    consumeFromKafka()
  }
  def consumeFromKafka(): Unit = {

    val props = Properties.props
    val consumer: KafkaConsumer[String, Array[Byte]] = new KafkaConsumer[String, Array[Byte]](props)
    consumer.subscribe(util.Arrays.asList(Properties.topic))
    while (true) {
      val record = consumer.poll(Duration.ofMillis(1000)).asScala
      for (data <- record.iterator) {
        val bytes = data.value()
        val is = AvroInputStream.data[Record](bytes)
        val users = is.iterator.toSet
        is.close()

        println("len: " + bytes.length)
        println(users.mkString("\n"))
      }
    }
  }
}

