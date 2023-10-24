package slp;

import java.util.List;

// Пример сервисного слоя для бизнес-логики
public class ProductService {
    private ProductRepository productRepository = new ProductRepository();

    // Метод для добавления продукта с бизнес-логикой
    public void addProductWithLogic(Product product) {
        if (product.getName() != null && !product.getName().isEmpty()) {
            productRepository.addProduct(product);
        }
    }

    // Метод для получения всех продуктов через репозиторий
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}