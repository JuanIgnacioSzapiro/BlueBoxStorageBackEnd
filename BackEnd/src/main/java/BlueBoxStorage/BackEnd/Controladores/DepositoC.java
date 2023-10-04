package BlueBoxStorage.BackEnd.Controladores;

import BlueBoxStorage.BackEnd.Modelos.DepositoM;
import BlueBoxStorage.BackEnd.Servicios.DepositoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepositoC {
    @Autowired
    DepositoS servicio;

    @GetMapping("/listar_depositos")
    public List<DepositoM> get(){
        return servicio.get();
    }

    @PostMapping("/guardar_deposito")
    public void post(@RequestBody DepositoM cuerpo){
        servicio.set(cuerpo);
    }

    @PutMapping("/editar_deposito/{id}")
    public void put(@PathVariable Long id, @RequestBody DepositoM cuerpo){
        servicio.update(id, cuerpo);
    }

    @DeleteMapping("/borrar_deposito/{id}")
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }
}
