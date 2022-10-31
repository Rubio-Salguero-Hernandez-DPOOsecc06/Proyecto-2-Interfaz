package model;

public class Participante extends Usuario{
    private EquipoFantasia equipoAsociado = null;
    private Double presupuestoDisponible = 150.00;

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



}
