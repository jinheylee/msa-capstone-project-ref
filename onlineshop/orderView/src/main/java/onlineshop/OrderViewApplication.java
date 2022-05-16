package onlineshop;
import onlineshop.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class OrderViewApplication {
    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(OrderViewApplication.class, args);
    }
}