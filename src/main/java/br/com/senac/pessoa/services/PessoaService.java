package br.com.senac.pessoa.services;

import br.com.senac.pessoa.entidades.Pessoas;
import br.com.senac.pessoa.repositorios.PessoasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PessoaService {

    private PessoasRepositorio pessoasRepositorio;
    /*
    public PessoaService(PessoasRepositorio pessoasRepositorio){
        this.pessoasRepositorio = pessoasRepositorio;
    }
    */

    public Pessoas criarPessoa(Pessoas pessoa){
        try {

            Pessoas pessoasResult = pessoasRepositorio.save(pessoa);

            return pessoasResult;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());

        }
    }
}
