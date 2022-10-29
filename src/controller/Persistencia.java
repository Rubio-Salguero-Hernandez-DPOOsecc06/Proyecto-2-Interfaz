package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Participante;

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
}
