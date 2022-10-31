package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.EquipoReal;
import model.JugadorReal;
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
                linea = lector.readLine();
                while(linea != null){
                    EquipoReal nuevoEquipo = pCreador.crearEquipoReal(linea);
                    pTemporada.agregarEquipo(nuevoEquipo);
                    linea = lector.readLine();
                }
                lector.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("No se encontro el archivo");
        }
    }

    /**
     * Lee el archivo de jugadores reales 
     * @param pNombreArchivo
     * @param pTemoprada
     * @param pCreador
     */
    public void leerArchivoJugadoresReales(String pNombreArchivo, TemporadaReal pTemoprada, CreadorObjetos pCreador){
        File rutaJugadores = Persistencia.crearArchivo("data/"+pNombreArchivo);
        if(rutaJugadores.exists()){
            try {
                BufferedReader lector = new BufferedReader(new FileReader(rutaJugadores));
                String linea;
                linea = lector.readLine();
                linea = lector.readLine();
                while(linea != null){
                    String[] datosJugador = linea.split(";");
                    String nombreJugador = datosJugador[0];
                    String posicionJugador = datosJugador[2];
                    Double precioCompra = Double.parseDouble(datosJugador[3]);
                    EquipoReal equipoJugador = pTemoprada.buscarEquipo(datosJugador[1]);
                    JugadorReal nuevoJugadorReal = pCreador.crearJugadorReal(nombreJugador, posicionJugador, precioCompra, equipoJugador);
                    equipoJugador.agregarJugador(nuevoJugadorReal);
                    linea = lector.readLine();
                }
                lector.close();
                Persistencia.guardarTemporadaReal(pTemoprada);
            } catch (Exception e) {
            }
        }
    }


}
