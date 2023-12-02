package BlueBoxStorage.BackEnd;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Repositorios.EmpleadoR;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(EmpleadoR empleadoR) {
		return args -> {
			if (empleadoR.findByIdUsuario(Long.valueOf(1)).isPresent()) return;

			EmpleadoM administradorCentralE = new EmpleadoM("admin", "admin", true, true);

			empleadoR.save(administradorCentralE);
		};
	}
}