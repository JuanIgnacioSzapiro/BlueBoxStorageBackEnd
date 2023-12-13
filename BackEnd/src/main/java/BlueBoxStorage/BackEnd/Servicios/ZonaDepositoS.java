package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.SucursalZonaM;
import BlueBoxStorage.BackEnd.Modelos.ZonaDepositoM;
import BlueBoxStorage.BackEnd.Repositorios.SucursalZonaR;
import BlueBoxStorage.BackEnd.Repositorios.ZonaDepositoR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ZonaDepositoS {
    @Autowired(required=false)
    private ZonaDepositoR repositorio;

    public void set(ZonaDepositoM modelo){
        repositorio.save(modelo);
    }

    public void delete(Long id) {repositorio.borrarXIdDeposito(id);}
}
