package productcategoryservice.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productcategoryservice.dto.CreateCategoryDto;
import productcategoryservice.mapper.CategoryMapper;
import productcategoryservice.model.Category;
import productcategoryservice.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CategoryEndpoint {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryMapper.map(categoryService.categoryList());
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        Category savedCategory = categoryService.addCategory(categoryMapper.map(createCategoryDto));
        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Category> deleteCategoryByID(@PathVariable("id") int id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/categories")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        if (category.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        categoryService.addCategory(category);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
        Optional<Category> byId = categoryService.findCategoryById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

}
