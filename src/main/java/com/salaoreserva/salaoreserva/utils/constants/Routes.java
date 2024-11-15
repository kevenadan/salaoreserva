package com.salaoreserva.salaoreserva.utils.constants;

public class Routes {

	public static final String BASE_PATH = "/salao-reserva";
	
	private Routes(){}
	
	
	public static class Users {
		
		// Base rotas para Usuários e administradores
		public static final String USERS = "/users";
		public static final String ADMIN = "/admin"; 
	    
	    // Rotas para usuários (moradores)
	    public static final String LOGIN = USERS + "/login";               
	    public static final String REGISTER = USERS + "/register";         
	    public static final String ME = USERS + "/me";   
	    public static final String SALAO_DIAS_DISPONIVEIS = USERS + "/salao/dias-disponiveis";
	    public static final String SALAO_BUSCA_PDIA = USERS + "/salao/reservas/buscarPorDia";
	    public static final String RESERVAS = USERS + "/salao/reservas";
	    public static final String RESERVAR = USERS + "/salao/reservar"; 

	    // Rotas para administradores
	    public static final String ADMIN_USERS = ADMIN + "/users";       
	    public static final String ADMIN_DASHBOARD = ADMIN + "/dashboard"; 
	    
	 // Frontpage para cada usuário
 		public static final String FRONTPAGE_USER = USERS + "/home";
 		public static final String FRONTPAGE_ADMIN = ADMIN  + "/home";
	}
	
	public static class Resource {
		public static final String CSS = "/css/**";
		public static final String FONTS = "/fonts/**";
		public static final String IMAGES = "/img/**";
		public static final String JS = "/js/**";
			
	}
	
	public static class Erro {
		public static final String ERROR_TRUE = "?error=true";
		public static final String LOGIN_ERROR = Users.LOGIN + ERROR_TRUE;
		
	}
	
}
