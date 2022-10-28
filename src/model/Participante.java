package model;

import java.io.Serializable;

public class Participante extends Usuario{
    
    public Participante(String pNombreUsuario, String pClave){
        super(pNombreUsuario, pClave);
    }

    @Override
    public String getNombreUsuario() {
        // TODO Auto-generated method stub
        return super.getNombreUsuario();
    }
    @Override
    public String getClave() {
        // TODO Auto-generated method stub
        return super.getClave();
    }
}
