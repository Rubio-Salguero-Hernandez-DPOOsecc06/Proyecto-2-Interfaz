package model;

import java.util.ArrayList;

import controller.Persistencia;

public class TemporadaFantasia extends Temporada{
    ArrayList<EquipoFantasia> equiposTemporada = new ArrayList<>();

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
    
    public ArrayList<EquipoFantasia> getEquiposTemporada() {
        return equiposTemporada;
    }

    public void agregarEquipo(EquipoFantasia pEquipo){
        this.equiposTemporada.add(pEquipo);
    }

    public void actualizarPuntosPorJugador(JugadorReal pJugador, RendimientoJugador pRendimiento, MarcadorPartidoReal pMarcador, TemporadaFantasia pTemporadaF){
        for(EquipoFantasia equipo: pTemporadaF.getEquiposTemporada()){
            equipo.actualizarPuntosEquipoPorJugador(pJugador, pRendimiento, pMarcador);
        }
        Persistencia.guardarTemporadaFantasia(pTemporadaF);
    }
}
