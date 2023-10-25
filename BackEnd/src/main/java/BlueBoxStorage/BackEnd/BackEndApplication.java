package BlueBoxStorage.BackEnd;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Modelos.RolM;
import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import BlueBoxStorage.BackEnd.Repositorios.EmpleadoR;
import BlueBoxStorage.BackEnd.Repositorios.RolR;
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
	CommandLineRunner runner(RolR rolR, UsuarioR usuarioR, EmpleadoR empleadoR) {
		return args -> {
			if (rolR.findByAutoridad("ADMINISTRADOR").isPresent()) return;

			RolM administrador = rolR.save(new RolM("ADMINISTRADOR"));
			RolM empleado = rolR.save(new RolM("EMPLEADO"));
			RolM cliente = rolR.save(new RolM("CLIENTE"));
			RolM pendiente = rolR.save(new RolM("PENDIENTE"));

			Set<RolM> roles = new HashSet<>();
			roles.add(empleado);
			roles.add(administrador);

			UsuarioNoAbstract administradorCentralU = new UsuarioNoAbstract("admin", "admin", roles);
			EmpleadoM administradorCentralE = new EmpleadoM("admin", "admin", roles);

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