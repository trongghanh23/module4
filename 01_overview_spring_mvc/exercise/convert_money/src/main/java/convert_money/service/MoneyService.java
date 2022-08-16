package convert_money.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class MoneyService implements IMoneyService {

    @Override
    public int convertMoney(int money) {
        int result = money * 23000;
        return result;

    }
}
