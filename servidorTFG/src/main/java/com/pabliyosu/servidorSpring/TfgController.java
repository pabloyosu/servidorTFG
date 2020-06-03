package com.pabliyosu.servidorSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import javax.swing.text.Caret;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@RestController
public class TfgController {


    //USUARIOS
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Loggin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginDto dto){
        Usuario usuario = usuarioRepository.findUsuarioByEmailAndContrasenia(dto.email,dto.contrasenia);
        if(usuario != null){
            return new ResponseEntity(usuario, HttpStatus.OK);
        }

        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    //Cambiar contraseña
    @RequestMapping(value = "/change_pws", method = RequestMethod.POST)
    public ResponseEntity changePassword(@RequestBody ChangePasswordDto dto){
        Usuario usuario = usuarioRepository.findUsuarioByEmailAndContrasenia(dto.email,dto.contrasenia);
        if(usuario != null){
            usuario.setContrasenia(dto.nuevaContrasenia);
            usuarioRepository.save(usuario);
            return new ResponseEntity(usuario, HttpStatus.OK);
        }

        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    //Obtener lista usuarios
    @RequestMapping("/get_usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios;
    }

    //Obtener usuario
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity fbidUser(@RequestParam(value = "id") int id) {
        Usuario userCreated = usuarioRepository.findOne(id);
        return new ResponseEntity(userCreated, HttpStatus.OK);
    }

    //Postear usuario
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody Usuario user) {
        user.setAdmin(false);
        Usuario userCreated = usuarioRepository.save(user);
        System.out.println("----------------------------------------POST USUARIO");
        return new ResponseEntity(userCreated, HttpStatus.CREATED);
    }

    //Mandar usuario
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody Usuario user) {
        //Inicio prueba
        Usuario usuarioEncontrado = usuarioRepository.findOne(user.getId());
        user.setContrasenia(usuarioEncontrado.getContrasenia());
        user.setAdmin(usuarioEncontrado.isAdmin());
        //fin prueba
        Usuario userCreated = usuarioRepository.save(user);
        return new ResponseEntity(userCreated, HttpStatus.OK);
    }

    //Eliminar usuario
    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@RequestParam (value = "id", defaultValue = "-1") int id) {
        System.out.println("----------------------------------------DELETE USUARIO");
        try{
            usuarioRepository.delete(id);
            return new ResponseEntity(null, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    private Usuario getUsuarioById(int id){
        return usuarioRepository.findOne(id);
    }

    //Cambiar contraseña
    @RequestMapping("/cambiar_contrasenia")
    public void cambiarContrasenia(
            @RequestParam(value = "id", defaultValue = "-1") Integer id,
            @RequestParam(value = "contrasenia", defaultValue = "aaaaaa") String contraseniaUsuario
    ){
        Usuario usuario = usuarioRepository.findOne(id);
        System.out.println(usuario.toString());
        if(usuario!=null){
            usuario.setContrasenia(contraseniaUsuario);
            usuarioRepository.save(usuario);
        }

    }

    //BICICLETAS
    @Autowired
    private BicicletaRepository bicicletaRepository;

    //Obtener lista bicicletas
    @RequestMapping("/get_bicicletas")
    public List<Bicicleta> getBicicletas(){
        List<Bicicleta> bicicletas = bicicletaRepository.findAll();

        return bicicletas;
    }

    //Obtener bicicleta
    @RequestMapping(value = "/bicicletas", method = RequestMethod.GET)
    public ResponseEntity fbidBicicleta(@RequestParam(value = "id") int id) {
        Bicicleta bicicleta = bicicletaRepository.findOne(id);
        return new ResponseEntity(bicicleta, HttpStatus.OK);
    }

    //Postear bicicleta
    @RequestMapping(value = "/bicicletas", method = RequestMethod.POST)
    public ResponseEntity createBicicleta(@RequestBody Bicicleta bici) {
        Bicicleta bicicleta = bicicletaRepository.save(bici);
        return new ResponseEntity(bicicleta, HttpStatus.CREATED);
    }

    //Mandar bicicleta
    @RequestMapping(value = "/bicicletas", method = RequestMethod.PUT)
    public ResponseEntity updateBicicleta(@RequestBody Bicicleta bici) {
        System.out.println(bici.toString());
        Bicicleta bicicleta = bicicletaRepository.save(bici);
        return new ResponseEntity(bicicleta, HttpStatus.OK);
    }

    //Eliminar bicicleta
    @RequestMapping(value = "/bicicletas", method = RequestMethod.DELETE)
    public ResponseEntity deleteBicicleta(@RequestParam (value = "id", defaultValue = "-1") int id) {
        try{
            bicicletaRepository.delete(id);
            return new ResponseEntity(null, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }


    //ESTACIONES
    @Autowired
    private EstacionRepository estacionRepository;

    //Obtener listado estaciones
    @RequestMapping("/get_estaciones")
    public List<Estacion> getEstaciones(){
        List<Estacion> estaciones = estacionRepository.findAll();

        return estaciones;
    }

    //Obtener estaciçón
    @RequestMapping(value = "/estaciones", method = RequestMethod.GET)
    public ResponseEntity fbidEstacion(@RequestParam(value = "id") int id) {
        Estacion estacion = estacionRepository.findOne(id);
        return new ResponseEntity(estacion, HttpStatus.OK);
    }

    //Postear estación
    @RequestMapping(value = "/estaciones", method = RequestMethod.POST)
    public ResponseEntity createEstacion(@RequestBody Estacion est) {
        Estacion estacion = estacionRepository.save(est);
        return new ResponseEntity(estacion, HttpStatus.CREATED);
    }

    //Mandar estación
    @RequestMapping(value = "/estaciones", method = RequestMethod.PUT)
    public ResponseEntity updateEstacion(@RequestBody Estacion est) {
        Estacion estacion = estacionRepository.save(est);
        return new ResponseEntity(estacion, HttpStatus.OK);
    }

    //Eliminar estación
    @RequestMapping(value = "/estaciones", method = RequestMethod.DELETE)
    public ResponseEntity deleteEstacion(@RequestParam (value = "id", defaultValue = "-1") int id) {
        //Usuario deleteUser = usuarioRepository.findAllBy(id);
        try{
        estacionRepository.delete(id);
        return new ResponseEntity(null, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    //CARRERAS
    @Autowired
    private CarreraRepository carreraRepository;

    //Obtener listado carreras
    @RequestMapping("/get_carreras")
    public List<Carrera> getCarreras(){
        List<Carrera> carreras = carreraRepository.findAll();

        return carreras;
    }

    //Postear carreras
    @RequestMapping(value = "/carreras", method = RequestMethod.POST)
    public ResponseEntity addCarrera(@RequestBody UsuarioBicisDto dto){
        Usuario usuario = usuarioRepository.findOne(dto.idUsuario);
        Bicicleta bicicleta = bicicletaRepository.findOne(dto.idBici);

        Carrera carrera = new Carrera();
        carrera.setUsuario(usuario);
        carrera.setBicicleta(bicicleta);
        carrera.setInicio(new Date());
        carrera.setFnl(new Date());
        carrera.setFecha(new Date());
        UsuarioBici usuarioBici = new UsuarioBici();
        usuarioBici.setUsuario(usuario);
        usuarioBici.setBicicleta(bicicleta);
        usuarioBici.setFecha(new Date());
        usuarioBiciRepository.save(usuarioBici);

        if(bicicleta.getEstacion() != null){
            Estacion estacion = bicicleta.getEstacion();
            estacion.setAnclajesDiponibles(estacion.getAnclajesDiponibles()+1);
            estacion.setBicisDisponibles(estacion.getBicisDisponibles()-1);
            estacionRepository.save(estacion);
            bicicleta.setEstacion(null);
            bicicletaRepository.save(bicicleta);
        }

        carreraRepository.save(carrera);
        return new ResponseEntity(carrera, HttpStatus.OK);
    }

    //Mandar carreras
    @RequestMapping(value = "/carreras", method = RequestMethod.PUT)
    public ResponseEntity finalizarCarrera(@RequestBody FinalizarCarreraDto dto){
        Carrera carrera = carreraRepository.findOne(dto.idCarrera);
        Estacion estacion = estacionRepository.findOne(dto.idEstacion);

        if (carrera.getBicicleta().getEstacion() == null){
            carrera.getBicicleta().setEstacion(estacion);
            estacion.setAnclajesDiponibles(estacion.getAnclajesDiponibles()-1);
            estacion.setBicisDisponibles(estacion.getBicisDisponibles()+1);
            estacionRepository.save(estacion);

        }

        if(carrera.getInicio().getTime() == carrera.getFnl().getTime()){
            carrera.setFnl(new Date());
            carrera.setDuracion((int)(carrera.getFnl().getTime() - carrera.getInicio().getTime())/(1000*60));
            carrera.setPrecio((float)(carrera.getDuracion()*0.05));
            carrera.getUsuario().setSaldo(carrera.getUsuario().getSaldo()-carrera.getPrecio());
            System.out.println("------------>" + carrera.getDuracion());
        }

        carreraRepository.save(carrera);
        return new ResponseEntity(carrera, HttpStatus.OK);

    }

    //Obtener carreras por usuario
    @RequestMapping(value ="/get_carreras_usuario", method = RequestMethod.GET)
    public ResponseEntity getCarrerasByUserId (int id){

        Usuario usuario = usuarioRepository.findOne(id);
        if(usuario != null){
            ArrayList<Carrera> carreras = carreraRepository.findByUsuario(usuario);
            return new ResponseEntity(carreras, HttpStatus.OK);
        }else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    //Obtener carreras por bici
    @RequestMapping(value ="/get_carreras_bici", method = RequestMethod.GET)
    public ResponseEntity getCarrerasByBiciId (int id){

        Bicicleta bicicleta = bicicletaRepository.findOne(id);
        if(bicicleta != null){
            ArrayList<Carrera> carreras = carreraRepository.findByBicicleta(bicicleta);
            return new ResponseEntity(carreras, HttpStatus.OK);
        }else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }



    //USUARIOS_BICI
    @Autowired
    private UsuarioBiciRepository usuarioBiciRepository;

}
