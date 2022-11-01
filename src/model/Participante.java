package model;

import controller.Menu;

public class Participante extends Usuario{
    private EquipoFantasia equipoAsociado = null;
    private Double presupuestoDisponible = 20000.00;

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
    
    /**
     * Retorna el equipos asociado del participante
     * @return
     */
    public EquipoFantasia getEquipoAsociado() {
        return equipoAsociado;
    }
    
    /**
     * Asocia un equipo de fantasia al participante
     * @param pEquipoAsociado
     */
    public void setEquipoAsociado(EquipoFantasia pEquipoAsociado) {
        this.equipoAsociado = pEquipoAsociado;
    }
    
    /**
     * Retorna el presupuesto disponible del participante
     * @return
     */
    public Double getPresupuestoDisponible() {
        return presupuestoDisponible;
    }
    
    /**
     * Resta una cantidad pagada al presupuesto disponible
     * @param pCantidadPagada
     */
    public void restarCompra(Double pCantidadPagada){
        this.presupuestoDisponible -= pCantidadPagada;
    }
    
    /**
     * Agrega una cantidad recibida al presupuesto disponible
     * @param pCantidadRecibida
     */
    public void sumarVenta(Double pCantidadRecibida){
        this.presupuestoDisponible += pCantidadRecibida;
    }
    
    public boolean verificarCompra(JugadorFantasia pJugador){
        Boolean verificado = false;
        if(this.presupuestoDisponible >= pJugador.getPrecioCompra()){
            verificado = true;
        }
        return verificado;
    }

    /**
     * Realiza el proceso de compra de un arquero
     * @param pMenu
     * @return
     */
    public JugadorFantasiaArquero comprarArquero(Menu pMenu){
        JugadorFantasiaArquero arqueroComprado = null;
        EquipoReal equipoSeleccionado = pMenu.imprimirEquiposTemporada();
        JugadorFantasiaArquero ArqueroSeleccionado = pMenu.mostrarMenuCompraArquero(equipoSeleccionado);
        boolean condicion1 = verificarCompra(ArqueroSeleccionado);
        boolean condicion2 = equipoAsociado.verificarDisponibilidad(ArqueroSeleccionado);
        if(condicion1 && condicion2){
            arqueroComprado = ArqueroSeleccionado;
            restarCompra(ArqueroSeleccionado.getPrecioCompra());
        }else{
            System.out.println("\nNo te alcanzo para este jugador o ya lo tienes en tu equipo\n");
        }
        return arqueroComprado;
    }

    /**
     * Realiza el proceso de compra de un defensa
     * @param pMenu
     * @return
     */
    public JugadorFantasiaDefensivo comprarDefensa(Menu pMenu){
        JugadorFantasiaDefensivo defensaComprado = null;
        EquipoReal equipoSeleccionado = pMenu.imprimirEquiposTemporada();
        JugadorFantasiaDefensivo defensaSeleccionado = pMenu.mostrarMenuCompraDefensa(equipoSeleccionado);
        boolean condicion1 = verificarCompra(defensaSeleccionado);
        boolean condicion2 = equipoAsociado.verificarDisponibilidad(defensaSeleccionado);
        if(condicion1 && condicion2){
            defensaComprado = defensaSeleccionado;
            restarCompra(defensaSeleccionado.getPrecioCompra());
        } else{
            System.out.println("\nNo te alcanzo para este jugador o ya lo tienes en tu equipo\n");
        }
        return defensaComprado;
    }

    /**
     * Realiza el proceso de compra de un delantero
     * @param pMenu
     * @return
     */
    public JugadorFantasia comprarDelantero(Menu pMenu){
        JugadorFantasia delanteroComprado = null;
        EquipoReal equipoSeleccionado = pMenu.imprimirEquiposTemporada();
        JugadorFantasia delanteroSeleccionado = pMenu.mostrarMenuCompraDelantero(equipoSeleccionado);
        boolean condicion1 = verificarCompra(delanteroSeleccionado);
        boolean condicion2 = equipoAsociado.verificarDisponibilidad(delanteroSeleccionado);
        if(condicion1 && condicion2){
            delanteroComprado = delanteroSeleccionado;
            restarCompra(delanteroSeleccionado.getPrecioCompra());
        }else{
            System.out.println("\nNo te alcanzo para este jugador o ya lo tienes en tu equipo\n");
        }
        return delanteroComprado;
    }

    /**
     * Realiza el proceso de compra de un medio campista
     * @param pMenu
     * @return
     */
    public JugadorFantasia comprarMedio(Menu pMenu){
        JugadorFantasia medioComprado = null;
        EquipoReal equipoSeleccionado = pMenu.imprimirEquiposTemporada();
        JugadorFantasia medioSeleccionado = pMenu.mostrarMenuCompraMedio(equipoSeleccionado);
        boolean condicion1 = verificarCompra(medioSeleccionado);
        boolean condicion2 = equipoAsociado.verificarDisponibilidad(medioSeleccionado);
        if(condicion1 && condicion2){
            medioComprado = medioSeleccionado;
            restarCompra(medioSeleccionado.getPrecioCompra());
        }else{
            System.out.println("\nNo te alcanzo para este jugador o ya lo tienes en tu equipo\n");
        }
        return medioComprado;
    }
}
