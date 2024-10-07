package org.example.rozetkacom.Controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rozetkacom.DTO.Category.CategoryRequest;
import org.example.rozetkacom.DTO.Category.CategoryResponse;
import org.example.rozetkacom.Entity.Category;
import org.example.rozetkacom.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        return categoryService.createNewCategory(categoryRequest);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryRequest categoryRequest) {
        return categoryService.updateCategory(id, categoryRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}

