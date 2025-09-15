package com.example.crudSpring.projetoCRUD.SERVICE;

import java.util.List;
import java.util.Optional;

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
        return null;


    }



    //SELECT OU INSERTS OU ALTER TABLE OU DELETE

    // SELECT * FROM EMPRESA (SELECT REALIZA LISTAGEM DE DADOS)
    // where nome_empresa = ?
    //retorna todos os dados da empresa (* - tudo da tabela)



    
}
