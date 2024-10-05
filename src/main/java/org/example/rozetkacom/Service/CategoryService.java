package org.example.rozetkacom.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.rozetkacom.DTO.Category.CategoryRequest;
import org.example.rozetkacom.DTO.Category.CategoryResponse;
import org.example.rozetkacom.Entity.Category;
import org.example.rozetkacom.Exeptions.NotFoundException;
import org.example.rozetkacom.Mapper.CategoryMapper;
import org.example.rozetkacom.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional
    public Category createNewCategory(CategoryRequest categoryRequest){
        Category category = categoryMapper.mapToCategory(categoryRequest);
        return categoryRepository.save(category);
    }

    public CategoryResponse getCategoryById(Long id){
        return  categoryRepository.getCategoryById(id);
    }

    @Transactional
    public CategoryResponse updateCategory(Long id,CategoryRequest categoryRequest){
        Category categoryToUpdate = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found by id: " + id));
        categoryMapper.updateCategoryFromRequest(categoryRequest,categoryToUpdate);
        return categoryMapper.mapToCategoryResponse(categoryRepository.save(categoryToUpdate));
    }

    @Transactional
    public boolean deleteCategoryById(Long id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        else return false;
    }

}
