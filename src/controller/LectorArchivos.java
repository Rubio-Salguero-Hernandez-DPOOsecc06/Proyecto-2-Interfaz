package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.*;


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
                    String posicionJugador1 = datosJugador[2];
                    Double precioCompra = Double.parseDouble(datosJugador[3]);
                    EquipoReal equipoJugador = pTemoprada.buscarEquipo(datosJugador[1]);
                    Posicion posicionJugador = null;
                    switch (posicionJugador1) {
                        case "arquero":
                            posicionJugador = Posicion.ARQUERO;
                            break;
                        case "delantero":
                            posicionJugador = Posicion.DELANTERO;
                            break;
                        case "medio":
                            posicionJugador = Posicion.MEDIO;
                            break;
                        case "defensa":
                            posicionJugador = Posicion.DEFENSA;
                            break;
                        default:
                            break;
                    }
                    JugadorReal nuevoJugadorReal = pCreador.crearJugadorReal(nombreJugador, posicionJugador, precioCompra, equipoJugador);
                    equipoJugador.agregarJugador(nuevoJugadorReal);
                    linea = lector.readLine();
                }
                lector.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Lee el archivo de los partidos programados en una temporada
     * @param pNombreArchivo
     * @param pTemoprada
     * @param pCreador
     */
    public void leerArchivoFechasReales(String pNombreArchivo, TemporadaReal pTemoprada, CreadorObjetos pCreador){
        File rutaFechas = Persistencia.crearArchivo("data/"+pNombreArchivo);
        if(rutaFechas.exists()){
            try {
                BufferedReader lector = new BufferedReader(new FileReader(rutaFechas));
                String linea;
                linea = lector.readLine();
                linea = lector.readLine();
                while(linea != null){
                    String[] datosPartido = linea.split(";");
                    int fecha = Integer.parseInt(datosPartido[0]);
                    String diaPartido = datosPartido[1];
                    String horaPartido = datosPartido[2];
                    EquipoReal equipoLocal = pTemoprada.buscarEquipo(datosPartido[3]);
                    EquipoReal equipoVisitante = pTemoprada.buscarEquipo(datosPartido[4]);
                    Fecha fechaPartido = pTemoprada.buscarFecha(fecha);
                    if(fechaPartido == null){
                        fechaPartido = pCreador.crearFecha(fecha);
                        pTemoprada.agregarFecha(fechaPartido);
                    }
                    PartidoReal nuevoPartidoReal = pCreador.crearPartidoReal(equipoLocal, equipoVisitante, diaPartido, horaPartido);
                    fechaPartido.agregarPartido(nuevoPartidoReal);
                    linea = lector.readLine();
                }
                lector.close();
                Persistencia.guardarTemporadaReal(pTemoprada);
            } catch (Exception e) {
            }
        }
    }
}
