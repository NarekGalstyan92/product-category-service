package productcategoryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import productcategoryservice.model.Category;
import productcategoryservice.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById(int id) {
        if (id == 0) {
            return categoryRepository.findById(id);
        }
        return null;
    }

    public void deleteCategoryById(int id) {
        if (id > 0) {
            categoryRepository.deleteById(id);
        }
    }

    public Category addCategory(Category category) {
        if (category.getName() != null && category.getId() == 0) {
            category.setName(category.getName());
        }
        categoryRepository.save(category);
        return category;
    }

    public void changeCategory(int id, Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            categoryRepository.save(category);
        }
    }
}
