package productcategoryservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import productcategoryservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
