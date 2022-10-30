package productcategoryservice.mapper;

import org.mapstruct.Mapper;
import productcategoryservice.dto.CategoryResponseDto;
import productcategoryservice.dto.CreateCategoryDto;
import productcategoryservice.model.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category map(CreateCategoryDto createCategoryDto);

    CategoryResponseDto map(Category category);

    List<Category> map(List<Category> categoryList);
}
