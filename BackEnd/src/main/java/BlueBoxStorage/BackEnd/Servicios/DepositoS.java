package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.DepositoM;
import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Repositorios.DepositoR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepositoS {
    @Autowired(required=false)
    private DepositoR repositorio;

    public List<DepositoM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody DepositoM modelo){
        repositorio.save(modelo);
    }

    public void update(@PathVariable Long id, @RequestBody DepositoM modelo){
        DepositoM actualizado = repositorio.findByIdDeposito(id);
        actualizado.setVolumen(modelo.getVolumen());
        actualizado.setNumero(modelo.getNumero());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteByIdDeposito(id);
    }

    public List<DepositoM> obtenerXzona(Long id) {
        return repositorio.obtenerXzona(id);
    }

    public DepositoM obtenerUltimoAgregado() {
        return repositorio.obtenerUltimoAgregado();
    }
}
