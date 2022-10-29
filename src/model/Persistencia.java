package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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

    public static void iniciarSesion(){

    }
}
