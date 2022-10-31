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
    /**
     * Crea un fichero en la direccion indicada
     * @param pNombreFichero
     * @return
     */
    public static File crearFichero(String pNombreFichero){
        File fichero = new File(pNombreFichero);
        if(!fichero.exists()){
            fichero.mkdirs();
        }
        return fichero;
    }

    /**
     * crea un archivo de tipo File
     * @param pNombreArchivo
     * @return
     */
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
            String nombreTxt = ficheroParticipantes+"/"+pParticipanteNuevo.getNombreUsuario()+".obj";
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
            String nombreTxt = ficheroParticipantes+"/"+pNombreUsuario+".obj";
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
            String[]temporadas = ficheroTemporadas.list();
            int cantidadTemporadas = temporadas.length;
            pTemporada.setNumeroTemporada((cantidadTemporadas+1));
            String nombreTxt = ficheroTemporadas+"/"+pTemporada.getNumeroTemporada()+ ".obj";
            File nuevoArchivo = crearArchivo(nombreTxt);
            if(!nuevoArchivo.exists()){
                ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(nombreTxt));
                System.out.println("\nSe guardo la temporada\n");
                escritor.writeObject(pTemporada);
                escritor.close();
            } else{
            System.out.println("\nLa temporada ya existe\n");
            }
        } catch(Exception e){
        }
    }

    public static void recuperarTemporadaReal(App pAplicacion){
        try{
            String rutaTemporadas = "persistencia/temporadas reales";
            File ficheroTemporadas = crearFichero(rutaTemporadas);
            String[]temporadas = ficheroTemporadas.list();
            if(temporadas.length >  0){
                for(String temporada: temporadas){
                    String rutaTemporada = rutaTemporadas+"/"+temporada;
                    File nuevoArchivo = crearArchivo(rutaTemporada);
                    if(nuevoArchivo.exists()){
                        ObjectInputStream lector = new ObjectInputStream(new FileInputStream(rutaTemporada));
                        TemporadaReal temporadaRecuperada = (TemporadaReal) lector.readObject();
                        pAplicacion.agregarTemporada(temporadaRecuperada);
                        System.out.println(temporadaRecuperada.getNumeroTemporada());
                        lector.close();                   
                    }                    
                }  
            }
        }catch(Exception e){

        }
    }
}
