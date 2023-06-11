package com.example.spring_security_1.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepo adminRepo;

    public Admin findByPhone(String phone) {
        return adminRepo.findByPhoneAndDeletedFalse(phone);
    }

    public Admin save(Admin admin) {
        Admin oldAdmin = adminRepo.findByPhoneAndDeletedFalse(admin.getPhone());
        if (oldAdmin != null) {
            return null;
        }
        return adminRepo.save(admin);
    }

    public Admin findById(Long id) {
        return adminRepo.findByIdAndByDeletedFalse(id);
    }

    public List<Admin> findAll() {
        return adminRepo.findAllByDeletedFalse();
    }

    public boolean delete(Long id) {
        return adminRepo.delete(id);
    }
}
