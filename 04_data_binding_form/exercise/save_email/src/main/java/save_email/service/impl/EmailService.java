package save_email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save_email.repository.IEmailRepository;
import save_email.service.IEmailService;

import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<String> language() {
        return iEmailRepository.language();
    }

    @Override
    public List<String> size() {
        return iEmailRepository.size();
    }
}
