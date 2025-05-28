package ru.gothmog.ws.api.core.mapper;

import org.mapstruct.Mapper;
import ru.gothmog.ws.api.core.model.entity.Product;
import ru.gothmog.ws.api.core.model.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}
