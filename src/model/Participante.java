package model;

public class Participante extends Usuario{
    /**
     * Constructor
     * @param pNombreUsuario
     * @param pClave
     */
    public Participante(String pNombreUsuario, String pClave){
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
