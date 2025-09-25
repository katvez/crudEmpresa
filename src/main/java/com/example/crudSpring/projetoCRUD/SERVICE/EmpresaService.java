package com.example.crudSpring.projetoCRUD.SERVICE;

import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.internal.DDLFormatterImpl;
import org.springframework.stereotype.Service;

import com.example.crudSpring.projetoCRUD.ENTITY.Empresa;
import com.example.crudSpring.projetoCRUD.REPOSITORY.EmpresaRepository;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository ligacaoEmpresaRepository){

        empresaRepository = ligacaoEmpresaRepository;
    }

    public List<Empresa> findAll() {

        return empresaRepository.findAll();
        //select * from empresa                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
    }

    public Empresa cadastrarEmpresa(Empresa dadosEmpresa){
        return empresaRepository.save(dadosEmpresa);
    }

    public void deletarEmpresa(Empresa dadosEmpresa){
        empresaRepository.delete(dadosEmpresa);
    }
    //realizar a busca de dados no banco usando o id
    //criado da classe
    public Optional<Empresa> buscPorId(Long id){
        return empresaRepository.findById(id);
    }

    public Empresa editarDadosEmpresa(Long id, Empresa dadosAtualizados){
        
        Empresa empresaBuscada= buscPorId(id).orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
        
        empresaBuscada.setNome(dadosAtualizados.getNome());
        empresaBuscada.setCnpj(dadosAtualizados.getCnpj());
        empresaBuscada.setRamo(dadosAtualizados.getRamo());

        return empresaRepository.save(empresaBuscada);
    }

    public List<Empresa>buscarEmpresaPorNome(String nome_empresa){

        return empresaRepository.findByNomeContainingIgnoreCase(nome_empresa);
    }


    }



    //SELECT OU INSERTS OU ALTER TABLE OU DELETE

    // SELECT * FROM EMPRESA (SELECT REALIZA LISTAGEM DE DADOS)
    // where nome_empresa = ?
    //retorna todos os dados da empresa (* - tudo da tabela)



    

