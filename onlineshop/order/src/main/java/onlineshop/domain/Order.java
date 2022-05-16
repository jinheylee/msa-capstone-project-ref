package onlineshop.domain;

import onlineshop.domain.Ordered;
import onlineshop.domain.OrderCancelled;
import onlineshop.OrderApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Order_table")
public class Order  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private Long id;
    
    
    private Long deliveryId;
    
    
    private String productName;
    
    
    private String productId;
    
    
    private Integer qty;
    
    
    private String address;
    
    
    private String orderStatus;

    @PostPersist
    public void onPostPersist(){
        Ordered ordered = new Ordered();
        BeanUtils.copyProperties(this, ordered);
        ordered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        onlineshop.external.Inventory inventory = new onlineshop.external.Inventory();
        // mappings goes here
        OrderApplication.applicationContext.getBean(onlineshop.external.InventoryService.class)
            .deductStock(inventory);

        OrderCancelled orderCancelled = new OrderCancelled();
        BeanUtils.copyProperties(this, orderCancelled);
        orderCancelled.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }



    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }


    public static void orderStatusUpdated(DeliveryStarted deliveryStarted){

        Order order = new Order();
        /*
        LOGIC GOES HERE
        */
        repository().save(order);


    }
    public static void orderStatusUpdated(DeliveryCancelled deliveryCancelled){

        Order order = new Order();
        /*
        LOGIC GOES HERE
        */
        repository().save(order);


    }


}
