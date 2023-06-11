package com.example.spring_security_1.courier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepo courierRepo;

    public Courier findByPhone(String phone) {
        return courierRepo.findByPhoneAndDeletedFalse(phone);
    }

    public Courier save(Courier courier) {
        Courier oldCourier = courierRepo.findByPhoneAndDeletedFalse(courier.getPhone());
        if (oldCourier != null) {
            return null;
        }
        return courierRepo.save(courier);
    }

    public Courier findById(Long id) {
        return courierRepo.findByIdAndDeletedFalse(id);
    }

    public boolean delete(Long id) {
        return courierRepo.delete(id);
    }

    public Courier findByPhoneAndPassword(String phone, String password) {
        return courierRepo.findByPhoneAndPasswordAndDeletedFalse(phone, password);
    }

    public boolean update(Courier courier) {
        if (courierRepo.findByIdAndDeletedFalse(courier.getId()) != null) {
            courierRepo.save(courier);
            return true;
        }
        return false;
    }

    public List<Courier> findAll() {
        return courierRepo.findAllByDeletedFalse();
    }
}
