package health_declaration.repository;

import health_declaration.model.HealthDeclaration;

import java.util.List;

public interface IMedicalRepository {
    List<String> birthday();

    List<String> gender();

    List<String> country();

    List<String> day();

    List<String> month();

    List<String> year();

    List<String> vehicle();

    List<HealthDeclaration> selectAll();

    void save(HealthDeclaration medicalDeclaration);

    HealthDeclaration selectByIdCard(String idCard);

    void update(HealthDeclaration medicalDeclaration, String idCard);
}
