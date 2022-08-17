package health_declaration.repository.impl;

import health_declaration.model.HealthDeclaration;
import health_declaration.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {

    private static List<HealthDeclaration> healthDeclarations = new ArrayList<>();
    private static List<String> gender = new ArrayList<>();
    private static List<String> country = new ArrayList<>();
    private static List<String> day = new ArrayList<>();
    private static List<String> month = new ArrayList<>();
    private static List<String> year = new ArrayList<>();
    private static List<String> vehicle = new ArrayList<>();

    static {
        healthDeclarations.add(new HealthDeclaration("Nguyễn văn vĩnh", "1992", "Nam", "Việt Nam", 183658574, "Tàu bay", "TB23", "35", 19, 11, 2022, 22, 11, 2022, "Không"));
        healthDeclarations.add(new HealthDeclaration("Nguyễn văn nghĩa", "1994", "Nam", "Việt Nam", 1658574, "Tàu thuyền", "TT23", "23", 14, 10, 2022, 22, 10, 2022, "Không"));
        healthDeclarations.add(new HealthDeclaration("Nguyễn văn an", "1998", "Nam", "Việt Nam", 18338574, "ô tô", "OT23", "3", 15, 9, 2022, 18, 9, 2022, "Không"));

        vehicle.add("Tàu bay");
        vehicle.add("Tàu Thuyền");
        vehicle.add("Ô tô");
        vehicle.add("Khác");

        gender.add("Nam");
        gender.add("Nữ");

        country.add("Việt Nam");
        country.add("Hoa Kỳ");
        country.add("Japan");
        country.add("China");

        for (int i = 1930; i <= 2022; i++) {
            year.add(String.valueOf(i));
        }

        for (int i = 1; i <= 31; i++) {
            day.add(String.valueOf(i));
        }

        for (int i = 1; i <= 12; i++) {
            month.add(String.valueOf(i));
        }
    }

    @Override
    public List<String> birthday() {

        return year;
    }

    @Override
    public List<String> gender() {
        return gender;
    }

    @Override
    public List<String> country() {
        return country;
    }

    @Override
    public List<String> day() {
        return day;
    }

    @Override
    public List<String> month() {
        return month;
    }

    @Override
    public List<String> year() {
        return year;
    }

    @Override
    public List<String> vehicle() {
        return vehicle;
    }

    @Override
    public List<HealthDeclaration> selectAll() {
        return healthDeclarations;
    }

    @Override
    public void save(HealthDeclaration medicalDeclaration) {
        healthDeclarations.add(medicalDeclaration);
    }

    @Override
    public HealthDeclaration selectByIdCard(String idCard) {
        for (HealthDeclaration item : healthDeclarations) {
            if (idCard.equals(item.getIdCard())) ;
            return item;

        }
        return null;
    }

    @Override
    public void update(HealthDeclaration medicalDeclaration, String idCard) {
        for (HealthDeclaration item : healthDeclarations) {
            if (idCard.equals(item.getIdCard())) {
                item.setName(medicalDeclaration.getName());
                item.setBirthday(medicalDeclaration.getBirthday());
                item.setGender(medicalDeclaration.getGender());
                item.setCountry(medicalDeclaration.getCountry());
                item.setIdCard(medicalDeclaration.getIdCard());
                item.setVehicle(medicalDeclaration.getVehicle());
                item.setVehicleNumber(medicalDeclaration.getVehicleNumber());
                item.setChairNumber(medicalDeclaration.getChairNumber());
                item.setStartDay(medicalDeclaration.getStartDay());
                item.setStartMonth(medicalDeclaration.getStartMonth());
                item.setStartYear(medicalDeclaration.getStartYear());
                item.setEndDay(medicalDeclaration.getEndDay());
                item.setEndMonth(medicalDeclaration.getEndMonth());
                item.setEndYear(medicalDeclaration.getEndYear());
            }
        }
    }

}
