package br.senac.projeto.controle_produtos.Repository;

import br.senac.projeto.controle_produtos.Model.Produto;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<>();
    private int contadorId = 1;

    // Inicializando alguns produtos
    public ProdutoRepository() {
        save(new Produto(0, "Camiseta", 49.9, 10));
        save(new Produto(0, "Notebook", 3500.0, 3));
        save(new Produto(0, "Caneta", 3.5, 50));
    }

    public List<Produto> findAll() {
        return produtos;
    }

    public Optional<Produto> findById(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst();
    }

    public Produto save(Produto produto) {
        if (produto.getId() == 0) {
            produto.setId(contadorId++);
        }
        produtos.removeIf(p -> p.getId() == produto.getId());
        produtos.add(produto);
        return produto;
    }

    public void deleteById(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }
}
