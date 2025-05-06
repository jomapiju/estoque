package com.javastore.estoque.service;

import com.javastore.estoque.jpa.entity.EstoqueEntity;
import com.javastore.estoque.jpa.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<EstoqueEntity> findByProdutoId(Long produtoId) { return estoqueRepository.findByProdutoId(produtoId); }

    public void save(EstoqueEntity estoque) { estoqueRepository.save(estoque); }

    public void repor(Integer quantidade, Long id) {
        EstoqueEntity exist = estoqueRepository.findById(id).orElseThrow();
        Integer saldo = exist.getQuantidade()+quantidade;
        exist.setQuantidade(saldo);
        estoqueRepository.save(exist);
    }

    public void vender(Integer quantidade, Long id) {
        EstoqueEntity exist = estoqueRepository.findById(id).orElseThrow();
        Integer saldo = exist.getQuantidade()-quantidade;
        exist.setQuantidade(saldo);
        estoqueRepository.save(exist);
    }

    public void deleteById(Long id) {
        estoqueRepository.deleteById(id);
    }
}
