import java.io.ByteArrayOutputStream

import com.sksamuel.avro4s.{AvroInputStream, AvroOutputStream}

object SampleAvro4sData {

  def main(args: Array[String]): Unit = {

    val outputStream = new ByteArrayOutputStream()
    val os = AvroOutputStream.data[Record](outputStream)
    os.write(Seq(
      Record("id1"),
      Record("id2")))
    os.flush()
    os.close()

    val bytes = outputStream.toByteArray

    val is = AvroInputStream.data[Record](bytes)
    val users = is.iterator.toSet
    is.close()

    println("len: " + bytes.length)
    println(users.mkString("\n"))
  }
}