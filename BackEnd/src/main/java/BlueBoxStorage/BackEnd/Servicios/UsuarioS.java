package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.UsuarioM;
import BlueBoxStorage.BackEnd.Repositorios.UsuarioR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioS {
    @Autowired
    private UsuarioR repositorio;

    public List<UsuarioM> get(){
        return repositorio.findAll();
    }
}
