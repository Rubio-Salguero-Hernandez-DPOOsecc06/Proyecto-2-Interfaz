package controller;

import java.io.File;

public class LectorArchivos {
    public LectorArchivos(){

    }

    public void leerArchivoEquiposReales(String pNombreArchivo){
        File rutaEquipos = Persistencia.crearArchivo("data/"+pNombreArchivo);
        if(rutaEquipos.exists()){
            System.out.println("existe");
        }
    }
}
