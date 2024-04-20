package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        
        //creamos el dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelular(celDuenio);
        
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atenEsp);
        masco.setObservacion(observaciones);
        masco.setDuenio(duenio);
        
        controlPersis.guardar(duenio,masco);
        

    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();

    }

    public void borrarMascota(int numCliente) {

            controlPersis.borrarMascota(numCliente);

    }

    

    public Mascota traerMascota(int numCliente) {
        
        return controlPersis.traerMascota(numCliente);

    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {

        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservacion(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atenEsp);
        
        
        //modifico mascota
        controlPersis.modificarMascota(masco);
        
        Duenio duenio=this.buscarDuenio(masco.getDuenio().getId_duenio());
        duenio.setNombre(nombreDuenio);
        duenio.setCelular(celDuenio);
        
        //modifo dueño
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {

        return controlPersis.traerDuenio(id_duenio);
        
    }

    private void modificarDuenio(Duenio duenio) {

        controlPersis.modificarDuenio(duenio);

    }

    
}
