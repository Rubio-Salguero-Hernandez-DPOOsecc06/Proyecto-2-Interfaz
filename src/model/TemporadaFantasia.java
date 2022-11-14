package model;

import java.util.ArrayList;

import controller.Persistencia;

public class TemporadaFantasia extends Temporada{
    ArrayList<EquipoFantasia> equiposTemporada = new ArrayList<>();
    /**
     * Constructor
     */
    public TemporadaFantasia(){
    }

    @Override
    public int getNumeroTemporada() {
        return this.numeroTemporada;
    }

    @Override
    public void setNumeroTemporada(int pNumeroTemporada) {
        this.numeroTemporada = pNumeroTemporada;
    }
    /**
     * Retorna una lista con los equipos de fantasia de la temporada
     * @return
     */
    public ArrayList<EquipoFantasia> getEquiposTemporada() {
        return equiposTemporada;
    }
    /**
     * Agrega un equipo de fantasia a la temporada
     * @param pEquipo
     */
    public void agregarEquipo(EquipoFantasia pEquipo){
        this.equiposTemporada.add(pEquipo);
    }
    /**
     * Recorre cada equipo actualizando sus puntos
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
