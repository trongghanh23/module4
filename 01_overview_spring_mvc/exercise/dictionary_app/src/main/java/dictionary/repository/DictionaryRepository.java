package dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("book", " quyển sách");
        dictionary.put("table", "bàn học");
        dictionary.put("computer", "máy tính");

    }

    @Override
    public String convert(String convertDictionary) {
        String result = null;
        if (dictionary.containsKey(convertDictionary)) {
            result = dictionary.get(convertDictionary);
            return result;

        }
        return "Không tìm thấy kết quả";
    }
}
