package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.ZonaM;
import BlueBoxStorage.BackEnd.Repositorios.ZonaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ZonaS {
    @Autowired(required=false)
    private ZonaR repositorio;

    @Autowired(required=false)
    private ZonaDepositoS zonaDepositoS;

    public List<ZonaM> get(){
        return repositorio.findAll();
    }

    public void set(ZonaM modelo){
        repositorio.save(modelo);
    }

    public void update(@PathVariable Long id, @RequestBody ZonaM modelo){
        ZonaM actualizado = repositorio.findByIdZona(id);
        actualizado.setLetra(modelo.getLetra());
        actualizado.setTipo(modelo.getTipo());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteByIdZona(id);
    }

    public List<ZonaM> obtenerXsucursal(Long id) {
        return repositorio.obtenerXsucursal(id);
    }

    public ZonaM obtenerUltimoAgregado(){
        return repositorio.obtenerUltimoAgregado();
    }
}
