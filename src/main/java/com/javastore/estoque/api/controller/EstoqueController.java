package com.javastore.estoque.api.controller;

import com.javastore.estoque.jpa.entity.EstoqueEntity;
import com.javastore.estoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "estoqueController")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @GetMapping("produtoId/{produtoId}")
    public ResponseEntity<?> findById(@PathVariable(name = "produtoId") Long produtoId) {
        return ResponseEntity.status(HttpStatus.OK).body(estoqueService.findByProdutoId(produtoId));
    }

    @PreAuthorize("hasRole('gerente')")
    @PostMapping("")
    public ResponseEntity<Void> createEstoque(@RequestBody EstoqueEntity estoque) {
        estoqueService.save(estoque);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('gerente')")
    @PutMapping("{id}/repor/{quantidade}")
    public ResponseEntity<Void> save(@PathVariable Integer quantidade, @PathVariable Long id) {
        estoqueService.repor(quantidade, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('gerente')")
    @PutMapping("{id}/vender/{quantidade}")
    public ResponseEntity<Void> vender(@PathVariable Integer quantidade, @PathVariable Long id) {
        estoqueService.vender(quantidade, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
