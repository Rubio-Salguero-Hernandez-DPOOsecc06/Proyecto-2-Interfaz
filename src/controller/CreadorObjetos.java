package controller;

import model.*;

public class CreadorObjetos {

    public CreadorObjetos(){
    }

    /**
     * Crea un nuevo participante
     * @param pNombreUsuario
     * @param pClave
     * @return
     */
    public Participante crearParticipante(String pNombreUsuario, String pClave){
        Participante nuevoParticipante = new Participante(pNombreUsuario, pClave);
        Persistencia.guardarParticipante(nuevoParticipante);
        return nuevoParticipante;
    }
}
