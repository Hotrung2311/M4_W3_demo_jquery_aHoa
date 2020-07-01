package trung.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import trung.codegym.model.SmartPhone;
import trung.codegym.repository.SmartphoneRepository;

public class PhoneServiceImpl implements PhoneService{

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartphoneRepository.findOne(id);
    }

    @Override
    public SmartPhone save(SmartPhone phone) {
        return smartphoneRepository.save(phone);
    }

    @Override
    public void remove(Integer id) {
        SmartPhone smartPhone = smartphoneRepository.findOne(id);
        smartphoneRepository.delete(smartPhone);
    }
}
