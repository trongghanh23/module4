package health_declaration.service;

import health_declaration.model.HealthDeclaration;

import java.util.List;

public interface IMedicalService {
    void save(HealthDeclaration medicalDeclaration);

    HealthDeclaration selectByIdCard(String idCard);

    void update(HealthDeclaration medicalDeclaration, String idCard);

    List<HealthDeclaration> selectAll();

    List<String>birthday();

    List<String>gender();

    List<String>country();

    List<String>day();

    List<String>month();

    List<String>year();

    List<String>vehicle();




}
