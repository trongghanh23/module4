package health_declaration.service.impl;

import health_declaration.model.HealthDeclaration;
import health_declaration.repository.IMedicalRepository;
import health_declaration.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class medicalService implements IMedicalService {
    @Autowired
    private IMedicalRepository iMedicalRepository;

    @Override
    public List<HealthDeclaration> selectAll() {
        return iMedicalRepository.selectAll();
    }

    @Override
    public List<String> birthday() {
        return iMedicalRepository.birthday();
    }

    @Override
    public List<String> gender() {
        return iMedicalRepository.gender();
    }

    @Override
    public List<String> country() {
        return iMedicalRepository.country();
    }

    @Override
    public List<String> day() {
        return iMedicalRepository.day();
    }

    @Override
    public List<String> month() {
        return iMedicalRepository.month();
    }

    @Override
    public List<String> year() {
        return iMedicalRepository.year();
    }

    @Override
    public List<String> vehicle() {
        return iMedicalRepository.vehicle();
    }

    @Override
    public void save(HealthDeclaration medicalDeclaration) {
        iMedicalRepository.save(medicalDeclaration);
    }

    @Override
    public HealthDeclaration selectByIdCard(String idCard) {
        return iMedicalRepository.selectByIdCard(idCard);
    }

    @Override
    public void update(HealthDeclaration medicalDeclaration, String idCard) {
        iMedicalRepository.update(medicalDeclaration,idCard);
    }
}
