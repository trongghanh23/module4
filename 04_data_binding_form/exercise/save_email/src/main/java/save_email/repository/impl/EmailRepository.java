package save_email.repository.impl;

import org.springframework.stereotype.Repository;
import save_email.repository.IEmailRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<String> language=new ArrayList<>();
    private static List<String> size=new ArrayList<>();

    static {
        language.add("English");
        language.add("Vietnamese");
        language.add("Japanese");
        language.add("Chinese");

        size.add("5");
        size.add("10");
        size.add("15");
        size.add("25");
        size.add("50");
        size.add("100");
    }

    @Override
    public List<String> language() {
        return language;
    }

    @Override
    public List<String> size() {
        return size;
    }
}
