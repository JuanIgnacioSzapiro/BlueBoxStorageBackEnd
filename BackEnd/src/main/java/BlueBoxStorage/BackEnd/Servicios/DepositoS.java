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
    @Autowired
    private DepositoR repositorio;

    public List<DepositoM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody DepositoM modelo){
        repositorio.save(modelo);
    }

    public void update(@PathVariable Long id, @RequestBody DepositoM modelo){
        DepositoM actualizado = repositorio.findById(id).get();
        actualizado.setVolumen(modelo.getVolumen());
        actualizado.setNumero(modelo.getNumero());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }

    public List<DepositoM> encontrarDepositosXIdZona(Long id) {
        return repositorio.encontrarDepositosXIdZona(id);
    }
}
