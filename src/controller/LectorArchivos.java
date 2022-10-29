package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.EquipoReal;
import model.TemporadaReal;

public class LectorArchivos {

    public LectorArchivos(){

    }
    /**
     * lee el archivo de equipos reales
     * @param pNombreArchivo
     * @param pTemporada
     * @param pCreador
     */
    public void leerArchivoEquiposReales(String pNombreArchivo, TemporadaReal pTemporada, CreadorObjetos pCreador){
        File rutaEquipos = Persistencia.crearArchivo("data/"+pNombreArchivo);
        if(rutaEquipos.exists()){
            try {
                BufferedReader lector = new BufferedReader(new FileReader(rutaEquipos));
                String linea;
                linea = lector.readLine();
                while(linea != null){
                    EquipoReal nuevoEquipo = pCreador.crearEquipoReal(linea);
                    pTemporada.agregarEquipo(nuevoEquipo);
                    linea = lector.readLine();
                }
                Persistencia.guardarTemporadaReal(pTemporada);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("No se encontro el archivo");
        }
    }
}
