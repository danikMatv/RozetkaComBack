package org.example.rozetkacom.Repository;

import org.example.rozetkacom.DTO.Category.CategoryResponse;
import org.example.rozetkacom.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c FROM Category c")
    List<Category> getAll();
    CategoryResponse getCategoryById(Long id);
}
