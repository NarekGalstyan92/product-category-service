package productcategoryservice.mapper;

import org.mapstruct.Mapper;
import productcategoryservice.dto.CategoryResponseDto;
import productcategoryservice.dto.CreateCategoryDto;
import productcategoryservice.dto.CreateProductDto;
import productcategoryservice.dto.ProductResponseDto;
import productcategoryservice.model.Category;
import productcategoryservice.model.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product map(CreateProductDto createProductDto);

    ProductResponseDto map(Product product);

    List<Product> map(List<Product> productList);
}
