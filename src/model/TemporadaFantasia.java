package model;

import java.util.ArrayList;

import controller.Persistencia;

public class TemporadaFantasia extends Temporada{
    ArrayList<EquipoFantasia> equiposTemporada = new ArrayList<>();

    public TemporadaFantasia(){
    }

    
    /** 
     * @return int
     */
    @Override
    public int getNumeroTemporada() {
        return this.numeroTemporada;
    }

    
    /** 
     * @param pNumeroTemporada
     */
    @Override
    public void setNumeroTemporada(int pNumeroTemporada) {
        this.numeroTemporada = pNumeroTemporada;
    }
    
    
    /** 
     * @return ArrayList<EquipoFantasia>
     */
    public ArrayList<EquipoFantasia> getEquiposTemporada() {
        return equiposTemporada;
    }

    
    /** 
     * @param pEquipo
     */
    public void agregarEquipo(EquipoFantasia pEquipo){
        this.equiposTemporada.add(pEquipo);
    }

    
    /** 
     * @param pJugador
     * @param pRendimiento
     * @param pMarcador
     * @param pTemporadaF
     */
    public void actualizarPuntosPorJugador(JugadorReal pJugador, RendimientoJugador pRendimiento, MarcadorPartidoReal pMarcador, TemporadaFantasia pTemporadaF){
        for(EquipoFantasia equipo: pTemporadaF.getEquiposTemporada()){
            equipo.actualizarPuntosEquipoPorJugador(pJugador, pRendimiento, pMarcador);
        }
        Persistencia.guardarTemporadaFantasia(pTemporadaF);
    }
}
