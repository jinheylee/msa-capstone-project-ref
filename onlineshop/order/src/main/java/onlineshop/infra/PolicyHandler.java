package onlineshop.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;

import onlineshop.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import onlineshop.domain.*;


@Service
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStarted_OrderStatusUpdated(@Payload DeliveryStarted deliveryStarted){

        if(!deliveryStarted.validate()) return;
        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener OrderStatusUpdated : " + deliveryStarted.toJson() + "\n\n");


        

        // Sample Logic //
        Order.orderStatusUpdated(event);
        

        

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCancelled_OrderStatusUpdated(@Payload DeliveryCancelled deliveryCancelled){

        if(!deliveryCancelled.validate()) return;
        DeliveryCancelled event = deliveryCancelled;
        System.out.println("\n\n##### listener OrderStatusUpdated : " + deliveryCancelled.toJson() + "\n\n");


        

        // Sample Logic //
        Order.orderStatusUpdated(event);
        

        

    }


}


