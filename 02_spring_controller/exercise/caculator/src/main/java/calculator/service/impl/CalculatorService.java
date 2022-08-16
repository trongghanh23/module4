package calculator.service.impl;

import calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String calculator(double number1, double number2, String operator) {
        String result = null;
        switch (operator) {
            case "Addition(+)":
                return result = String.valueOf(number1 + number2);


            case "Subtraction(-)":
                return result = String.valueOf(number1 - number2);

            case "Multiplication(*)":
                return result = String.valueOf(number1 * number2);


            case "Division(/)":

                return result = String.valueOf(number1 / number2);

        }
        return result;

    }
}
