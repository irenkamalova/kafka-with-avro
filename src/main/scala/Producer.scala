import com.sksamuel.avro4s.{AvroSchema, RecordFormat}
import org.apache.kafka.clients.producer._

object Producer {

  def main(args: Array[String]): Unit = {
    writeToKafka()
  }

  def writeToKafka(): Unit = {
    val producer = new KafkaProducer[String, Object](KafkaProperties.props)
    val schema = AvroSchema[Record]
    println(schema)
    val record = Record("id")
    val format = RecordFormat[Record]
    val avroRecord = format.to(record)
    val producerRecord = new ProducerRecord[String, Object](KafkaProperties.topic, null, avroRecord)
    val sendMessage = producer.send(producerRecord)
    val result = sendMessage.get()
    println(result.partition())
    producer.close()
  }
}
