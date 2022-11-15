package model;

public class Administrador extends Usuario {
    
    /**
     * Se crea una instancia de administrador
     * @param pNombreUsuario
     * @param pClave
     */
    public Administrador(String pNombreUsuario, String pClave){
        super(pNombreUsuario, pClave);
    }

    
    /** 
     * @return String
     */
    @Override
    public String getNombreUsuario() {
        return super.getNombreUsuario();
    }
    
    /** 
     * @return String
     */
    @Override
    public String getClave() {
        return super.getClave();
    }

}
