package ru.gothmog.ws.api.ui.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.gothmog.ws.api.core.model.dto.ProductDTO;

import java.util.List;

@Tag(name = "ProductController", description = "Контроллер продукта")
public interface ProductController {

    @Operation(summary = "Получение продукта по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Продукт найден успешно"),
            @ApiResponse(responseCode = "404", description = "Продукт не обнаружен")
    })
    default ResponseEntity<ProductDTO> getProductById(
            @Parameter(in = ParameterIn.PATH, description = "Id продукта", required = true, example = "12")
            Long productId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Добавление продукта")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Данные успешно добавлены"),
            @ApiResponse(responseCode = "400", description = "Ошибка в запросе")
    })
    default ResponseEntity<ProductDTO> createProduct(@Valid ProductDTO productDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Обновление продукта")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные успешно обновлены"),
            @ApiResponse(responseCode = "404", description = "Продукт не обнаружен")
    })
    default ResponseEntity<ProductDTO> updateProduct(
            @Parameter(in = ParameterIn.PATH, description = "Id продукта", required = true, example = "12")
            Long productId, @Valid ProductDTO productDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Удаление продукта")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Данные успешно удалены"),
            @ApiResponse(responseCode = "404", description = "Данные по указанному ID не найдены")
    })
    default ResponseEntity<Void> deleteProduct( @Parameter(in = ParameterIn.PATH, description = "Id продукта", required = true, example = "12")
                                 Long productId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Получение списка продуктов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные успешно получены")
    })
    default ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
