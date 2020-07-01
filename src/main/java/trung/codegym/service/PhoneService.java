package trung.codegym.service;

import trung.codegym.model.SmartPhone;

public interface PhoneService {
    Iterable<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone phone);
    void remove(Integer id);
}
