package productcategoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import productcategoryservice.model.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {
    private String title;
    private int count;
    private double price;
    private Category category;
}
