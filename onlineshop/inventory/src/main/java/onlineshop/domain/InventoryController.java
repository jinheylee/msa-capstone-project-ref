package onlineshop.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping("/deduct")
    Inventory deduckQty(@RequestBody String data) throws Exception {
        System.out.println(data);

        ObjectMapper mapper = new ObjectMapper();
        Inventory product = null;
        try {
            product = mapper.readValue(data, Inventory.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Inventory inventory = inventoryService.getProductByProductId(product.getProductId());

        if(inventory.getQty() < product.getQty()){
            throw new Exception("재고 부족");
        }else{
            inventoryService.decreaseStock(product.getProductId(),product.getQty());
        }

        return inventory;
    }
}
