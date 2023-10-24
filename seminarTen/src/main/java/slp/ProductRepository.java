package slp;

import java.util.ArrayList;
import java.util.List;

// Пример репозитория для работы с продуктами
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    // Метод для добавления продукта
    public void addProduct(Product product) {
        products.add(product);
    }

    // Метод для получения всех продуктов
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}