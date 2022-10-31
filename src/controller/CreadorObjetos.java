package controller;

import model.*;

public class CreadorObjetos {

    public CreadorObjetos(){
    }

    /**
     * Crea un nuevo participante
     * @param pNombreUsuario
     * @param pClave
     * @return
     */
    public Participante crearParticipante(String pNombreUsuario, String pClave){
        Participante nuevoParticipante = new Participante(pNombreUsuario, pClave);
        Persistencia.guardarParticipante(nuevoParticipante);
        return nuevoParticipante;
    }

    /**
     * crea una temporada real
     * @return
     */
    public TemporadaReal crearTemporadaReal(){
        TemporadaReal nuevaTemporadaReal = new TemporadaReal();
        return nuevaTemporadaReal;
    }

    /**
     * Crea un equipo real
     * @param pNombreEquipo
     * @return
     */
    public EquipoReal crearEquipoReal(String pNombreEquipo){
        EquipoReal nuevoEquipoReal = new EquipoReal(pNombreEquipo);
        return nuevoEquipoReal;
    }

    /**
     * Crea un jugador real
     * @param pNombre
     * @param pPosicion
     * @param pPrecioCompra
     * @param pEquipoJugador
     * @return
     */
    public JugadorReal crearJugadorReal(String pNombre, Posicion pPosicion, double pPrecioCompra, Equipo pEquipoJugador){
        JugadorReal nuevoJugadorReal = new JugadorReal(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
        return nuevoJugadorReal;
    }

    /**
     * Crea una fecha
     * @param pNumeroFecha
     * @return
     */
    public Fecha crearFecha(int pNumeroFecha){
        Fecha nuevaFecha = new Fecha(pNumeroFecha);
        return nuevaFecha;
    }

    /**
     * Crea un partido real
     * @param pLocal
     * @param pVisitante
     * @param pDia
     * @param pHora
     * @return
     */
    public PartidoReal crearPartidoReal(EquipoReal pLocal, EquipoReal pVisitante, String pDia, String pHora){
        PartidoReal nuevoPartidoReal = new PartidoReal(pLocal, pVisitante, pDia, pHora);
        return nuevoPartidoReal;
    }

    /**
     * Crea un equipo de fantasia
     * @param pNombre
     * @return
     */
    public EquipoFantasia crearEquipoFantasia(String pNombre){
        EquipoFantasia nuevoEquipoFantasia = new EquipoFantasia(pNombre);
        return nuevoEquipoFantasia;
    }
    public JugadorFantasiaArquero crearArquero(String pNombre, Posicion pPosicion, double pPrecioCompra, EquipoReal pEquipoJugador){
        JugadorFantasiaArquero nuevoArquero = new JugadorFantasiaArquero(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
        return nuevoArquero;
    }

    JugadorFantasiaDefensivo crearDefensa(String pNombre, Posicion pPosicion, double pPrecioCompra, EquipoReal pEquipoJugador){
        JugadorFantasiaDefensivo nuevoDefensa = new JugadorFantasiaDefensivo(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
        return nuevoDefensa;
    }

    JugadorFantasia crearJugadorFantasia(String pNombre, Posicion pPosicion, double pPrecioCompra, EquipoReal pEquipoJugador){
        JugadorFantasia nuevoJugador = new JugadorFantasia(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
        return nuevoJugador;
    }
}
