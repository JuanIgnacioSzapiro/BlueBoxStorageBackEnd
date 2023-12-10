package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.SucursalZonaM;
import BlueBoxStorage.BackEnd.Repositorios.SucursalZonaR;
import BlueBoxStorage.BackEnd.Repositorios.ZonaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class SucursalZonaS {
    @Autowired
    private SucursalZonaR repositorio;

    @Autowired
    private ZonaS zonaS;

    public void set(SucursalZonaM modelo){
        repositorio.save(modelo);
    }

    public void borrarXIdZona(@PathVariable Long id){
        repositorio.borrarXIdZona(id);
    }
}
