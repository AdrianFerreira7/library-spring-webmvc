package br.com.bpkedu.library_spring_webmvc.controller;

import br.com.bpkedu.library_spring_webmvc.domain.Usuarios;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<Usuarios> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/listar";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute Usuarios usuario) {
        usuarioService.salvarUsuario(usuario);  // Salva no banco de dados
        return "redirect:/usuario/listar";  // Redireciona para a página de lista de usuários
    }

    @GetMapping("/novo")
    public  String formularioNovoUsuario(Model model){
        model.addAttribute("usuarios",new Usuarios());
        return "usuarios/novo";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarUsuario(@PathVariable("id") Long id, Model model) {
        Usuarios usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario == null) {

            return "redirect:/usuario/listar";
        }
        model.addAttribute("usuario", usuario);
        return "usuarios/editar";
    }

    // Atualizar usuário
    @PostMapping("/atualizar/{id}")
    public String atualizarUsuario(@PathVariable("id") Long id, @ModelAttribute Usuarios usuario) {
        usuario.setId(id); // Garante que o id seja mantido
        usuarioService.salvarUsuario(usuario);  // Salva o usuário no banco de dados
        return "redirect:/usuario/listar";  // Redireciona para a lista de usuários após salvar
    }

    // Deletar usuário
    @GetMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable("id") Long id) {
        usuarioService.deletarUsuario(id);
        return "redirect:/usuario/listar";
    }

}
