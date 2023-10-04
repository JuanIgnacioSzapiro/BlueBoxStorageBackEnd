package BlueBoxStorage.BackEnd;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Modelos.RolM;
import BlueBoxStorage.BackEnd.Repositorios.EmpleadoR;
import BlueBoxStorage.BackEnd.Repositorios.RolR;
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
	CommandLineRunner runner(RolR rolR, EmpleadoR empleadoR) {
		return args -> {
			if (rolR.findByAutoridad("ADMINISTRADOR").isPresent()) return;

			RolM administrador = rolR.save(new RolM("ADMINISTRADOR"));
			RolM empleado = rolR.save(new RolM("EMPLEADO"));
			RolM cliente = rolR.save(new RolM("CLIENTE"));
			RolM pendiente = rolR.save(new RolM("PENDIENTE"));

			Set<RolM> roles = new HashSet<>();
			roles.add(empleado);
			roles.add(administrador);

			EmpleadoM administradorCentral = new EmpleadoM(0L, "admin", "admin", roles);

			empleadoR.save(administradorCentral);
		};
	}
}