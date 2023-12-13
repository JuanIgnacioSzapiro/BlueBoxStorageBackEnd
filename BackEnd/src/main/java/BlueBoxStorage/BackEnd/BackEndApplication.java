package BlueBoxStorage.BackEnd;

import BlueBoxStorage.BackEnd.ManejoArchivos.Archivo;
import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Repositorios.EmpleadoR;
import BlueBoxStorage.BackEnd.Servicios.EmpleadoS;
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
	CommandLineRunner runner(EmpleadoS empleadoS) {
		return args -> {

			Archivo archivo = new Archivo();

			if (empleadoS.encontrarXid(Long.valueOf(1)) != null) return;

			EmpleadoM administradorCentralE = new EmpleadoM(archivo.Emplear().getNombreUsuario(), archivo.Emplear().getClaveUsuario(), true, true);

			empleadoS.set(administradorCentralE);
		};
	}
}