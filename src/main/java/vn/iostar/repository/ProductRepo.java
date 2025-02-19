package vn.iostar.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iostar.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	 	List<Product> findByCategoryId(int categoryId);

	    // Lấy 10 sản phẩm bán chạy nhất
	    @Query("SELECT p FROM Product p ORDER BY p.quantitySold DESC")
	    List<Product> findTop10QuantitySold(Pageable pageable);

	    // Lấy 10 sản phẩm được tạo trong vòng 7 ngày gần nhất
	    @Query("SELECT p FROM Product p WHERE p.createAt >= :sevenDaysAgo ORDER BY p.createAt DESC")
	    List<Product> findTop10CreateAt7Days(@Param("sevenDaysAgo") LocalDateTime sevenDaysAgo, Pageable pageable);
}
