package shopmall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name ="inventory", url="${api.url.inventory}")
public interface InventoryService {

    @RequestMapping(method = RequestMethod.POST, value = "/deduct", consumes = "application/json")
    public void deductStock(@RequestBody Inventory inventory);
}
