package br.com.senac.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoasRepositorio pessoasRepositorio;

    @GetMapping("/")
    public ResponseEntity<List<Pessoas>> carregarPessoas() throws Exception {
        try {
            List<Pessoas> pessoasList = pessoasRepositorio.findAll();

            if(pessoasList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(pessoasList);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<Pessoas> criarPessoa(@RequestBody Pessoas pessoa) throws Exception {
        try {
            Pessoas pessoasResult = pessoasRepositorio.save(pessoa);

            return ResponseEntity.ok(pessoasResult);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoas> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoas pessoa) throws Exception {
        try {
            if(!pessoasRepositorio.existsById(id)) throw new Exception("Registro não encontrado");

            pessoa.setId(id);
            Pessoas pessoasResult = pessoasRepositorio.save(pessoa);

            return ResponseEntity.ok(pessoasResult);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable Long id) throws Exception {
        try {
            if(!pessoasRepositorio.existsById(id)) throw new Exception("Registro não encontrado");

            pessoasRepositorio.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
