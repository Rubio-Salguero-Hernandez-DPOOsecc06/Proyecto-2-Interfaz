package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Fecha implements Serializable{
    
    int numeroFecha;
    ArrayList<PartidoReal> cronogramaPartidosFecha = new ArrayList<>();

    /**
     * Constructor
     * @param pNumeroFecha
     */
    public Fecha(int pNumeroFecha){
        this.numeroFecha = pNumeroFecha;
    }

    /**
     * retorna el numero de la fecha
     * @return
     */
    public int getNumeroFecha() {
        return numeroFecha;
    }

    /**
     * Retorna la lista de partido en la fecha
     * @return
     */
    public ArrayList<PartidoReal> getCronogramaPartidosFecha() {
        return cronogramaPartidosFecha;
    }

    /**
     * Agrega un nuevo partido al cronograma de la fecha
     * @param pNuevoPartido
     */
    public void agregarPartido(PartidoReal pNuevoPartido){
        this.cronogramaPartidosFecha.add(pNuevoPartido);
    }

    
    /** 
     * @param pLocal
     * @param pVisitante
     * @return PartidoReal
     */
    public PartidoReal buscarPartido(EquipoReal pLocal, EquipoReal pVisitante){
        PartidoReal partidoBuscado = null;
        String nombreLocal = pLocal.getNombreEquipo();
        String nombreVisitante = pVisitante.getNombreEquipo();
        for(PartidoReal partido: this.cronogramaPartidosFecha){
            String local = partido.getEquipoLocal().getNombreEquipo();
            String visitante = partido.getEquipoVisitante().getNombreEquipo();
            if(nombreLocal.equals(local) && nombreVisitante.equals(visitante)){
                partidoBuscado = partido;
                break;
            }
        }
        return partidoBuscado;
    }

    /**
     * Muestra cada partido de la fecha con sus equipos, dia y hora
     */
    public void mostrarCronogramaFecha(){
        for(PartidoReal partido: this.getCronogramaPartidosFecha()){
            String nombreLocal = partido.getEquipoLocal().getNombreEquipo();
            String nombreVisitante = partido.getEquipoVisitante().getNombreEquipo();
            String diaPartido = partido.getDia();
            String horaPartido = partido.getHora();
            System.out.println(nombreLocal + " vs " + nombreVisitante);
            System.out.println("Local: " + nombreLocal + " Visitante: " + nombreVisitante);
            System.out.println("Hora: " + horaPartido + " Dia: " + diaPartido);
            System.out.println("--------------------------------------------------------------------");
        }
    }
}
