import java.time.Instant

import org.apache.kafka.clients.producer._

object Producer {

  def main(args: Array[String]): Unit = {
    writeToKafka()
  }

  def writeToKafka(): Unit = {
    val producer = new KafkaProducer[String, MyRecord](Properties.props)
    val myRecord = MyRecord("id", Instant.now())

    val producerRecord = new ProducerRecord[String, MyRecord](Properties.topic, null, myRecord)
    val sendMessage = producer.send(producerRecord)
    val result = sendMessage.get()
    println(result.partition())
    producer.close()
  }
}
