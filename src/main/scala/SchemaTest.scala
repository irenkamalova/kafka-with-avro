import com.sksamuel.avro4s.{AvroSchema, RecordFormat}

object SchemaTest {
  def main(args: Array[String]): Unit = {
    val schema = AvroSchema[Record]
    println(schema)
    val format = RecordFormat[Record]
    val record = Record("id")
    val avroRecord = format.to(record)
    println(avroRecord)
  }
}

