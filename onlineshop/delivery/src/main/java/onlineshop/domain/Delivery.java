package onlineshop.domain;

import onlineshop.domain.DeliveryStarted;
import onlineshop.domain.DeliveryCancelled;
import onlineshop.DeliveryApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Delivery_table")
public class Delivery  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private Long id;
    
    
    private Long orderId;
    
    
    private String deliveryStatus;
    
    
    private Long productId;
    
    
    private String productName;
    
    
    private Integer productqty;
    
    
    private String addrees;

    @PostPersist
    public void onPostPersist(){
        DeliveryStarted deliveryStarted = new DeliveryStarted();
        BeanUtils.copyProperties(this, deliveryStarted);
        deliveryStarted.publishAfterCommit();

        DeliveryCancelled deliveryCancelled = new DeliveryCancelled();
        BeanUtils.copyProperties(this, deliveryCancelled);
        deliveryCancelled.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductqty() {
        return productqty;
    }

    public void setProductqty(Integer productqty) {
        this.productqty = productqty;
    }

    public String getAddrees() {
        return addrees;
    }

    public void setAddrees(String addrees) {
        this.addrees = addrees;
    }



    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }


    public static void deliveryStarted(Ordered ordered){

        Delivery delivery = new Delivery();
        /*
        LOGIC GOES HERE
        */
        repository().save(delivery);


    }
    
    public static void deliveryCancelled(OrderCancelled ordered){

        Delivery delivery = new Delivery();
        /*
        LOGIC GOES HERE
        */
        repository().save(delivery);


    }


}
