package manager_spice.service.impl;

import manager_spice.repository.ISpiceRepository;
import manager_spice.service.ISpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpiceService implements ISpiceService {
    @Autowired
    private ISpiceRepository iSpiceRepository;

    @Override
    public List<String> chooseSpiceSandwich() {
        return iSpiceRepository.chooseSpiceSandwich();
    }
}
