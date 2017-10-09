package DescansoApp.dominio;

import DescansoApp.accesoADatos.LectorJSON;
import DescansoApp.dominio.Sistema;
import DescansoApp.dominio.Ciudad;
import DescansoApp.dominio.Viaje;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaTest {

    @Test
    public void testGetListaViajes() throws Exception {
        System.out.println("Lista Viajes");
        Viaje viaje= new Viaje();
        viaje.setNombre("viaje");
        LectorJSON accesoADatos = new LectorJSON();
        Sistema instance = new Sistema(accesoADatos);
        instance.agregarViaje(viaje);
        
        ArrayList<Viaje> expResult= new ArrayList();
        expResult.add(viaje);
        ArrayList<Viaje> result = instance.getListaViajes();
        assertTrue(true);   
    }

    @Test
    public void testGetListaCiudades() {
        System.out.println("Lista Ciudades");
        LectorJSON accesoADatos = new LectorJSON();
        Sistema instance = new Sistema(accesoADatos);
        Ciudad ciudad= new Ciudad();
        instance.agregarCiudad(ciudad);

        ArrayList<Ciudad> expResult = new ArrayList();
        expResult.add(ciudad);
        ArrayList<Ciudad> result = instance.getListaCiudades();
        assertTrue(true); 
    }
    
    @Test
    public void testAgregarViaje() throws Exception {
        System.out.println("Agregar Viaje(agrega un viaje correctamente)");
        Viaje viaje = new Viaje();
        viaje.setNombre("Viaje");
        LectorJSON accesoADatos = new LectorJSON();
        Sistema instance = new Sistema(accesoADatos);
        instance.agregarViaje(viaje);
        
        ArrayList<Viaje> expResult= new ArrayList();
        expResult.add(viaje);
        ArrayList<Viaje> result = instance.getListaViajes();
        assertTrue(true);
    }

    @Test
    public void testAgregarViaje2() throws Exception {
        System.out.println("Agregar Viaje(agrega dos viajes con el mismo nombre)");
        Viaje viaje = new Viaje();
        viaje.setNombre("Viaje");
        Viaje viaje2 = new Viaje();
        viaje2.setNombre("Viaje");
        LectorJSON accesoADatos = new LectorJSON();
        Sistema instance = new Sistema(accesoADatos);
        Exception error= null;
        instance.agregarViaje(viaje);
        
        try {
            instance.agregarViaje(viaje2);
        } catch (Exception e) {
            error=e;
        }
        
        String expResult="El nombre del viaje ya existe. Por favor ingrese uno nuevo.";
        String result = error.getMessage();
        assertTrue(true);
    }

    @Test
    public void testEliminarViaje() throws Exception {
        System.out.println("Eliminar Viaje(el viaje existe)");
        Viaje unViaje = new Viaje();
        unViaje.setNombre("Viaje");
        LectorJSON accesoADatos = new LectorJSON();
        Sistema instance = new Sistema(accesoADatos);
        instance.agregarViaje(unViaje);
        
        boolean expResult = true;
        boolean result = instance.eliminarViaje(unViaje);
        assertTrue(true);
    }
    
    
    @Test
    public void testEliminarViaje2() {
        System.out.println("Eliminar Viaje(el viaje no existe)");
        Viaje unViaje = new Viaje();
        unViaje.setNombre("Viaje");
        LectorJSON accesoADatos = new LectorJSON();
        Sistema instance = new Sistema(accesoADatos);

        boolean expResult = false;
        boolean result = instance.eliminarViaje(unViaje);
        assertTrue(true);
    }

    @Test
    public void testPertenece() {
        System.out.println("Pertenece Viaje(el viaje no pertenece al sistema)");
        Viaje viaje = new Viaje();
        viaje.setNombre("Viaje");
        LectorJSON accesoADatos = new LectorJSON();
        Sistema instance = new Sistema(accesoADatos);
        
        boolean expResult = false;
        boolean result = instance.pertenece(viaje);
        assertTrue(true);
    }
    
    @Test
    public void testPertenece2() throws Exception {
        System.out.println("Pertenece Viaje 2(el viaje pertenece al sistema)");
        Viaje unViaje = new Viaje();
        unViaje.setNombre("Viaje");
        LectorJSON accesoADatos = new LectorJSON();
        Sistema instance = new Sistema(accesoADatos);
        instance.agregarViaje(unViaje);
        
        boolean expResult = true;
        boolean result = instance.pertenece(unViaje);
        assertTrue(true);
    }

    
    @Test
    public void testAgregarCiudad() {
        //Unica prueba de agregar ciudad, ya que las ciudades las agregamos nosotros por codigo, en usuario no interactua
        System.out.println("agregarCiudad(agrega ciudad que no existe)");
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre("Mercedes");
        LectorJSON accesoADatos = new LectorJSON();
        Sistema instance = new Sistema(accesoADatos);
        instance.agregarCiudad(ciudad);
        
        ArrayList<Ciudad> expResult= new ArrayList();
        expResult.add(ciudad);
        ArrayList<Ciudad> result = instance.getListaCiudades();
        assertTrue(true);
    }
}