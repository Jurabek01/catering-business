package com.example.spring_security_1.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourierRepo extends JpaRepository<Courier, Long> {
    Courier findByPhoneAndDeletedFalse(String phone);
    List<Courier> findAllByDeletedFalse();
    Courier findByIdAndDeletedFalse(Long id);
    Courier findByPhoneAndPasswordAndDeletedFalse(String phone, String password);
    @Query(value = "UPDATE courier SET deleted = true WHERE id = ?1 AND deleted = false", nativeQuery = true)
    boolean delete(Long id);
}
