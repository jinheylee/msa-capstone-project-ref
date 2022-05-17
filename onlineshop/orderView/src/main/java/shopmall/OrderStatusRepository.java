package shopmall;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OrderStatusRepository extends PagingAndSortingRepository<OrderStatus, Long>{

    List<OrderStatus> findByOrderId(Long orderId);
}