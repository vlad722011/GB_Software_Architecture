package slp;

import java.util.List;

public class Main {
    //Service Layer Pattern
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        Product product1 = new Product(1, "Laptop");
        Product product2 = new Product(2, "");

        // Добавляем продукты с бизнес-логикой через сервисный слой
        productService.addProductWithLogic(product1);
        productService.addProductWithLogic(product2);

        // Получаем все продукты через сервисный слой
        List<Product> products = productService.getAllProducts();

        System.out.println("All Products: " + products);
    }
}