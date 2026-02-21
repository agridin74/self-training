package com.finance.service;
import com.finance.model.Category;
import com.finance.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails){
        Category category = categoryRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Category не найден id: "+id));
        category.setName(categoryDetails.getName());
        category.setType(categoryDetails.getType());
        return categoryRepository.save(category);    
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
