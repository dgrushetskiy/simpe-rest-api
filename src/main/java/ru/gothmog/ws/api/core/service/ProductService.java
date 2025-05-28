package ru.gothmog.ws.api.core.service;

import ru.gothmog.ws.api.core.model.dto.ProductDTO;

import java.util.List;

/**
 * Сервис для работы с продуктом.
 */
public interface ProductService {

    ProductDTO getProductById(Long id);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    void deleteProduct(Long id);

    List<ProductDTO> getAllProducts();
}
