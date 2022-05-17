package shopmall;

import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface DeliveryRepository extends PagingAndSortingRepository<Delivery, Long>{

    List<Delivery> findByOrderId(Long orderId);
}