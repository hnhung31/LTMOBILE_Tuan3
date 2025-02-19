package vn.iostar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
