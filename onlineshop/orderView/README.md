
PolicyHandler 에 추가 되어야할 로직

````java

    @StreamListener(KafkaProcessor.INPUT)
    public void when_UPDATE_OrderCancelled(@Payload OrderCancelled orderCancelled){
        if(orderCancelled.isMe()){
            OrderStatus orderStatus = repository.findById(orderCancelled.getId()).orElse(null);;
            if( orderStatus != null ){
                orderStatus.setOrderStatus(OrderCancelled.class.getSimpleName());
                repository.save(orderStatus);
            }
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void when_UPDATE_DeliveryCancelled(@Payload DeliveryCancelled deliveryCancelled){
        if(deliveryCancelled.isMe()){
            OrderStatus orderStatus = repository.findById(deliveryCancelled.getOrderId()).orElse(null);;
            if( orderStatus != null ){
                orderStatus.setDeliveryStatus(DeliveryCancelled.class.getSimpleName());
                repository.save(orderStatus);
            }
        }
    }
````