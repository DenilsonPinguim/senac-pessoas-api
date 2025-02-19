package br.com.senac.pessoa.repositorios;

import br.com.senac.pessoa.entidades.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoasRepositorio extends JpaRepository<Pessoas, Long> {
}
