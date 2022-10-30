package productcategoryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import productcategoryservice.model.Product;
import productcategoryservice.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> productList() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(int id) {
        if (id == 0) {
            return productRepository.findById(id);
        }
        return null;
    }

    public void deleteProductById(int id) {
        if (id > 0) {
            productRepository.deleteById(id);
        }
    }

    public Product addProduct(Product product) {
        if (product.getTitle() != null && product.getId() == 0) {
            product.setTitle("unknown");
        }
        productRepository.save(product);
        return product;
    }

    public void changeProduct(int id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            productRepository.save(product);
        }
    }
}
