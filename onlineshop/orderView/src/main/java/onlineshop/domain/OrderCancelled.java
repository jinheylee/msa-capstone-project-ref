package onlineshop.domain;

import onlineshop.infra.AbstractEvent;


public class OrderCancelled extends AbstractEvent {

    private Long id;
    private Long deliveryId;
    private String productName;
    private String productId;
    private Integer qty;
    private String orderStatus;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long getdeliveryId() {
        return deliveryId;
    }

    public void setdeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }
    public String getproductId() {
        return productId;
    }

    public void setproductId(String productId) {
        this.productId = productId;
    }
    public Integer getqty() {
        return qty;
    }

    public void setqty(Integer qty) {
        this.qty = qty;
    }
    public String getorderStatus() {
        return orderStatus;
    }

    public void setorderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
