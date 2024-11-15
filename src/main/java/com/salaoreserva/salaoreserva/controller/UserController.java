package com.salaoreserva.salaoreserva.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.salaoreserva.salaoreserva.dto.ReservaDTO;
import com.salaoreserva.salaoreserva.dto.UsuarioDTO;
import com.salaoreserva.salaoreserva.model.Morador;
import com.salaoreserva.salaoreserva.model.Reserva;
import com.salaoreserva.salaoreserva.model.Salao;
import com.salaoreserva.salaoreserva.service.MoradorService;
import com.salaoreserva.salaoreserva.service.ReservaService;
import com.salaoreserva.salaoreserva.service.SalaoService;
import com.salaoreserva.salaoreserva.service.UsuarioService;
import com.salaoreserva.salaoreserva.utils.constants.Routes;

import jakarta.validation.Valid;

@Controller
@RequestMapping(Routes.Users.USERS)
public class UserController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private MoradorService moradorService;

	@Autowired
	private SalaoService salaoService;

	@Autowired
	private ReservaService reservaService;

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("error", "Usuário ou senha inválidos.");
		}

		return "users/login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("usuarioDTO", new UsuarioDTO());

		return "users/register";
	}

	@PostMapping("/register")
	public String registerUser(@Valid UsuarioDTO usuario, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "users/register";
		}

		usuarioService.salvarUsuario(usuario);

		model.addAttribute("message", "Usuario registrado com sucesso!");

		return "users/login";
	}

	@GetMapping("/home")
	public String home() {
		return "users/home";
	}

	@GetMapping("/salao/dias-disponiveis")
	@ResponseBody
	public List<LocalDate> getDiasDisponiveis(@RequestParam("tipoSalao") String tipoSalao) {
		List<LocalDate> dias = salaoService.buscarDiasDisponiveis(tipoSalao);
		return dias;
	}

	@GetMapping("/salao/reserva-salao")
	public String showAgendamentoForm(Model model) {
		model.addAttribute("reservaDTO", new ReservaDTO());

		return "users/salao/reserva-salao";
	}

	@PostMapping("/salao/reservar")
	public String reservarSalao(@ModelAttribute ReservaDTO reservaDTO, Model model, Principal principal) {

		String username = principal.getName();

		Optional<Morador> morador = moradorService.buscarPorUsername(username);

		Morador moradorObj = morador
				.orElseThrow(() -> new IllegalArgumentException("Morador não encontrado para o username: " + username));

		Optional<Salao> salao = salaoService.buscarPorTipoSalao(reservaDTO.getTipoSalao());

		Salao salaoObj = salao.orElseThrow(() -> new IllegalArgumentException(
				"Salão não encontrado para o tipo de salao: " + reservaDTO.getTipoSalao()));

		reservaDTO.setMorador(moradorObj);
		reservaDTO.setSalao(salaoObj);
		salaoService.salvarReserva(reservaDTO);

		model.addAttribute("message", "Reserva realizada com sucesso!");

		return "redirect:/users/salao/reservas";
	}

	@GetMapping("/salao/reservas")
	public String reservas(Model model) {
		List<Reserva> todasReservas = reservaService.buscarTodasReservas();
		model.addAttribute("reservas", todasReservas);
		return "users/salao/reservas";
	}

	@GetMapping("/salao/reservas/buscarPorDia")
	public String buscarPorDia(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
			Model model) {
		List<Reserva> reservasPorDia = reservaService.buscarReservasPordia(data);
		model.addAttribute("reservas", reservasPorDia);
		return "users/salao/reservas";
	}

}
