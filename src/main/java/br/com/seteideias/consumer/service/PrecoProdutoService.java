package br.com.seteideias.consumer.service;

import br.com.seteideias.consumer.model.ProdutoComPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class PrecoProdutoService {

    @Autowired
    private WebClient webClientProdutos;

    @Autowired
    private WebClient webClientPrecos;

    public ProdutoComPreco obterPorCodigo(Long codigoProduto){

        Mono<ProdutoComPreco> produtoSemPrecoMono = this.webClientProdutos.method(HttpMethod.GET)
                .uri("/produtos/{codigoProduto}", codigoProduto)
                .retrieve()
                .bodyToMono(ProdutoComPreco.class);

        Mono<ProdutoComPreco> comPrecoMono = this.webClientPrecos.method(HttpMethod.GET)
                .uri("/produto/{codigoProduto}/preco", codigoProduto)
                .retrieve()
                .bodyToMono(ProdutoComPreco.class);

        //esse cara fica esperando
        //produtoSemPrecoMono.subscribe(x-> System.out.println("FINALIZOU DE VERDADE .: "+x.nome()));


        ProdutoComPreco produtoSemPreco = produtoSemPrecoMono.block();
        ProdutoComPreco produtoComPreco = comPrecoMono.block();

        Long codigo = produtoSemPreco.codigo();
        String nome = produtoSemPreco.nome();
        BigDecimal preco = produtoComPreco.preco();

        ProdutoComPreco mashUp = new ProdutoComPreco(codigo, nome, preco);

        return mashUp;
    }

}
