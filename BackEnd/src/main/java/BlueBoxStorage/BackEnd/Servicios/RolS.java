package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.RolM;
import BlueBoxStorage.BackEnd.Repositorios.RolR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class RolS {
    @Autowired
    private RolR repositorio;

    public List<RolM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody RolM modelo){
        repositorio.save(modelo);
    }

    public void update(@PathVariable Long id, @RequestBody RolM modelo){
        RolM actualizado = repositorio.findById(id).get();
        actualizado.setAutoridad(modelo.getAutoridad());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteById(id);
    }
}
