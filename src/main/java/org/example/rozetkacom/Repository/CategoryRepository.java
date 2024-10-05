package org.example.rozetkacom.Repository;

import org.example.rozetkacom.DTO.Category.CategoryResponse;
import org.example.rozetkacom.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    CategoryResponse getCategoryById(Long id);
}
