package main.service.implementation;

import main.data.entity.ProductEntity;
import main.data.repository.ProductRepository;
import main.service.ProductHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductHandlingServiceImpl implements ProductHandlingService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductHandlingServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {return productRepository.save(productEntity);}
    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
    @Override
    public ProductEntity buyProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}