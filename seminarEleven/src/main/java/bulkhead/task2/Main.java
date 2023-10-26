package bulkhead.task2;

import java.util.ArrayList;
import java.util.List;

// Класс представляет банковского оператора
class BankOperator {
    private String name;

    public BankOperator(String name) {
        this.name = name;
    }

    // Метод для обработки транзакций клиентов
    public void processTransaction() {
        // Предположим, здесь возможна ошибка при обработке транзакции.
        // В данном случае, мы выбрасываем исключение прямо в методе.
        if (Math.random() < 0.5) {
            throw new RuntimeException("Error processing transaction for " + name);
        }
        System.out.println(name + " is processing a transaction.");
    }
}

// Класс, представляющий банк
class Bank {
    private List<BankOperator> operators = new ArrayList<>(); // Список банковских операторов

    // Конструктор, создающий банк с заданным числом операторов
    public Bank(int operatorCount) {
        for (int i = 0; i < operatorCount; i++) {
            operators.add(new BankOperator("Operator " + (i + 1)));
        }
    }

    // Метод для обработки транзакции определенным оператором
    public void processTransactionWithOperator(int operatorIndex) {
        if (operatorIndex >= 0 && operatorIndex < operators.size()) {
            BankOperator operator = operators.get(operatorIndex);
            try {
                operator.processTransaction();
            } catch (RuntimeException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid operator index.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(5);

        // Обработка транзакций разными операторами
        bank.processTransactionWithOperator(0);
        bank.processTransactionWithOperator(2);
        bank.processTransactionWithOperator(4);

        // Попытка обработать транзакцию с несуществующим оператором
        bank.processTransactionWithOperator(6); // Invalid operator index.
    }
}
