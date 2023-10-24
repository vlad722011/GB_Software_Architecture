package uwp;

import java.util.ArrayList;
import java.util.List;

// Пример репозитория для работы с продуктами
public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private List<Product> newProducts = new ArrayList<>();
    private List<Product> deletedProducts = new ArrayList<>();

    // Метод для добавления продукта в список новых продуктов
    public void addNewProduct(Product product) {
        newProducts.add(product);
    }

    // Метод для удаления продукта из списка продуктов
    public void deleteProduct(Product product) {
        products.remove(product);
        deletedProducts.add(product);
    }

    // Метод для сохранения всех изменений
    public void commit() {
        products.addAll(newProducts);
        products.removeAll(deletedProducts);
        newProducts.clear();
        deletedProducts.clear();
    }

    // Метод для получения всех продуктов
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
