package DescansoApp.dominio;

import DescansoApp.IAccesoADatos;
import java.io.Serializable;
import java.util.*;

public class Sistema  implements Serializable{
    private ArrayList<Viaje> listaViajes;
    private ArrayList<Ciudad> listaCiudades;
    private IAccesoADatos accesoADatos;
    
    public Sistema(IAccesoADatos unAccesoADatos){
        listaViajes = new ArrayList<>();
        listaCiudades = new ArrayList<>();
        accesoADatos = unAccesoADatos;
        listaCiudades = accesoADatos.cargarCiudades();
    }

    public ArrayList<Viaje> getListaViajes() {
        return listaViajes;
    }

    public ArrayList<Ciudad> getListaCiudades() {
        return listaCiudades;
    }
    
     public void agregarViaje(Viaje unViaje)throws Exception{
        if (listaViajes.indexOf(unViaje) != -1){
            throw new Exception("El nombre del viaje ya existe. Por favor ingrese uno nuevo.");
        } 
        listaViajes.add(unViaje);
        
    }
    
    public boolean eliminarViaje(Viaje unViaje){
        return listaViajes.remove(unViaje);
    }
    
    public boolean pertenece(Viaje unViaje){
      return listaViajes.contains(unViaje);
    }
    
    public void agregarCiudad(Ciudad unaCiudad){
        listaCiudades.add(unaCiudad);
    }
}
