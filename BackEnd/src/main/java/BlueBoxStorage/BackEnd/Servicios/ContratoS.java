package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.ContratoM;
import BlueBoxStorage.BackEnd.Repositorios.ContratoR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContratoS {
    @Autowired
    private ContratoR repositorio;

    public List<ContratoM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody ContratoM modelo){
        repositorio.save(modelo);
    }

    public void update(@PathVariable Long id, @RequestBody ContratoM modelo){
        ContratoM actualizado = repositorio.findById(id).get();
        actualizado.setFechaInicio(modelo.getFechaInicio());
        actualizado.setFechaTerminacion(modelo.getFechaTerminacion());
        actualizado.setIdUsuario(modelo.getIdUsuario());
        actualizado.setIdDeposito(modelo.getIdDeposito());
        actualizado.setAprobado(modelo.getAprobado());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }

    public List<ContratoM> obtenerDeIdCliente(Long id_usuario) {
        return repositorio.obtenerDeIdCliente(id_usuario);
    }

    public List<ContratoM> obtenerDeIdEmpleado(Long id_empleado) {
        return repositorio.obtenerDeIdEmpleado(id_empleado);
    }
}
