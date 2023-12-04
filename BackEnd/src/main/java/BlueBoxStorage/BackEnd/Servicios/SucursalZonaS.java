package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.SucursalZonaM;
import BlueBoxStorage.BackEnd.Repositorios.SucursalZonaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class SucursalZonaS {
    @Autowired
    private SucursalZonaR repositorio;

    public void set(SucursalZonaM modelo){
        repositorio.save(modelo);
    }

    public void delete(@PathVariable Long id){
        repositorio.borrarXIdZona(id);
    }
}
