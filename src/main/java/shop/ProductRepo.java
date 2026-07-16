package shop;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        if (product == null) {
            System.out.println("shop.ProductRepo::add: product is null");
        }
        if (products.contains(product)) {
            System.out.println("shop.ProductRepo::add: This product already exists");
        }
        products.add(product);
        System.out.println("shop.ProductRepo::add: shop.Product added: " + product);
    }

    public void remove(Product product) {
        if (product == null) {
            System.out.println("shop.ProductRepo::remove: product is null");
        }
        if (!products.contains(product)) {
            System.out.println("shop.ProductRepo::remove: This product does not exist: " + product);
        }
        products.remove(product);
        System.out.println("shop.ProductRepo::remove: shop.Product removed: " + product);
    }

    public Product get(Integer productId) {
        if (productId == null) {
            System.out.println("shop.ProductRepo::get: productId is null");
        }

        for (Product product : products) {
            if (product.id().equals(productId)) {
                return product;
            }
        }
        System.out.println("shop.ProductRepo::get: shop.Product not found: productId = " + productId);
        return null;
    }

    public List<Product> get(List<Integer> productIds) {
        if (productIds == null) {
            System.out.println("shop.ProductRepo::get(List): productIds is null");
        }

        List<Product> foundProducts = new ArrayList<>();
        for (Integer productId : productIds) {
            Product product = this.get(productId);
            if (product != null) {
                foundProducts.add(product);
            }
        }

        if (foundProducts.isEmpty()) {
            System.out.println("shop.ProductRepo::get(List): No products found for the specified IDs");
            return null;
        }

        return foundProducts;
    }

    public List<Product> getAll() {
        return products;
    }
}
