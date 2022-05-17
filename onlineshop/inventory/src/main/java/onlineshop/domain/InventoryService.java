package onlineshop.domain;

public interface InventoryService {
    void decreaseStock(Long productId, int quantity);
    void increaseStock(Long productId, int quantity);
    Inventory getProductById(Long id);
    Inventory getProductByProductId(Long ProductId);
    Inventory save(String data);
    //Inventory deduck(String data);
}
