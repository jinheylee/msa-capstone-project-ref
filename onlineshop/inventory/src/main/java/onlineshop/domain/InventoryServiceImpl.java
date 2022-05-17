package onlineshop.domain;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public void decreaseStock(Long productId, int quantity) {

        /**
         * 주문이 발생시, 수량을 줄인다.
         */
        Optional<Inventory> productOptional = inventoryRepository.findById(productId);
        Inventory product = productOptional.get();
        product.setQty(product.getQty() - quantity);

        inventoryRepository.save(product);

    }

    public void increaseStock(Long productId, int quantity) {
        /**
         * 주문 취소시, 수량을 늘인다
         */
        Optional<Inventory> productOptional = inventoryRepository.findById(productId);
        Inventory product = productOptional.get();
        product.setQty(product.getQty() + quantity);

        inventoryRepository.save(product);
    }

    /**
     * 상품 조회
     */
    public Inventory getProductById(Long id){

        Optional<Inventory> productOptional = inventoryRepository.findById(id);
        Inventory product = productOptional.get();

        return product;
    }
    public Inventory getProductByProductId(Long productId){

        Optional<Inventory> productOptional = inventoryRepository.findByProductId(productId);
        Inventory product = productOptional.get();

        return product;
    }

    public Inventory save(String data){
        ObjectMapper mapper = new ObjectMapper();
        Inventory product = null;
        try {
            product = mapper.readValue(data, Inventory.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventoryRepository.save(product);
    }
}
