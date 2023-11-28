package br.com.seteideias.consumer.controller;

import br.com.seteideias.consumer.model.ProdutoComPreco;
import br.com.seteideias.consumer.service.PrecoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private PrecoProdutoService precoProdutoService;

    @GetMapping("/get")
    public ResponseEntity<ProdutoComPreco> get () {
        return ResponseEntity.ok(precoProdutoService.obterPorCodigo(1L));
    }

}
