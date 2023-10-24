package uwp;

public class Main {
    //Unit of Work Pattern
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();

        Product product1 = new Product(1, "Laptop");
        Product product2 = new Product(2, "Smartphone");

        productRepository.addNewProduct(product1);
        productRepository.addNewProduct(product2);

        System.out.println("Products (before commit): " + productRepository.getAllProducts());

        // Сохраняем все изменения (выполняем транзакцию)
        productRepository.commit();

        System.out.println("Products (after commit): " + productRepository.getAllProducts());
    }
}
