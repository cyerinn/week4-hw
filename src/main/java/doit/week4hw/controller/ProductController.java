package doit.week4hw.controller;

import doit.week4hw.controller.dto.ProductCreateRequest;
import doit.week4hw.controller.dto.ProductResponse;
import doit.week4hw.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping("/products")
    public ProductResponse createNewProduct(@RequestBody ProductCreateRequest request){
        return productService.createProduct(request);
    }

    @GetMapping("/products/{productId}")
    public ProductResponse getOneProduct(@PathVariable Long productId){
        return productService.findOneProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public ProductResponse updateOneProduct(@PathVariable Long productId, @RequestBody ProductCreateRequest request){
        return productService.updateProduct(productId, request);
    }

    @DeleteMapping("/products/{productId}")
    public ProductResponse deleteOneProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }
}
