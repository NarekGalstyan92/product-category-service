package productcategoryservice.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productcategoryservice.dto.CreateCategoryDto;
import productcategoryservice.dto.CreateProductDto;
import productcategoryservice.mapper.ProductMapper;
import productcategoryservice.model.Category;
import productcategoryservice.model.Product;
import productcategoryservice.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductEndpoint {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productMapper.map(productService.productList());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto createProductDto) {
        Product savedProduct = productService.addProduct(productMapper.map(createProductDto));
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProductByID(@PathVariable("id") int id) {
        productService.deleteProductById(id);
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        if (product.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        productService.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getproductById(@PathVariable("id") int id) {
        Optional<Product> byId = productService.findProductById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }
}