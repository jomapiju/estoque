package com.javastore.estoque.jpa.repository;

import com.javastore.estoque.jpa.entity.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {
    List<EstoqueEntity> findByProdutoId(Long produtoId);
}
