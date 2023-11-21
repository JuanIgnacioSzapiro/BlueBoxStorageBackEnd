package BlueBoxStorage.BackEnd;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import BlueBoxStorage.BackEnd.Repositorios.EmpleadoR;
import BlueBoxStorage.BackEnd.Repositorios.UsuarioR;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UsuarioR usuarioR, EmpleadoR empleadoR) {
		return args -> {
			if (empleadoR.findByAdministrador(false).isPresent()) return;

			UsuarioNoAbstract administradorCentralU = new UsuarioNoAbstract("admin", "admin");
			EmpleadoM administradorCentralE = new EmpleadoM("admin", "admin", true, true);

			usuarioR.save(administradorCentralU);
			empleadoR.save(administradorCentralE);
		};
	}
/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
			}
		};
	}
	*/
}