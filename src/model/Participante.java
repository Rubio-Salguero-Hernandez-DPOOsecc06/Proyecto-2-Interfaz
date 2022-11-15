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

    
    /** 
     * @return String
     */
    @Override
    public String getNombreUsuario() {
        return super.getNombreUsuario();
    }
    
    
    /** 
     * @return String
     */
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
    
    
    /** 
     * @param pJugador
     * @return boolean
     */
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

    /**
     * Permite al participante vender un arquero
     * @param pMenu
     * @param pParticipante
     * @param pEquipo
     * @param pArquero
     * @return
     */
    public JugadorFantasia venderArquero(Menu pMenu, Participante pParticipante, EquipoFantasia pEquipo, JugadorFantasiaArquero pArquero){
        JugadorFantasia arqueroNuevo = null;
        String nombreArqueroVender = pArquero.getNombre();
        JugadorFantasiaArquero arqueroTitular = pEquipo.getArqueroTitular();
        JugadorFantasiaArquero arqueroSustituto = pEquipo.getArqueroSustituto();
        String nombreArqueroTitular = pEquipo.getArqueroTitular().getNombre();
        String nombreArqueroSustituto = pEquipo.getArqueroSustituto().getNombre();
        double precioVentaArquero = pArquero.getPrecioVenta();

        if(nombreArqueroVender.equals(nombreArqueroTitular)){
            sumarVenta(precioVentaArquero);
            while(arqueroNuevo == null){
                arqueroNuevo = comprarArquero(pMenu);
            }
            pEquipo.getJugadores().remove(arqueroTitular);
            pEquipo.getJugadores().add(arqueroNuevo);
            pEquipo.setArqueroTitular((JugadorFantasiaArquero)arqueroNuevo);
        }
        else if(nombreArqueroVender.equals(nombreArqueroSustituto)){
            sumarVenta(precioVentaArquero);
            while(arqueroNuevo == null){
                arqueroNuevo = comprarArquero(pMenu);
            }
            pEquipo.getJugadores().remove(arqueroSustituto);
            pEquipo.getJugadores().add(arqueroNuevo);
            pEquipo.setArqueroSustituto((JugadorFantasiaArquero)arqueroNuevo);
        }
        return arqueroNuevo;
    }

    /**
     * Permite al participante vender un delantero
     * @param pMenu
     * @param pParticipante
     * @param pEquipo
     * @param pDelantero
     * @return
     */
    public JugadorFantasia venderDelantero(Menu pMenu, Participante pParticipante, EquipoFantasia pEquipo, JugadorFantasia pDelantero){
        JugadorFantasia delanteroComprado = null;
        JugadorFantasia delanteroRetirar = null;
        JugadorFantasia delanteroSustituto = pEquipo.getDelanteroSustituto();
        String nombreDelanteroSustituto = pEquipo.getArqueroTitular().getNombre();
        String nombreDelanteroVendido = pDelantero.getNombre();
        double precioVentaDelanteroVendido = pDelantero.getPrecioVenta();

        if (nombreDelanteroVendido.equals(nombreDelanteroSustituto)) {
            sumarVenta(precioVentaDelanteroVendido);
            while(delanteroComprado == null){
                delanteroComprado = comprarDelantero(pMenu);
                delanteroRetirar = delanteroSustituto;
            }
            pEquipo.getJugadores().remove(delanteroSustituto);
            pEquipo.getJugadores().add(delanteroComprado);
            pEquipo.setDelanteroSustituto(delanteroComprado);
        } else {
            for(JugadorFantasia delantero: pEquipo.getDelanterosTitulares()){
                if(delantero.getNombre().equals(nombreDelanteroVendido)){
                    sumarVenta(precioVentaDelanteroVendido);
                    while(delanteroComprado == null){
                        delanteroComprado = comprarDelantero(pMenu);
                        delanteroRetirar = delantero;
                    }
                }
            }
            pEquipo.getDelanterosTitulares().remove(delanteroRetirar);
            pEquipo.agregarDelanteroTitular(delanteroComprado);
            pEquipo.getJugadores().remove(delanteroRetirar);
            pEquipo.getJugadores().add(delanteroComprado);
        }
        return delanteroComprado;
    }

    /**
     * Permite al participante vender un medio campista
     * @param pMenu
     * @param pParticipante
     * @param pEquipo
     * @param pMedio
     * @return
     */
    public JugadorFantasia venderMedio(Menu pMenu, Participante pParticipante, EquipoFantasia pEquipo, JugadorFantasia pMedio){
        JugadorFantasia medioComprado = null;
        JugadorFantasia medioRetirar = null;
        JugadorFantasia medioSustituto = pEquipo.getMedioSustituto();
        String nombreMedioSustituto = pEquipo.getMedioSustituto().getNombre();
        String nombreMedioVendido = pMedio.getNombre();
        double precioVentaMedioVendido = pMedio.getPrecioVenta();

        if(nombreMedioVendido.equals(nombreMedioSustituto)){
            sumarVenta(precioVentaMedioVendido);
            while(medioComprado == null){
                medioComprado = comprarMedio(pMenu);
                medioRetirar = medioSustituto;
            }
            pEquipo.getJugadores().remove(medioRetirar);
            pEquipo.getJugadores().add(medioComprado);
            pEquipo.setMedioSustituto(medioComprado);
        }else{
            for(JugadorFantasia medio: pEquipo.getMediosTitulares()){
                if(medio.getNombre().equals(nombreMedioVendido)){
                    sumarVenta(precioVentaMedioVendido);
                    while(medioComprado == null){
                        medioComprado = comprarMedio(pMenu);
                        medioRetirar = medio;
                    }
                }
            }
            pEquipo.getMediosTitulares().remove(medioRetirar);
            pEquipo.agregarMedioTitular(medioComprado);
            pEquipo.getJugadores().remove(medioRetirar);
            pEquipo.getJugadores().add(medioComprado);
        }
        return medioComprado;
    }

    /**
     * Permite al participante vender un defensa
     * @param pMenu
     * @param pParticipante
     * @param pEquipo
     * @param pDefensa
     * @return
     */
    public JugadorFantasiaDefensivo venderDefensa(Menu pMenu, Participante pParticipante, EquipoFantasia pEquipo, JugadorFantasiaDefensivo pDefensa){
        JugadorFantasiaDefensivo defensaComprado = null;
        JugadorFantasia defensaRetirar = null;
        JugadorFantasia defensaSustituto = pEquipo.getDefensaSustituto();
        String nombreDefensaVendido = pDefensa.getNombre();
        String nombreDefensaSustituto = pEquipo.getDefensaSustituto().getNombre();
        double precioVentaDefensaVendido = pDefensa.getPrecioVenta();

        if (nombreDefensaSustituto.equals(nombreDefensaVendido)) {
            sumarVenta(precioVentaDefensaVendido);
            while (defensaComprado == null) {
                defensaComprado = comprarDefensa(pMenu);
                defensaRetirar = defensaSustituto;
            }
            pEquipo.getJugadores().remove(defensaRetirar);
            pEquipo.getJugadores().add(defensaComprado);
            pEquipo.setDefensaSustituto(defensaComprado);
        } else {
            for(JugadorFantasia defensa: pEquipo.getDefensasTitulares()){
                if(defensa.getNombre().equals(nombreDefensaVendido)){
                    sumarVenta(precioVentaDefensaVendido);
                    while(defensaComprado == null){
                        defensaComprado = comprarDefensa(pMenu);
                        defensaRetirar = defensa; 
                    }
                }
            } 
            pEquipo.getDefensasTitulares().remove(defensaRetirar);
            pEquipo.agregarDefensaTitular(defensaComprado);
            pEquipo.getJugadores().remove(defensaRetirar);
            pEquipo.getJugadores().add(defensaComprado);
        }
        return defensaComprado;
    }
}
