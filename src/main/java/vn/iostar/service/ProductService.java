package vn.iostar.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vn.iostar.entity.Product;
import vn.iostar.repository.ProductRepo;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    
    public List<Product> getProductsByCategory(int categoryId) {
        return productRepo.findByCategoryId(categoryId);
    }

    public List<Product> getTop10BestSellingProducts() {
        return productRepo.findTop10QuantitySold(PageRequest.of(0, 10));
    }

    public List<Product> getTop10LatestProducts() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        return productRepo.findTop10CreateAt7Days(sevenDaysAgo, PageRequest.of(0,10));
    }
}
