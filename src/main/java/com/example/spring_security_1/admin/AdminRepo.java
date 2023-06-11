package com.example.spring_security_1.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRepo extends JpaRepository<Admin, Long> {
    Admin findByPhone(String phone);

    @Query(value = "SELECT * FROM admin WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Admin findByIdAndByDeletedFalse(Long id);

    Admin findByPhoneAndPassword(String phone, String password);

    Admin findByPhoneAndDeletedFalse(String phone);


    List<Admin> findAllByDeletedFalse();

    @Query(value = "UPDATE admin SET delete = true WHERE id = ?1 AND deleted = false", nativeQuery = true)
    boolean delete(Long id);
}
