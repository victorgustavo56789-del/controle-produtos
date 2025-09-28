package br.senac.projeto.controle_produtos.Controller;

import br.senac.projeto.controle_produtos.Model.Produto;
import br.senac.projeto.controle_produtos.Repository.ProdutoRepository;
import br.senac.projeto.controle_produtos.DTO.ProdutoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // LISTAR TODOS
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable int id) {
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ADICIONAR
    @PostMapping
    public Produto adicionarProduto(@RequestBody ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());
        return produtoRepository.save(produto);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable int id, @RequestBody ProdutoDTO dto) {
        return produtoRepository.findById(id)
                .map(p -> {
                    p.setNome(dto.getNome());
                    p.setPreco(dto.getPreco());
                    p.setQuantidade(dto.getQuantidade());
                    return ResponseEntity.ok(produtoRepository.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable int id) {
        return produtoRepository.findById(id)
                .map(p -> {
                    produtoRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
