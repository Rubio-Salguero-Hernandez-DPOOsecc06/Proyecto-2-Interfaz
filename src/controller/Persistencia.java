package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Participante;
import model.TemporadaReal;

public class Persistencia {
    
    public Persistencia(){
    }

    public static File crearFichero(String pNombreFichero){
        File fichero = new File(pNombreFichero);
        if(!fichero.exists()){
            fichero.mkdirs();
        }
        return fichero;
    }

    public static File crearArchivo(String pNombreArchivo){
        File archivo = new File(pNombreArchivo);
        return archivo;
    }

    /**
     * guarda un participante que se acaba de registrar
     * @param pParticipanteNuevo
     */
    public static  void guardarParticipante(Participante pParticipanteNuevo){
        try{
            String rutaParticipantes = "persistencia/participantes";
            File ficheroParticipantes = crearFichero(rutaParticipantes);
            String nombreTxt = ficheroParticipantes+"/"+pParticipanteNuevo.getNombreUsuario()+".txt";
            File nuevoArchivo = crearArchivo(nombreTxt);
            if(!nuevoArchivo.exists()){
                ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(nombreTxt));
                escritor.writeObject(pParticipanteNuevo);
                escritor.close();
                System.out.println("\nTe registraste correctamente\n");
            } else{
            System.out.println("\nEste nombre de usuario no esta disponible\n");
            }
        } catch(Exception e){
        }
    }

    /**
     * Verifica que un participante exista en los registros
     * @param pNombreUsuario
     * @param pClave
     * @return
     */
    public static Participante iniciarSesion(String pNombreUsuario, String pClave){
        Participante participanteConfirmado = null;
        try{
            String rutaParticipantes = "persistencia/participantes";
            File ficheroParticipantes = crearFichero(rutaParticipantes);
            String nombreTxt = ficheroParticipantes+"/"+pNombreUsuario+".txt";
            File nuevoArchivo = crearArchivo(nombreTxt);
            if(nuevoArchivo.exists()){
                ObjectInputStream lector = new ObjectInputStream(new FileInputStream(nuevoArchivo));
                Participante participanteRecuperado = (Participante)lector.readObject();
                lector.close();
                if(participanteRecuperado.getClave().equals(pClave)){
                    participanteConfirmado = participanteRecuperado;
                }else{
                    System.out.println("\nClave incorrecta, intenta de nuevo\n");
                }
            }else{
                System.out.println("\nEste participante no existe, intenta registrarte primero\n");
            }
        } catch (Exception e){

        }
        return participanteConfirmado;
    }

    /**
     * Guarda una temporada en el archivo
     * @param pTemporada
     */
    public static void guardarTemporadaReal(TemporadaReal pTemporada){
        try{
            String rutaTemporadas = "persistencia/temporadas reales";
            File ficheroTemporadas = crearFichero(rutaTemporadas);
            String nombreTxt = ficheroTemporadas+"/"+pTemporada+".txt";
            File nuevoArchivo = crearArchivo(nombreTxt);
            if(!nuevoArchivo.exists()){
                ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(nombreTxt));
                escritor.writeObject(pTemporada);
                escritor.close();
                System.out.println("\nSe guardo la temporada\n");
            } else{
            System.out.println("\nLa temporada ya existe\n");
            }
        } catch(Exception e){
        }
    }

    public void recuperarTemporadasReales(){
        
    }
}
