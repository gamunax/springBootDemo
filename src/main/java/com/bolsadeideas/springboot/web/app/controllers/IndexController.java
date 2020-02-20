package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index", "/", "", "home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework");
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jan Pierre");
		usuario.setApellido("Sanchez");
		usuario.setEmail("gamunaxx@gmail.com");
		model.addAttribute("user", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andres", "Sanchez", "jsanchez@correo.com"));
		usuarios.add(new Usuario("Jan", "Flores", "jflores@correo.com"));
		usuarios.add(new Usuario("Maria", "Urrutia", "murrutia@correo.com"));
		return usuarios;
	}
	
	
}
