import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        if (product == null) {
            System.out.println("ProductRepo::add: product is null");
        }
        if (products.contains(product)) {
            System.out.println("ProductRepo::add: This product already exists");
        }
        products.add(product);
        System.out.println("ProductRepo::add: Product added: " + product);
    }

    public void remove(Product product) {
        if (product == null) {
            System.out.println("ProductRepo::remove: product is null");
        }
        if (!products.contains(product)) {
            System.out.println("ProductRepo::remove: This product does not exist: " + product);
        }
        products.remove(product);
        System.out.println("ProductRepo::remove: Product removed: " + product);
    }

    public Product get(Integer productId) {
        if (productId == null) {
            System.out.println("ProductRepo::get: productId is null");
        }

        for (Product product : products) {
            if (product.id().equals(productId)) {
                return product;
            }
        }
        System.out.println("ProductRepo::get: product not found: productId = " + productId);
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
}
