package paqueteCasillas;

import java.util.Scanner;
import paquetePartida.Jugador;
import paquetePartida.EstadoPartida;

public class GrupoTransporte {

    //ATRIBUTOS
    private int dineroSalida;
    private Casilla casilla;
    private Jugador propietario;
    private int valor;
    private int alquiler;
    private int dineroRecaudado;
    private boolean esHipotecada;


    //GETTERS
    public int getDineroSalida() {
        return dineroSalida;
    }
    public Casilla getCasilla(){return casilla;}
    public Jugador getPropietario() {
        return propietario;
    }
    public int getValor() {
        return valor;
    }
    public int getAlquiler() {
        return alquiler;
    }
    public int getDineroRecaudado() {
        return dineroRecaudado;
    }
    public boolean getEsHipotecada(){return esHipotecada;}


    //SETTERS
    public void setDineroSalida(int valorSumaSolares) {
        //CHECKEO DE QUE EL TURNO NO PUEDE SER NEGATIVO
        if(valorSumaSolares < 0){
            //Imprimir que el turno no uede ser negativo
            System.out.println("Error, el dineroSalida no puede ser negativo.");
            this.dineroSalida = 0;
        }else{
            this.dineroSalida = valorSumaSolares;
        }
    }
    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
    public void setAlquiler(int alquiler) {
        //CHECKEO DE QUE EL TURNO NO PUEDE SER NEGATIVO
        if(alquiler < 0){
            //Imprimir que el turno no uede ser negativo
            System.out.println("Error, el alquiler no puede ser negativo.");
            this.alquiler = 0;
        }else{
            this.alquiler = alquiler;
        }
    }
    public void setValor(int valor) {
        //CHECKEO DE QUE EL TURNO NO PUEDE SER NEGATIVO
        if(valor< 0){
            //Imprimir que el turno no uede ser negativo
            System.out.println("Error, el valor no puede ser negativo.");
            this.valor = 0;
        }else{
            this.valor = valor;
        }
    }
    public void setDineroRecaudado(int dineroRecaudado) {
        this.dineroRecaudado = dineroRecaudado;
    }
    public void setEsHipotecada(boolean esHipotecada){this.esHipotecada = esHipotecada;}


    //CONSTRUCTOR - TENEMOS QUE ASIGNAR COLORES
    public GrupoTransporte(Casilla casilla, int dineroSalida){

        //Asignamos atributos mediante setters - al inicializarlo el propietario será banca o null.
        setCasilla(casilla);
        setPropietario(EstadoPartida.getBanca());   //----------- BANCA ------------- //
        setDineroSalida(dineroSalida);
        setValor(dineroSalida);
        setAlquiler((int)(dineroSalida*0.25));
        setDineroRecaudado(0);
    }


    //MÉTODOS

    //MÉTODO CALCULAR ALQUILER
    public int calcularAlquiler(int dineroSalida){
        return (int)(getAlquiler() * (propiedadesTransporteJugador()));
    }

    //MÉTODO COMPRAR PROPIEDAD
    public void comprarTransporte(Jugador jugador){
        //Imprima el precio de la casilla
        System.out.println("El precio de la casilla es de " + getValor() + " €");
        //Preguntar si quiere comprar la casilla
        System.out.println("¿Quieres comprar la casilla? (S/N)");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();
        //Si la respuesta es S se compra la casilla
        if(respuesta.equals("S")){
            //Chequeo
            if((jugador.getDinero() - getValor()) < 0){
                System.out.println("No tienes suficiente dinero para comprar la casilla " + getCasilla().getNombreCasilla() + "\n");
            }
            else{
                //estadísticas del jugador dineroInvertido
                jugador.setDineroInvertido(jugador.getDineroInvertido() + getValor());
                jugador.setDinero(jugador.getDinero() - getValor());
                jugador.setComproCasillaTurno(1);
                jugador.anadirPropiedad(casilla);
                setPropietario(jugador);
                System.out.println("Has comprado la casilla " + getCasilla().getNombreCasilla() + " por " +
                        getValor() + " €\n");
            }

        }else  {
            System.out.println("No has comprado la casilla " + getCasilla().getNombreCasilla() + "\n");
        }
    }

    //MÉTODO COBRAR ALQUILER
    public void cobrarAlquiler(EstadoPartida estadoPartida, Jugador jugador){

        //Actualizamos el coste de alquiler
        Jugador jugadorAux = getPropietario();
        //Chequeo que se pueda pagar o no:
        if(jugador.getDinero() - getAlquiler() < 0){
            jugador.noDinero(estadoPartida, jugadorAux);
        }

        jugador.setDinero(jugador.getDinero() - getAlquiler());
        jugadorAux.setDinero(jugadorAux.getDinero() + getAlquiler());

        //Estadística pagoAlquileres
        jugador.setPagoAlquileres(jugador.getPagoAlquileres() + getAlquiler());
        //Estadistica cobroAlquileres
        jugadorAux.setCobroAlquileres(jugadorAux.getCobroAlquileres() + getAlquiler());

        //Estadística dineroRecaudado
        setDineroRecaudado(getDineroRecaudado() + getAlquiler());

        //PRINTEAR QUE SE HA PAGADO EL ALQUILER
        System.out.println("Has pagado " + getAlquiler() + " € de alquiler a " + getPropietario().getNombre());
    }

    //METODO PARA HALLAR CUANTAS PROPIEDADES TRANSPORTE TIENE UN JUGADOR
    public int propiedadesTransporteJugador(){

        //Variables
        Casilla casilla;
        int contador = 0;

        //Chequeamos si hay un propietario distinto de banca:
        if(getPropietario().getNombre().equals("Banca")){
            return 0;
        }
        else {
            //ACCEDEMOS A LAS PROPIEDADES DEL JUGADOR
            int i = 0;
            for (i = 0; i < propietario.getPropiedades().size(); i++){

                //Cogemos la casilla
                casilla = propietario.getPropiedades().get(i);

                //Chequeamos si alguna es tipo transporte:
                if (casilla.getGrupoCasilla().equals("Transporte")){
                    if (!casilla.getGrupoTransporte().esHipotecada){
                        contador++;
                    }
                }
            }

            //Devolvemos contador:
            return contador;
        }
    }

}
