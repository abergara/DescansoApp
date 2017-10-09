/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DescansoApp;

import DescansoApp.dominio.Ciudad;
import java.util.ArrayList;

/**
 *
 * @author Agustin
 */
public interface IAccesoADatos {
    public ArrayList<Ciudad> cargarCiudades();
    
}
