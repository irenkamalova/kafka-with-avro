import java.io.File
import java.util.Properties

import com.typesafe.config.ConfigFactory
import io.confluent.kafka.serializers.KafkaAvroSerializer
import io.confluent.kafka.serializers.KafkaAvroDeserializer
import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}


object Properties {
  val config = ConfigFactory.parseFile(new File("application.conf")).getConfig("KafkaConfig.kafka")
  //val dataSerde2 = new GenericSerde[Seq[Record]]
  val topic = config.getString("topic")
  val props = new Properties()
  props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, config.getString(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG))
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
  props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])

  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[KafkaAvroSerializer])
  props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[KafkaAvroDeserializer])

  props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, config.getString(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG))
  props.put(ConsumerConfig.GROUP_ID_CONFIG, config.getString(ConsumerConfig.GROUP_ID_CONFIG))
  def getProps: Properties = props
}
