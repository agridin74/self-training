package com.finance.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
