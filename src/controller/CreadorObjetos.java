package controller;

import model.*;

public class CreadorObjetos {

    /**
     * Constructor
     */
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
     * Crea una temporada de fantasia
     * @return
     */
    public TemporadaFantasia crearTemporadaFantasia(){
        TemporadaFantasia nuevaTemporadaFantasia = new TemporadaFantasia();
        return nuevaTemporadaFantasia;
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
    /**
     * crea un arquero de fantasia
     * @param pNombre
     * @param pPosicion
     * @param pPrecioCompra
     * @param pEquipoJugador
     * @return
     */
    public JugadorFantasiaArquero crearArquero(String pNombre, Posicion pPosicion, double pPrecioCompra, EquipoReal pEquipoJugador){
        JugadorFantasiaArquero nuevoArquero = new JugadorFantasiaArquero(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
        return nuevoArquero;
    }

    /**
     * Crea un defensa de fantasia
     * @param pNombre
     * @param pPosicion
     * @param pPrecioCompra
     * @param pEquipoJugador
     * @return
     */
    JugadorFantasiaDefensivo crearDefensa(String pNombre, Posicion pPosicion, double pPrecioCompra, EquipoReal pEquipoJugador){
        JugadorFantasiaDefensivo nuevoDefensa = new JugadorFantasiaDefensivo(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
        return nuevoDefensa;
    }
    /**
     * Crea un jugador de fantasia
     * puede ser un delantero o un medio campista
     * @param pNombre
     * @param pPosicion
     * @param pPrecioCompra
     * @param pEquipoJugador
     * @return
     */
    JugadorFantasia crearJugadorFantasia(String pNombre, Posicion pPosicion, double pPrecioCompra, EquipoReal pEquipoJugador){
        JugadorFantasia nuevoJugador = new JugadorFantasia(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
        return nuevoJugador;
    }
    /**
     * Crea una instancia de rendimiento de jugador
     * @param pMinutosJugados
     * @param pMinutoEntrada
     * @param pMinutoSalida
     * @param pGolesAnotados
     * @param pPenaltisAnotados
     * @param pAutogoles
     * @param pAsistencias
     * @param pPenaltisErrados
     * @param pGolesrecibidos
     * @param pPenaltisDetenidos
     * @param pTarjetasAmarillas
     * @param pTarjetasRojas
     * @param pJugador
     * @return
     */
    public RendimientoJugador crearRendimientoJugador(int pMinutosJugados, int pMinutoEntrada, int pMinutoSalida,
    int pGolesAnotados, int pPenaltisAnotados, int pAutogoles, int pAsistencias, int pPenaltisErrados, int pGolesrecibidos, int pPenaltisDetenidos,
    int pTarjetasAmarillas, int pTarjetasRojas, JugadorReal pJugador){
        RendimientoJugador nuevoRendimientoJugador = new RendimientoJugador(pMinutosJugados, pMinutoEntrada, pMinutoSalida, pGolesAnotados, pPenaltisAnotados, pAutogoles, pAsistencias, pPenaltisErrados, pGolesrecibidos, pPenaltisDetenidos, pTarjetasAmarillas, pTarjetasRojas, pJugador);
        return nuevoRendimientoJugador;
    }

    /**
     * Crea una instancia de marcador de partido real
     * @return
     */
    public MarcadorPartidoReal crearMarcadorPartidoReal(){
        MarcadorPartidoReal marcador = new MarcadorPartidoReal();
        return marcador;
    }
}
