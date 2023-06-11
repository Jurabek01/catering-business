package com.example.spring_security_1.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

        private final OrderRepo orderRepo;

        public Order findById(Long id) {
            return orderRepo.findByIdAndDeletedFalse(id);
        }

        public Order save(Order order) {
            return orderRepo.save(order);
        }

        public boolean delete(Long id) {
            return orderRepo.delete(id);
        }

        public boolean update(Order order) {
            if (orderRepo.findByIdAndDeletedFalse(order.getId()) != null) {
                orderRepo.save(order);
                return true;
            }
            return false;
        }

        public List<Order> findAll() {
            return orderRepo.findAllByDeletedFalse();
        }

        public List<Order> search(String line) {
            return orderRepo.search(line);
        }
}
