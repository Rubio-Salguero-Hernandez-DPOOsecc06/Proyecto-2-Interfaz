package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.*;


public class LectorArchivos {

    /**
     * Constructor
     */
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

    public void leerResultadoPartido(String pNombreArchivo, TemporadaReal pTemporada, PartidoReal pPartido , TemporadaFantasia pTemporadaFantasia,CreadorObjetos pCreador){
        File rutaResultados = Persistencia.crearArchivo("data/"+pNombreArchivo);
        if(rutaResultados.exists()){
            try {  
                String nombreLocal = pPartido.getEquipoLocal().getNombreEquipo();
                String nombreVisitante = pPartido.getEquipoVisitante().getNombreEquipo();
                MarcadorPartidoReal marcador = pCreador.crearMarcadorPartidoReal();
                BufferedReader lector = new BufferedReader(new FileReader(rutaResultados));
                String linea;
                linea = lector.readLine();
                linea = lector.readLine();
                while(linea != null){
                    String[] datos = linea.split(";");
                    String nombreJugador = datos[0];
                    String equipo = datos[1];
                    int minutosJugados = Integer.parseInt(datos[3]);
                    int minutoEntrada = Integer.parseInt(datos[4]);
                    int minutoSalida = Integer.parseInt(datos[5]);
                    int golesAnotados = Integer.parseInt(datos[6]);
                    int penaltisAnotados = Integer.parseInt(datos[7]);
                    int autogoles = Integer.parseInt(datos[8]);
                    int asistencias = Integer.parseInt(datos[9]);
                    int penaltisErrados = Integer.parseInt(datos[10]);
                    int golesRecibidos = Integer.parseInt(datos[11]);
                    int penaltisDetenidos = Integer.parseInt(datos[12]);
                    int amarillas = Integer.parseInt(datos[13]);
                    int rojas = Integer.parseInt(datos[14]);
                    RendimientoJugador nuevoRendimiento = null;
                    
                    JugadorReal jugador = null;
                    if(nombreLocal.equals(equipo)){
                        jugador = pPartido.getEquipoLocal().buscarJugador(nombreJugador);
                    }
                    else if(nombreVisitante.equals(equipo)){
                        jugador = pPartido.getEquipoVisitante().buscarJugador(nombreJugador);
                    }
                    nuevoRendimiento = pCreador.crearRendimientoJugador(minutosJugados, minutoEntrada, minutoSalida, golesAnotados, penaltisAnotados, autogoles, asistencias, penaltisErrados, golesRecibidos, penaltisDetenidos, amarillas, rojas, jugador);
                    if(equipo.equals(nombreLocal)){
                        marcador.agregarGolLocal(golesAnotados);
                        marcador.agregarGolLocal(penaltisAnotados);
                        marcador.agregarRendimientoLocal(nuevoRendimiento);
                        pPartido.getEquipoLocal().buscarJugador(nombreJugador).agregarRendimiento(nuevoRendimiento);
                        System.out.println("local");
                    }
                    else if(equipo.equals(nombreVisitante)){
                        marcador.agregarGolVisitante(golesAnotados);
                        marcador.agregarGolVisitante(penaltisAnotados);
                        marcador.agregarRendimientoVisitante(nuevoRendimiento);
                        pPartido.getEquipoVisitante().buscarJugador(nombreJugador).agregarRendimiento(nuevoRendimiento);
                        System.out.println("visitante");
                    }
                    pTemporadaFantasia.actualizarPuntosPorJugador(jugador, nuevoRendimiento, marcador);
                    linea = lector.readLine();
                }
                if(marcador.getGolesLocal() > marcador.getGolesVisitante()){
                    marcador.setGanador(pPartido.getEquipoLocal());
                } else if(marcador.getGolesLocal() > marcador.getGolesVisitante()){
                    marcador.setGanador(pPartido.getEquipoVisitante());
                }
                pPartido.setMarcador(marcador);
                Persistencia.guardarTemporadaReal(pTemporada);
                lector.close();
                
            } catch (Exception e) {
            }
        }
    }
}
