package com.example.spring_security_1.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findByIdAndDeletedFalse(Long id);

    List<Order> findAllByUserIdAndDeletedFalse(Long userId);

    List<Order> findAllByDeletedFalse();

    @Query(value = """
            SELECT * FROM orders o
            left join order_address oa on o.id = oa.order_id
            left join users u on o.user_id = u.id
            left join order_price op on o.id = op.order_id
            WHERE not o.deleted and not oa.deleted 
            and not u.deleted and not op.deleted
            (lower(u.first_name) like '%?1%' 
            or lower(u.last_name) like '%?1%' 
            or lower(u.phone) like '%?1%'
            or lower(oa.description) like '%?1% '
            or lower(o.id) like '%?1%')""", nativeQuery = true)
    List<Order> search(String line);

    @Query(value = "UPDATE order SET deleted = true WHERE id = ?1 AND deleted = false", nativeQuery = true)
    boolean delete(Long id);
}