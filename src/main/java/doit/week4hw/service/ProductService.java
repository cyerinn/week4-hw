package doit.week4hw.service;

import doit.week4hw.controller.dto.ProductCreateRequest;
import doit.week4hw.controller.dto.ProductResponse;
import doit.week4hw.repository.Product;
import doit.week4hw.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 이게 뭐지
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> findAllProducts(){
        List<Product> products = productRepository.findAll();
        return ProductResponse.from(products);
    }

    public ProductResponse createProduct(ProductCreateRequest request){
        Product newProduct = new Product(request.name(), request.price());

        Product savedProduct = productRepository.save(newProduct);

        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice()
        );
    }

    public ProductResponse findOneProduct(Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. id=" + productId));

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }


}
