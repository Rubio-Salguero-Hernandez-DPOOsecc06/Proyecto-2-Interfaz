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

    @Override
    public String getNombreUsuario() {
        return super.getNombreUsuario();
    }
    @Override
    public String getClave() {
        return super.getClave();
    }

}
