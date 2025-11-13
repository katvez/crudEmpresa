package com.example.crudSpring.projetoCRUD.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionario")
@NoArgsConstructor
@Getter
@Setter

public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false, unique=true)
    private Long codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "salario", nullable = false, length=20)
    private double salario;

    @Column(name = "cargo", nullable = false, length=100)
    private String cargo;

    @ManyToOne
    //cria a chave estrangeira
    @JoinColumn(name = "empresaID", nullable = false)
    private Empresa identificadorEmpresa;

    public Funcionario(Long codigo, String nome, double salario, String cargo, Empresa identificadorEmpresa) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
        this.identificadorEmpresa = identificadorEmpresa;
    }

    


   
}
