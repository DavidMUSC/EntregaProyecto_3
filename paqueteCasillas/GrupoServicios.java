package paqueteCasillas;

import java.util.Scanner;
import paquetePartida.Jugador;
import paquetePartida.EstadoPartida;

public class GrupoServicios {
    //ATRIBUTOS
    private Casilla casilla;
    private Jugador propietario;
    private int valor; //Su valor inicial debe de ser el 0.75 de la cantidad que recibe el jugador en Salida
    private int alquiler;//Depende del valor de los dadosy el numero de servicios
    private int factorServicio; //200 veces menos que la cantiadad que recibe el juagador en Salida
    private int dineroRecaudado;
    private boolean esHipotecada;

    //GETTERS
    public Casilla getCasilla() {
        return casilla;
    }
    public Jugador getPropietario() {
        return propietario;
    }
    public int getValor() {
        return valor;
    }
    public int getAlquiler() {
        return alquiler;
    }
    public int getFactorServicio() {
        return factorServicio;
    }
    public int getDineroRecaudado() {
        return dineroRecaudado;
    }
    public boolean getEsHipotecada(){return esHipotecada;}

    //SETTERS
    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }
    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
    public void setFactorServicio(int factorServicio) {
        this.factorServicio = factorServicio;
    }
    public void setDineroRecaudado(int dineroRecaudado) {
        this.dineroRecaudado = dineroRecaudado;
    }
    public void setEsHipotecada(boolean esHipotecada){this.esHipotecada = esHipotecada;}

    //CONTRUCTOR
    public GrupoServicios(Casilla casilla,int cantidadPorVuelta){
        setCasilla(casilla);
        setPropietario(EstadoPartida.getBanca());//CAMBIAR A BANCA

        //Aqui va el metodo para calcular el valor
        setValor(valorServicio(cantidadPorVuelta));
        setDineroRecaudado(0);
    }
    //METODO PARA EL VALOR
    public int valorServicio(int cantidadPorVuelta){ //Su valor debe de ser el 0.75 de la cantidad que recibe el jugador en Salida
        return (int) (0.75 * cantidadPorVuelta);    //Cada vez que se actualiza cantidadPorVuelta se actualiza el valor de los servicios
    }

    //METODO PARA CALCULAR EL FACTOR SERVICIO
    public int factorServicio(int cantidadPorVuelta){
        setFactorServicio((int) (cantidadPorVuelta/200));
        return getFactorServicio();
    }

    //METODO PARA CALCULAR EL ALQUILer que deende del valor del valor de los dados y el factor de servicios
    public int alquilerServicio(int valorDados,int factorServicio){//El valor de los dados va estar en una variable en main que modifica la funcion lanzarDados
        return valorDados*factorServicio;
    }

    //METODO PARA COBRAR EL ALQUILER
    public void cobrarAlquiler(EstadoPartida estadoPartida, Jugador jugador){
        Jugador jugadorAux = getPropietario();
        //checkeo de si se puede pagar o no
        if(jugador.getDinero() - getAlquiler() < 0){
            jugador.noDinero(estadoPartida, jugadorAux);
        }
        jugador.setDinero(jugador.getDinero() - getAlquiler());
        jugadorAux.setDinero(jugadorAux.getDinero() + getAlquiler());

        //Estadística pagoAlquileres
        jugador.setPagoAlquileres(jugador.getPagoAlquileres() + getAlquiler());
        //Estadistica cobroAlquileres
        jugadorAux.setCobroAlquileres(jugadorAux.getCobroAlquileres() + getAlquiler());
        //estadística dineroRecaudado
        setDineroRecaudado(getDineroRecaudado() + getAlquiler());
    }

    //METODO PARA COMPRAR UN SERVICIO
    public void comprarServicio(Jugador jugador){
        //Imprimir precio de la casilla
        System.out.println("El precio de la casilla es " + getValor() + " €");
        //Preguntar si quiere comprar la casilla
        System.out.println("¿Quieres comprar la casilla? (S/N)");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();
        //Si la respuesta es S se compra la casilla
        if(respuesta.equals("S")){
            //checkeo de si se puede pagar o no
            if((jugador.getDinero() - getValor()) < 0){
                System.out.println("No tienes suficiente dinero para comprar la casilla " + getCasilla().getNombreCasilla() + "\n");
            }
            else{
                //estadística de dinero invertido en propiedades
                jugador.setDineroInvertido(jugador.getDineroInvertido()+getValor());
                jugador.setComproCasillaTurno(1);
                jugador.setDinero(jugador.getDinero() - getValor());
                jugador.anadirPropiedad(casilla);
                setPropietario(jugador);
                System.out.println("Has comprado la casilla " + getCasilla().getNombreCasilla() + " por " +
                        getValor() + " €\n");

            }
        }
        //Si la respuesta es N no se compra la casilla
        else {
            System.out.println("No has comprado la casilla " + getCasilla().getNombreCasilla() + "\n");
        }
    }
}
