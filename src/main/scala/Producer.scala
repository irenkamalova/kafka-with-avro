import java.io.ByteArrayOutputStream

import com.sksamuel.avro4s.{AvroInputStream, AvroOutputStream, AvroSchema, RecordFormat}
import org.apache.kafka.clients.producer._
import org.apache.avro.generic.GenericRecord
import org.apache.avro.specific.SpecificRecordBase

object Producer {

  def main(args: Array[String]): Unit = {
    writeToKafka()
  }

  def writeToKafka(): Unit = {
    val producer = new KafkaProducer[String, Array[Byte]](Properties.props)
    val outputStream = new ByteArrayOutputStream()
    val records = Seq(Record("id1"), Record("id2"))
    val os = AvroOutputStream.data[Record](outputStream)
    os.write(records)
    os.flush()
    os.close()

    val bytes = outputStream.toByteArray

    val producerRecord = new ProducerRecord[String, Array[Byte]](Properties.topic, null, bytes)
    val sendMessage = producer.send(producerRecord)
    val result = sendMessage.get()
    println(result.partition())
    producer.close()
  }
}
