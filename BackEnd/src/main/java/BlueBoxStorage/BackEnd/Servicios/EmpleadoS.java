package BlueBoxStorage.BackEnd.Servicios;

import BlueBoxStorage.BackEnd.Modelos.ClienteM;
import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;
import BlueBoxStorage.BackEnd.Modelos.UsuarioNoAbstract;
import BlueBoxStorage.BackEnd.Repositorios.EmpleadoR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@Service
public class EmpleadoS {
    @Autowired(required=false)
    private EmpleadoR repositorio = new EmpleadoR() {
        @Override
        public List<EmpleadoM> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<EmpleadoM> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends EmpleadoM> S save(S entity) {
            return null;
        }

        @Override
        public <S extends EmpleadoM> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public Optional<EmpleadoM> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public List<EmpleadoM> findAll() {
            return null;
        }

        @Override
        public List<EmpleadoM> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(EmpleadoM entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends EmpleadoM> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends EmpleadoM> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends EmpleadoM> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<EmpleadoM> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public EmpleadoM getOne(Long aLong) {
            return null;
        }

        @Override
        public EmpleadoM getById(Long aLong) {
            return null;
        }

        @Override
        public EmpleadoM getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends EmpleadoM> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends EmpleadoM> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends EmpleadoM> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends EmpleadoM> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends EmpleadoM> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends EmpleadoM> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends EmpleadoM, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }

        @Override
        public EmpleadoM findByNombreUsuario(String nombre_usuario) {
            return null;
        }

        @Override
        public EmpleadoM findByIdUsuario(Long administrador) {
            return null;
        }

        @Override
        public void deleteByIdUsuario(Long id_usuario) {

        }
    };

    public List<EmpleadoM> get(){
        return repositorio.findAll();
    }

    public void set(@RequestBody EmpleadoM modelo){
        EmpleadoM actualizado = new EmpleadoM();
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        actualizado.setAdministrador(modelo.isAdministrador());
        actualizado.setEmpleado(modelo.isEmpleado());
        actualizado.setCodigo(modelo.getCodigo());
        actualizado.setEspecialidad(modelo.getEspecialidad());
        repositorio.save(actualizado);
    }

    public void update(@PathVariable Long id, @RequestBody EmpleadoM modelo){
        EmpleadoM actualizado = repositorio.findByIdUsuario(id);
        actualizado.setNombre(modelo.getNombre());
        actualizado.setDireccion(modelo.getDireccion());
        actualizado.setTelefono(modelo.getTelefono());
        actualizado.setNombreUsuario(modelo.getNombreUsuario());
        actualizado.setClaveUsuario(modelo.getClaveUsuario());
        actualizado.setAdministrador(modelo.isAdministrador());
        actualizado.setEmpleado(modelo.isEmpleado());
        actualizado.setCodigo(modelo.getCodigo());
        actualizado.setEspecialidad(modelo.getEspecialidad());
        repositorio.save(actualizado);
    }

    public void delete(@PathVariable Long id){
        repositorio.deleteByIdUsuario(id);
    }

    public EmpleadoM encontrarXnombreUsuarioEmpleado(String nombre_usuario){
        return repositorio.findByNombreUsuario(nombre_usuario);
    }

    public EmpleadoM encontrarXid(Long id) {
        return repositorio.findByIdUsuario(id);
    }
}
