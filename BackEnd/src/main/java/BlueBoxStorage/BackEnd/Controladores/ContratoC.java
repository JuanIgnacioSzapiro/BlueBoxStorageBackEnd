package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.ContratoM;
import BlueBoxStorage.BackEnd.Servicios.ContratoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContratoC {
    @Autowired
    ContratoS servicio;

    @GetMapping("/listar_contratos")
    public List<ContratoM> get(){
        return servicio.get();
    }

    @PostMapping("/guardar_contrato")
    public void post(@RequestBody ContratoM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/editar_contrato/{id}")
    public void put(@PathVariable Long id, @RequestBody ContratoM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/borrar_contrato/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
