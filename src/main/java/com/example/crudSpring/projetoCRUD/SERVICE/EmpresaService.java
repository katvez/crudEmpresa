package com.example.crudSpring.projetoCRUD.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crudSpring.projetoCRUD.ENTITY.Empresa;
import com.example.crudSpring.projetoCRUD.REPOSITORY.EmpresaRepository;

@Service
public class EmpresaService {
    
    private EmpresaRepository empresaRepository;

    //método construtor da Classe EmpresaService
    //criando uma ligação com a Classe EmpressaRepository
    public EmpresaService (EmpresaRepository ligacaoEmpresaRepository){
        empresaRepository = ligacaoEmpresaRepository;
    }

   public List<Empresa> findAll() { 
    return empresaRepository.findAll();
   }//SELECT * FROM EMPRESA

   //object = criar algo no banco
   public Empresa cadastrarEmpresa(Empresa dadosEmpresa){
    return empresaRepository.save(dadosEmpresa);
   }

   //void pq não precisa de retorno
   public void deletarEmpresa(Long id){
    empresaRepository.deleteById(id);
   }

   //realizar a busca de dados no banco usando o id criado na classe
   //option só usa pra retornar numeros
   public Optional<Empresa> buscaPorId(Long id){
    return empresaRepository.findById(id);
   }

   public Empresa editarDadoEmpresa(Long id, Empresa dadosAtualizados){
    
    Empresa empresaBuscada = buscaPorId(id).orElseThrow( 
    () -> new IllegalArgumentException("Empresa não encontrada"));

    empresaBuscada.setNome(dadosAtualizados.getNome());
    empresaBuscada.setCnpj(dadosAtualizados.getCnpj());
    empresaBuscada.setRamo(dadosAtualizados.getRamo());

    return empresaRepository.save(empresaBuscada);
   }

   public List<Empresa> buscarEmpresaPorNome(String nome_empresa){
    return empresaRepository.findByNomeContainingIgnoreCase(nome_empresa);
   }

}

 //select = listar, insert, alter table, delete
    //SELECT * FROM EMPRESA (select realiza listagem de dados)
    //where nome_empresa = ?  
    //ex: SELECT (quais os dados que vc deseja listar) FROM (onde deseja executar o comando)
    //retorna todos os dados da empresa (* - Tudo da tabela)