package manager_spice.repository.impl;

import manager_spice.repository.ISpiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpiceRepository implements ISpiceRepository {
    private static List<String> spice=new ArrayList<>();
    static {
        spice.add("lettuce");
        spice.add("tomato");
        spice.add("mustard");
        spice.add("sprouts");
    }

    @Override
    public List<String> chooseSpiceSandwich() {
        return spice;
    }
}
