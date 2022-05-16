package onlineshop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="OrderView_table")
public class OrderView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long productId;
        private String productName;
        private Integer qty;
        private String orderStatus;
        private String deliveryStatus;
        private String address;


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
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

}