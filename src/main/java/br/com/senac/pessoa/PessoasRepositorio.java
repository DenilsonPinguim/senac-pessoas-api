package br.com.senac.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoasRepositorio extends JpaRepository<Pessoas, Long> {
}
