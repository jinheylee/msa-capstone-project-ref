package onlineshop.infra;

import onlineshop.domain.*;
import onlineshop.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderViewViewHandler {


    @Autowired
    private OrderViewRepository orderViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (!ordered.validate()) return;

            // view 객체 생성
            OrderView orderView = new OrderView();
            // view 객체에 이벤트의 Value 를 set 함
            orderView.setId(ordered.getId());
            orderView.setProductId(ordered.getProductId());
            orderView.setProductName(ordered.getProductName());
            orderView.setOrderStatus(ordered.getOrderStatus());
            orderView.setQty(ordered.getQty());
            orderView.setAddress(ordered.getAddress());
            // view 레파지 토리에 save
            orderViewRepository.save(orderView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회

                    List<OrderView> orderViewList = orderViewRepository.findBydeliveryStatus(deliveryStarted.getDeliveryStatus());
                    for(OrderView orderView : orderViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setId(deliveryStarted.getOrderId());
                // view 레파지 토리에 save
                orderViewRepository.save(orderView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCancelled_then_UPDATE_2(@Payload DeliveryCancelled deliveryCancelled) {
        try {
            if (!deliveryCancelled.validate()) return;
                // view 객체 조회

                    List<OrderView> orderViewList = orderViewRepository.findBydeliveryStatus(deliveryCancelled.getDeliveryStatus());
                    for(OrderView orderView : orderViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setId(deliveryCancelled.getOrderId());
                // view 레파지 토리에 save
                orderViewRepository.save(orderView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancelled_then_UPDATE_3(@Payload OrderCancelled orderCancelled) {
        try {
            if (!orderCancelled.validate()) return;
                // view 객체 조회

                    List<OrderView> orderViewList = orderViewRepository.findByorderStatus(orderCancelled.getorderStatus());
                    for(OrderView orderView : orderViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setId(orderCancelled.getid());
                // view 레파지 토리에 save
                orderViewRepository.save(orderView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

