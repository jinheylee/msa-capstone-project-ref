package onlineshop;
import onlineshop.config.kafka.KafkaProcessor;
import onlineshop.domain.Inventory;
import onlineshop.domain.InventoryRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class InventoryApplication {
    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(InventoryApplication.class, args);

        InventoryRepository productRepository = applicationContext.getBean(InventoryRepository.class);
        // 초기 상품 셋팅
        String[] products = {"TV", "MASK", "NOTEBOOK", "TABLE", "CLOCK"};
        long i = 1;
        for(String p : products){
            Inventory inventory = new Inventory();
            inventory.setProductId(i);
            inventory.setProductName(p);
            inventory.setQty(100);

            i++;
            productRepository.save(inventory);
        }


    }
}