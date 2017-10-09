/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DescansoApp.accesoADatos;

import DescansoApp.IAccesoADatos;
import DescansoApp.dominio.Ciudad;
import DescansoApp.dominio.ComercioActividad;
import DescansoApp.herramientas.TipoCA;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Agustin
 */
public class LectorJSON implements IAccesoADatos {

    @Override
    public ArrayList<Ciudad> cargarCiudades() {
        String filePath = "src/DescansoApp/ciudades.json";
        JSONObject jsonObject = ParsearArchivoJSON(filePath);
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        try {
            ciudades = obtenerCiudadesDeJSONObject(jsonObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ciudades;
    }
    
    private JSONObject ParsearArchivoJSON(String path) {
        JSONObject jsonObject = null;
        try {
            FileReader reader = new FileReader(path);
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(reader);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return jsonObject;
    }
    
    private ArrayList<Ciudad> obtenerCiudadesDeJSONObject(JSONObject jsonObject) throws Exception {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        try {
            JSONArray ciudadesJson = (JSONArray) jsonObject.get("ciudades");
            for(int i=0; i < ciudadesJson.size(); i++) { // Loop over each each row
                JSONObject ciudadJSON = (JSONObject) ciudadesJson.get(i);
                Ciudad ciudad = CrearCiudadDeJSONObject(ciudadJSON);
                ciudades.add(ciudad);
            }
        } catch (Exception e) {
            throw new Exception("JSON con errores de formato.");
        }
        return ciudades;
    }
    
    private Ciudad CrearCiudadDeJSONObject(JSONObject ciudadJSON) {
        String nombre = (String)ciudadJSON.get("nombre");
        String informacion = (String)ciudadJSON.get("info");
        String descripcion = (String)ciudadJSON.get("descripcion");
        Ciudad ciudad = new Ciudad(nombre, informacion);
        ciudad.setDescripcion(descripcion);
        JSONArray imagenes = (JSONArray) ciudadJSON.get("rutas");
        for(int i=0; i < imagenes.size(); i++) { 
            String imagen = (String) imagenes.get(i);
            ciudad.agregarImagen(imagen);
        }
        JSONArray lugares = (JSONArray) ciudadJSON.get("lugares");
        for(int i=0; i < lugares.size(); i++) { 
            JSONObject lugarJSON = (JSONObject) lugares.get(i);
            ComercioActividad lugar = CrearLugarDeJSONObject(lugarJSON);
            ciudad.agregarComercioActividad(lugar.getTipo(), lugar);
        }
        return ciudad;
    }
    
    private ComercioActividad CrearLugarDeJSONObject(JSONObject lugarJSON) {
        String nombre = (String) lugarJSON.get("nombre");
        String detalles = (String) lugarJSON.get("nombre");
        String unTipo = (String) lugarJSON.get("tipo");
        TipoCA tipo = TipoCA.valueOf(unTipo);
        String categoria = (String) lugarJSON.get("categoria");
        String horario = (String) lugarJSON.get("horario");
        String ubicacion = (String) lugarJSON.get("ubicacion");
        String telefono = (String) lugarJSON.get("telefono");
        String web = (String) lugarJSON.get("web");
        String precio = (String) lugarJSON.get("precio");
        
        ComercioActividad lugar = new ComercioActividad(nombre, detalles, tipo, categoria, horario, ubicacion, telefono, web, precio);
        return lugar;
    }
    
}
