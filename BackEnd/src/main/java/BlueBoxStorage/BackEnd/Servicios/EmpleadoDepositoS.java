package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoDepositoM;
import BlueBoxStorage.BackEnd.Repositorios.EmpleadoDepositoR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoDepositoS {
    @Autowired
    private EmpleadoDepositoR repositorio;

    public List<EmpleadoDepositoM> get(Long id_usuario) {
        return repositorio.encontrarXidUsuario(id_usuario);
    }

    public void set(EmpleadoDepositoM cuerpo) {
        repositorio.save(cuerpo);
    }

    public void delete(Long id) {
        repositorio.deleteById(id);
    }
}
