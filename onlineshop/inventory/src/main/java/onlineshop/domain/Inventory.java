package onlineshop.domain;

import onlineshop.InventoryApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name="Inventory_table")
public class Inventory  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private Long id;
    
    
    private Long productId;
    
    
    private String productName;
    
    
    private Integer qty;

    @PostPersist
    public void onPostPersist(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }



    public static InventoryRepository repository(){
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(InventoryRepository.class);
        return inventoryRepository;
    }


    public static void stockStatusUpdated(OrderCancelled orderCancelled){

        Inventory inventory = new Inventory();
        /*
        LOGIC GOES HERE
        */
        repository().save(inventory);


    }


}
