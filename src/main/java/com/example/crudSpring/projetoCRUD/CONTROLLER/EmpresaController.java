package com.example.crudSpring.projetoCRUD.CONTROLLER;

import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.crudSpring.projetoCRUD.ENTITY.Empresa;
import com.example.crudSpring.projetoCRUD.SERVICE.EmpresaService;

import aj.org.objectweb.asm.Attribute;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/empresaCTR")

public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService ligacaoEmpresaService) {
        this.empresaService = ligacaoEmpresaService;
    }

    @GetMapping("/listarTodasEmpresas")
    public String listarEmpresas(Model oModel) {
        oModel.addAttribute("empresas", empresaService.findAll());
        return "listarEmpresas";
    }

    // chamada para listar todas as empresas
    @GetMapping("/viewCadEmpresa")
    public String mostrarFormCadastro(Model model) {

        model.addAttribute("empresa", new Empresa());
        return "cadastroEmpresa";
    }

    @PostMapping("/salvarEmpresa")
    public String salvarEmpresa(@ModelAttribute Empresa objEmpresa) {

        // chamando o métofo cadastrar e passando
        // o objeto ("pacotinho") com os dados que precisam ser salvos
        empresaService.cadastrarEmpresa(objEmpresa);

        return "redirect:/empresaCTR/listarTodasEmpresas";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable("id") Long id, Model oModel) {

        Empresa objEmpresa = empresaService.buscPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));

        oModel.addAttribute("empresaEditar", objEmpresa);
        return "editarEmpresa";

    }

    @PostMapping("/atualizarEmpresa/{id}")
    public String empresaAtualizar(@PathVariable("id") Long id,
            @ModelAttribute Empresa objEmpresaAtualizada) {

        empresaService.editarDadosEmpresa(id, objEmpresaAtualizada);

        return "redirect:/empresaCTR/listarTodasEmpresas";
    }

    @GetMapping("/deletarEmpresa/{id}")
    public String apagarEmpresa(@PathVariable("id") Long id) {

        empresaService.deletarEmpresa(id);

        return "redirect:/empresaCTR/listarTodasEmpresas";

    }

}
