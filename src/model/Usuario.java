package model;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
    private String nombreUsuario, clave;

    /**
     * Constructor de un objeto de tipo Usuario
     * @param pNombreusuario
     * @param pClave
     */
    public Usuario(String pNombreusuario, String pClave ){
        this.nombreUsuario = pNombreusuario;
        this.clave = pClave;
    }

    /**
     * retorna el nombre de usuario 
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    /**
     * retorna la clave
     * @return
     */
    public String getClave() {
        return clave;
    }
}
