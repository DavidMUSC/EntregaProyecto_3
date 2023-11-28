package paquetePartida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import paqueteCasillas.Casilla;
import paqueteCasillas.GrupoSalida;
import paqueteCasillas.Tablero;
import paqueteCasillas.GrupoSolar;
import paqueteCasillas.Edificaciones;

public class Jugador {

    //ATRIBUTOS
    private Casilla casilla;
    private String nombre;
    private Avatar avatar; //El id lo sacaremos desde este avatar.
    private int dinero; //cuando el dinero sea negativo el jugador entra en bancarrota
    private ArrayList<Casilla> propiedades; //ATRIBUTO PROPIEDADES COMPRADAS
    private int TurnosCarcel;
    private ArrayList<String> monopolioColor;
    private ArrayList<Integer> casillasPasadas;
    private boolean tieneCartaSuerte = false;
    private int vueltasCompletadas;
    private int indiceDados;
    private int dineroInvertido;
    private int pagoTasaseImpuestos;
    private int pagoAlquileres;
    private int cobroAlquileres;
    private int cobroPremiosOBote;
    private int pasarPorCasillaSalida;
    private int vecesCarcel;
    private int vecesDados;
    private int fortunaTotal;
    private int comproCasillaTurno;

    //CASILLA ACTUAL NO HACE FALTA PORQ YA ESTÁ EN AVATAR
    //TIPO AVATAR TAMPOCO HACE FALTA PORQ YA ESTÁ EN AVATAR


    //GETTERS
    public Casilla getCasillaDeJugador() {
        return this.casilla;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getDinero() {
        return this.dinero;
    }

    public Avatar getAvatar() {
        return this.avatar;
    }

    public boolean getTieneCartaSuerte() {
        return tieneCartaSuerte;
    }

    public int getTurnosCarcel() {
        return TurnosCarcel;
    }

    public int getVueltasCompletadas(){
        return vueltasCompletadas;
    }
    
    public int getIndiceDados(){
        return indiceDados;
    }

    public ArrayList<String> getMonopolioColor(){
        return monopolioColor;
    }

    public ArrayList<Integer> getCasillasPasadas(){
        return casillasPasadas;
    }

    //Getter compuesto para obtener el tipo de avatar.
    public String getAvatarTipo() {
        return getAvatar().getTipoAvatar();
    }

    public ArrayList<Casilla> getPropiedades() {
        return propiedades;
    }

    public int getDineroInvertido(){
        return dineroInvertido;
    }
    public int getPagoTasasEImpuestos(){
        return pagoTasaseImpuestos;
    }
    public int getPagoAlquileres(){
        return pagoAlquileres;
    }
    public int getCobroAlquileres(){
        return cobroAlquileres;
    }
    public int getCobroPremiosOBote(){
        return cobroPremiosOBote;
    }
    public int getPasarPorCasillaSalida(){
        return pasarPorCasillaSalida;
    }
    public int getVecesCarcel(){
        return vecesCarcel;
    }
    public int getVecesDados(){
        return vecesDados;
    }
    public int getFortunaTotal(){
        return fortunaTotal;
    }
    public int getComproCasillaTurno(){
        return comproCasillaTurno;
    }

    //SETTERS

    public void setCasillaDeJugador(Casilla casilla) {
        this.casilla = casilla;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public void setDinero(int newDinero) {
        this.dinero = newDinero;
    }

    public void setTurnosCarcel(int turnosCarcel) {
        TurnosCarcel = turnosCarcel;
    }
    
    public void setVueltasCompletadas(int vueltasCompletadas){this.vueltasCompletadas = vueltasCompletadas;}

    //La creación del objeto avatar se hace en el main, aquí solo hace el set:
    public void setAvatar(Avatar newAvatar) {
        avatar = newAvatar;
    }

    public void setPropiedades(ArrayList<Casilla> propiedades) {
        this.propiedades = propiedades;
    }

    public void setMonopolioColor(ArrayList<String> monopolioColor){
        this.monopolioColor = monopolioColor;
    }
    public void setIndiceDados(int indiceDados){
        this.indiceDados = indiceDados;
    }
    public void setDineroInvertido(int dineroInvertido){
        this.dineroInvertido = dineroInvertido;
    }
    public void setPagoTasasEImpuestos(int pagoTasaseImpuestos){
        this.pagoTasaseImpuestos = pagoTasaseImpuestos;
    }
    public void setPagoAlquileres(int pagoAlquileres){
        this.pagoAlquileres = pagoAlquileres;
    }
    public void setCobroAlquileres(int cobroAlquileres){
        this.cobroAlquileres = cobroAlquileres;
    }
    public void setCobroPremiosOBote(int cobroPremiosOBote){
        this.cobroPremiosOBote = cobroPremiosOBote;
    }
    public void setPasarPorCasillaSalida(int pasarPorCasillaSalida){
        this.pasarPorCasillaSalida = pasarPorCasillaSalida;
    }
    public void setVecesCarcel(int vecesCarcel){
        this.vecesCarcel = vecesCarcel;
    }
    public void setVecesDados(int vecesDados){
        this.vecesDados = vecesDados;
    }
    public void setFortunaTotal(int fortunaTotal){
        this.fortunaTotal = fortunaTotal;
    }
    public void setComproCasillaTurno(int comproCasillaTurno){
        this.comproCasillaTurno = comproCasillaTurno;
    }

    //CONSTRUCTOR
    //Cada vez que creemos un jugador se creará también un avatar.
    //Al crear un jugador, le pasamos la casilla inicial y se la asignará
    //a su avatar.
    public Jugador(String nombre, String piezaAvatar, Casilla casilla) {
        setCasillaDeJugador(casilla);
        setNombre(nombre);
        setAvatar(new Avatar(this, casilla, piezaAvatar));
        setDinero((int) ((Tablero.getValorSumaSolares()) / 3));
        propiedades = new ArrayList<Casilla>(22);
        monopolioColor = new ArrayList<String>(8);
        casillasPasadas = new ArrayList<Integer>(40);
        inicializarCasillasPasadas();
        setIndiceDados(0);
        setVueltasCompletadas(0);
        setComproCasillaTurno(0);
        //estadisticas
        setDineroInvertido(0);
        setPagoTasasEImpuestos(0);
        setPagoAlquileres(0);
        setCobroAlquileres(0);
        setCobroPremiosOBote(0);
        setPasarPorCasillaSalida(0);
        setVecesCarcel(0);
        setVecesDados(0);
        setFortunaTotal(0);
    }

    //PARA CREAR EL JUGADOR ESPECIAL BANCA PODEMOS HACER UNA SOBRECARGA DE CONSTRUCTORES
    //ALTERNATIVA: TAMBIÉN PODEMOS CREARLO CON UN MÉTODO ESPECIAL EN ESTADO PARTIDA
    public Jugador(String nombre) {
        if (nombre.equals("Banca")) {

            setNombre("Banca");
            setDinero(9999999);
            propiedades = new ArrayList<Casilla>(22);


        } else {
            System.out.println("Formato de constructor incorrecto.");
        }
    }

    //OTRO MÉTODO CONSTRUCTOR PERO PASANDO TABLERO:
    public Jugador(String nombre, String piezaAvatar, Tablero tablero) {
        setCasillaDeJugador(tablero.getCasilla(0));
        setNombre(nombre);
        setAvatar(new Avatar(this, tablero.getCasilla(0), piezaAvatar));
        setDinero((int) ((Tablero.getValorSumaSolares()) / 3));
        propiedades = new ArrayList<Casilla>(22);
        monopolioColor = new ArrayList<String>(8);
        casillasPasadas = new ArrayList<Integer>(40);
        inicializarCasillasPasadas();
        setIndiceDados(0);
        setVueltasCompletadas(0);
        setComproCasillaTurno(0);
        //estadisticas
        setDineroInvertido(0);
        setPagoTasasEImpuestos(0);
        setPagoAlquileres(0);
        setCobroAlquileres(0);
        setCobroPremiosOBote(0);
        setPasarPorCasillaSalida(0);
        setVecesCarcel(0);
        setVecesDados(0);
        setFortunaTotal(0);
    }

    // Método para verificar si el jugador tiene una carta de suerte
    public boolean tieneCartaSuerte() {
        return tieneCartaSuerte;
    }

    // Método para usar una carta de suerte
    public void usarCartaSuerte() {
        if (tieneCartaSuerte) {
            tieneCartaSuerte = false;
            System.out.println(nombre + " ha usado una carta de suerte.");
            // Puedes implementar la lógica específica de la carta de suerte aquí
        } else {
            System.out.println(nombre + " no tiene cartas de suerte para usar.");
        }
    }

    //Ocasionado por la banca
    public void noDinero(EstadoPartida estadoPartida) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(nombre + ", no tienes dinero suficiente");

        System.out.println("Elige una opción:");
        System.out.println("1. Hipotecar propiedades");
        System.out.println("2. Declararte en bancarrota");
        //Volver al menu de casillaCamprables
        System.out.println("3. Volver al menú");
        int opcion;
        // Mientras la entrada no sea un número o esté fuera del rango 1-3, sigue pidiendo input.
        while (true) {
            // Verifica si la entrada es un número entero.
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                // Verifica si la opción está en el rango 1-3.
                if (opcion >= 1 && opcion <= 3) {
                    break; // Sale del bucle si la opción es válida.
                } else {
                    System.out.println("Por favor, introduce una opción válida del 1 al 3.");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Limpia el buffer del scanner antes de la siguiente iteración.
            }
        }

        switch (opcion) {
            case 1:
                System.out.println(nombre + " ha elegido hipotecar sus propiedades.");
                hipotecarPropiedad(estadoPartida);

                // añadir cosas
                break;
            case 2:
                System.out.println(nombre + " ha elegido entrar en bancarrota.");
                entrarBancarrotaBanca(estadoPartida);

                break;
            case 3:
                System.out.println(nombre + "ha vuelto al menú.");
                return;
            default:
                System.out.println("Opción no válida.");

        }
    }

    //Ocasionado por jugador:
    public void noDinero(EstadoPartida estadoPartida, Jugador destinatario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(nombre + ", no tienes dinero suficiente");

        System.out.println("Elige una opción:");
        System.out.println("1. Hipotecar propiedades");
        System.out.println("2. Declararte en bancarrota");
        //Volver al menu de casillaCamprables
        System.out.println("3. Volver al menú");
        int opcion;
        // Mientras la entrada no sea un número o esté fuera del rango 1-3, sigue pidiendo input.
        while (true) {
            // Verifica si la entrada es un número entero.
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                // Verifica si la opción está en el rango 1-3.
                if (opcion >= 1 && opcion <= 3) {
                    break; // Sale del bucle si la opción es válida.
                } else {
                    System.out.println("Por favor, introduce una opción válida del 1 al 3.");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Limpia el buffer del scanner antes de la siguiente iteración.
            }
        }

        switch (opcion) {
            case 1:
                System.out.println(nombre + "ha elegido hipotecar sus propiedades.");
                this.hipotecarPropiedad(estadoPartida);

                // añadir cosas
                break;
            case 2:
                //Entramos en bancarrota por un jugador:
                this.entrarBancarrotaJugador(estadoPartida, destinatario);

                break;
            case 3:
                System.out.println(nombre + "ha vuelto al menú.");
                return;
            default:
                System.out.println("Opción no válida.");

        }
    }

    //AÑADIR PROPIEDAD
    public void anadirPropiedad(Casilla casilla) {

        propiedades.add(casilla);
    }

    //CAMBIAR LA CASILLA DEL AVATAR
    public void cambiarCasillaAvatar(Casilla casilla) {
        getAvatar().setCasilla(casilla);
    }

    //?ESPROPIETARIO? - Chequea si una determinada casilla es tuya
    public int getNumPropiedades() {
        return propiedades.size();
    }

    //OTROS MÉTODOS - //Este método servira cuando nos pidan listar jugadores
    public String toStringListar() {

        //Declaramos variable:
        ArrayList<String> edificaciones = edificacionesJugador();
        String stringAux = "";
        String stringAux2 = "";

        //String auxiliar para guardar las propiedades:
        if (!getPropiedades().isEmpty()) {

            //Ponemos las comas, tabs, lineas del string:
            stringAux = ",\n\tpropiedades: [";

            //Hacemos el bucle para añadir propiedades al string:
            int i = 0;
            for (i = 0; i < getPropiedades().size() - 1; i++) {
                stringAux = stringAux + getPropiedades().get(i).getNombreCasilla() + ", ";
            }
            stringAux = stringAux + getPropiedades().get(i).getNombreCasilla();

            //Ponemos el fin del string:
            stringAux = stringAux + "]";
        }

        //String auxiliar2 para guardar las edificaciones:
        if (!edificaciones.isEmpty()) {

            //Ponemos las comas, tabs, lineas del string:
            stringAux2 = ",\n\tedificaciones: [";

            //Hacemos el bucle para añadir propiedades al string:
            int i = 0;
            for (i = 0; i < edificaciones.size() - 1; i++) {
                stringAux2 = stringAux2 + edificaciones.get(i) + ", ";
            }
            stringAux2 = stringAux2 + edificaciones.get(i);

            //Ponemos el fin del string:
            stringAux2 = stringAux2 + "]";
        }

        String string = ("{\n\tnombre: " + getNombre() + ",\n\tavatar: " + getAvatar().getId() + ",\n\tfortuna :" +
                getDinero() + stringAux + stringAux2 + ",\n}\n");


        return string;
    }

    public String indicarJugador() {     //Este método sirve cuando necesitamos indicar un jugador, solo devuelve nombre y avatar-
        return ("{\n\tnombre: " + getNombre() + ",\n\tavatar: " + getAvatar().getId() + "\n}");
    }

    //FUNCION PARA SABER UN JUGADOR TIENE UN MONOPOLIO
    public int calcularMonopolio(){

        //Variable hayMonopolio:
        int hayMonopolio = 0;

        //Inicializamos contadores para cada grupo color:
        int negro = 0; //MAX 2
        int cian = 0; //MAX 3
        int rosa = 0; //MAX 3
        int amarillo = 0; //MAX 3
        int rojo = 0; //MAX 3
        int marron = 0; //MAX 3
        int verde = 0; //MAX 3
        int azul = 0; //MAX 2


        //Iteramos en las propiedades del jugador
        int i = 0;
        for (i = 0; i < propiedades.size(); i++){
            //Comprobar que en las propiedades del jugador hay un grupo solar
            if(propiedades.get(i).getGrupoCasilla().equals("Solar")){

                //Tomamos el color del solar:
                String color = propiedades.get(i).getGrupoSolar().getColorSolar();

                //Switch para aumentar el contador del color correspondiente:
                switch (color){

                    case "Negro":
                        negro++;
                        break;
                    case "Cian":
                        cian++;
                        break;
                    case "Rosa":
                        rosa++;
                        break;
                    case "Amarillo":
                        amarillo++;
                        break;
                    case "Rojo":
                        rojo++;
                        break;
                    case "Marron":
                        marron++;
                        break;
                    case "Verde":
                        verde++;
                        break;
                    case "Azul":
                        azul++;
                        break;
                }
            }
        }

        //Una vez tenemos todos los contadores actualizados, iteramos para ver si existe el monopolio:

        //NEGRO
        if (negro == 2){
            if (!monopolioColor.contains("Negro")){
                monopolioColor.add("Negro");
                hayMonopolio = 1;
            }
        }

        //CIAN
        if (cian == 3){
            if(!monopolioColor.contains("Cian")){
                monopolioColor.add("Cian");
                hayMonopolio = 1;
            }

        }

        //ROSA
        if (rosa == 3){
            if (!monopolioColor.contains("Rosa")){
                monopolioColor.add("Rosa");
                hayMonopolio = 1;
            }
        }

        //AMARILLO
        if (amarillo == 3){
            if (!monopolioColor.contains("Amarillo")){
                monopolioColor.add("Amarillo");
                hayMonopolio = 1;
            }
        }

        //ROJO
        if (rojo == 3){
            if (!monopolioColor.contains("Rojo")){
                monopolioColor.add("Rojo");
                hayMonopolio = 1;
            }
        }

        //MARRON
        if (marron == 3){
            if (!monopolioColor.contains("Marron")){
                monopolioColor.add("Marron");
                hayMonopolio = 1;
            }
        }

        //VERDE
        if (verde == 3){
            if (!monopolioColor.contains("Verde")){
                monopolioColor.add("Verde");
                hayMonopolio = 1;
            }
        }

        //AZUL
        if (azul == 2){
            if (!monopolioColor.contains("Azul")){
                monopolioColor.add("Azul");
                hayMonopolio = 1;
            }
        }
        //Devolvemos 1 si se actualiza el monopolio
        return hayMonopolio;
    }

    public void incrementarVueltasCompletadas(){
        setVueltasCompletadas(getVueltasCompletadas()+1);
    }

    public int incrementarIndiceDados(int valor){
        setIndiceDados(getIndiceDados()+valor);
        return getIndiceDados();
    }

    //MÉTODO PARA INICIALIZAR LAS CASILLAS PASADAS A CERO
    public void inicializarCasillasPasadas(){
        for (int i = 0; i < 40; i++){
            casillasPasadas.add(0);
        }
    }

    //MÉTODO PARA ACTUALIZAR LAS CASILLAS PASADAS
    public void actualizarCasillasPasadas(Casilla casilla){
        int indiceCasilla = casilla.getNumCasilla();
        //ArrayList de int con las casillas pasadas
        casillasPasadas.set(indiceCasilla, getCasillasPasadas().get(indiceCasilla)+1);
        //System.out.println("El valor de la casilla " + indiceCasilla + " es " + casillasPasadas.get(indiceCasilla));
    }

    //METODO PARA SABER LAS VECES QUE HAS PASADO POR LA CASILLA POR LA QUE HA PASADO MÁS VECES
    public int vecesCasillaMasPasada(){
        int max = 0;
        int indiceMax = 0;
        for (int i = 0; i < 40; i++){
            if (casillasPasadas.get(i) > max){
                max = casillasPasadas.get(i);
                indiceMax = i;
            }
        }
        return max;
    }

    //MÉTODO PARA EL INDICE DE LA CASILLA POR LA QUE HAS PASADO MÁS VECES
    public int indiceCasillaMasPasada(){
        int max = 0;
        int indiceMax = 0;
        for (int i = 0; i < 40; i++){
            if (casillasPasadas.get(i) > max){
                max = casillasPasadas.get(i);
                indiceMax = i;
            }
        }
        return indiceMax;
    }

    //MÉTODO PARA COMPROBAR SI UNA CASILLA PASADA ESTÁ CON EL VALOR DOS (ES DECIR, SI SE HA PASADO DOS VECES POR ELLA)
    public boolean comprobarCasillaPasada(Casilla casilla){
        int indiceCasilla = casilla.getNumCasilla();
        int valor = casillasPasadas.get(indiceCasilla);
        if (valor == 2){
            return true;
        }
        else{
            return false;
        }
    }

    //MÉTODO PARA ACTUALIZAR VECES DADOS
    public void actualizarVecesDados(){
        setVecesDados(getVecesDados()+1);
    }

    //MÉTODO PARA CALCULAR LA FORTUNA TOTAL. HAY QUE TENER EN CUENTA EL VALOR DE LAS EDIFICACIONES Y EL DINERO
    public void calcularFortunaTotal(){
        int fortuna = 0;
        int i = 0;
        int j = 0;
        Edificaciones edificacion;
        //Sumamos el dinero
        fortuna = getDinero();
        //Iteramos sobre las propiedades del jugador:
        for (i = 0; i < propiedades.size(); i++){

            //Accedemos a las edificaciones si es un GrupoSolar
            if (propiedades.get(i).getGrupoCasilla().equals("Solar")){
                //Sumamos el valor de la propiedad
                fortuna = fortuna + propiedades.get(i).getGrupoSolar().getValor();

                //Accedemos a edificaciones:
                edificacion = propiedades.get(i).getGrupoSolar().getEdificaciones();
                fortuna = fortuna + ((edificacion.getCosteCasas() * edificacion.getNumCasas()) + (edificacion.getNumHoteles() *
                        edificacion.getCosteHoteles()) + (edificacion.getNumPiscinas() * edificacion.getCostePiscinas()) +
                        (edificacion.getCostePistasDeporte() * edificacion.getNumPistasDeporte()));


            }
            if(propiedades.get(i).getGrupoCasilla().equals("Transporte")){
                //Sumamos el valor de la propiedad
                fortuna = fortuna + propiedades.get(i).getGrupoTransporte().getValor();
            }
            if(propiedades.get(i).getGrupoCasilla().equals("Servicios")){
                //Sumamos el valor de la propiedad
                fortuna = fortuna + propiedades.get(i).getGrupoServicios().getValor();
            }
        }
        setFortunaTotal(fortuna);
    }

    //MÉTODO PARA VER SI PUEDES CONTRUIR
    public boolean puedesConstruir(Casilla casilla){
        if(casilla.getGrupoSolar()!=null){
            //Comprobar si el jugador tiene el monopolio del grupoSolar
            if (monopolioColor.contains(casilla.getGrupoSolar().getColorSolar())){
                System.out.println("Puedes construir en esta casilla porque tienes el monopolio del grupo solar de color " + casilla.getGrupoSolar().getColorSolar());
                return true;
            }
            //comprobar casilla pasada y si es propietario de la casilla
            else if(comprobarCasillaPasada(casilla) && casilla.getGrupoSolar().getPropietario().equals(this)){
                System.out.println("Puedes construir en esta casilla porque eres el propietario de la casilla y has pasado dos veces por ella");
                return true;
            }
            else{
                System.out.println("No puedes construir en esta casilla");
                return false;
            }
        }else{
            return false;
        }
    }

    //MÉTODO AUXILIAR PARA CONSEGUIR TODAS LAS EDIFICACIONES DE UN JUGADOR
    public ArrayList<String> edificacionesJugador(){

        //Variables
        ArrayList<String> edificacionesDeJugador = new ArrayList<>(10);
        int i = 0;
        int j = 0;
        Edificaciones edificacion;

        //Iteramos sobre las propiedades del jugador:
        for (i = 0; i < propiedades.size(); i++){

            //Accedemos a las edificaciones si es un GrupoSolar
            if (propiedades.get(i).getGrupoCasilla().equals("Solar")){

                //Accedemos a edificaciones
                edificacion = propiedades.get(i).getGrupoSolar().getEdificaciones();

                //Iteramos sobre los IDs de las propiedades:
                for (j = 0; j < edificacion.getIds().size(); j++){
                    edificacionesDeJugador.add(edificacion.getIds().get(j));
                }
            }
        }
        //Retornamos el ArrayList
        return edificacionesDeJugador;
    }

    //Método para vender edificios (con menú para elegir que vender):
    public void venderEdificios(EstadoPartida estadoPartida){

        //Variables
        int opcionEdificio;
        int cantidadVenta;
        int i = 0;
        String edificioVender = "";
        String casilla;
        Scanner scanner = new Scanner(System.in);
        Casilla casillaAux = null;
        Edificaciones edificacionesAux = null;

        //Check para que si no tienes propiedades ya no puedas edificar:
        if(getPropiedades().isEmpty()){
            System.out.println("No puedes hipotecar ninguna casilla ya que no tienes propiedades.");
            return;
        }

        //Menu para indicar de que GrupoSolar quieres vender:
        System.out.println("Indica en que casilla quieres vender: ");
        casilla = scanner.next();

        //Chequeamos que sea una casilla existente:
        for (i = 0; i < 40; i++){
            if (estadoPartida.getTablero().getCasilla(i).getNombreCasilla().equals(casilla)){
                casillaAux = estadoPartida.getTablero().getCasilla(i);
                break;
            }
        }
        //Si no se ha determinado la casilla por la que se pregunta:
        if (casillaAux == null){
            System.out.println("La casilla seleccionada no existe.");
            return;
        }

        //Chequeamos que sea GrupoSolar
        if (!casillaAux.getGrupoCasilla().equals("Solar")){
            System.out.println("No puedes vender edificios en la casilla seleccionada porque no es un solar.");
            return;
        }

        //Chequeamos que el solar sea del jugador a vender:
        if (!casillaAux.getGrupoSolar().getPropietario().equals(this)){
            System.out.println("No puedes vender edificios en la casilla seleccionada porque no te pertenece");
            return;
        }

        //Chequeamos que tenga propiedades:
        edificacionesAux = casillaAux.getGrupoSolar().getEdificaciones();
        if (edificacionesAux.esVacioEdificaciones()){
            System.out.println("No hay edificios para vender en el solar seleccionado");
            return;
        }

        //Menú para elegir que quieres vender
        System.out.println("Selecciona el tipo de edificios a vender");
        System.out.println("1. Casa");
        System.out.println("2. Hotel");
        System.out.println("3. Piscina");
        System.out.println("4. Pista de deportes");
        opcionEdificio = scanner.nextInt();

        //Asignamos valores al string dependiendo de la opción:
        switch (opcionEdificio){
            case 1:
                edificioVender = "Casa";
                break;
            case 2:
                edificioVender = "Hotel";
                break;
            case 3:
                edificioVender = "Piscina";
                break;
            case 4:
                edificioVender = "PistaDeportes";
                break;
        }

        //Menú para elegir cuantas unidades quieres vender
        System.out.println("Selecciona la cantidad de edificios a vender");
        cantidadVenta = scanner.nextInt();

        //Llamada a venderEdificios con los argumentos necesarios:
        venderEdificios(edificacionesAux ,edificioVender, cantidadVenta, casillaAux.getNombreCasilla());
    }

    //Sobrecarga del método para vender dependiendo del edificio:
    public void venderEdificios(Edificaciones edificaciones, String edificio, int cantidad, String nombreCasilla){

        //Variables
        int dineroObtenido = 0;
        int numEdificiosExistentes = 0;
        boolean check = false;
        int flag = 0;
        int i = 0;

        //Escogemos el tipo de edificaciones a vender y cuántas hay dependiendo de un switch:
        switch (edificio){
            case "Casa":
                numEdificiosExistentes = edificaciones.getNumCasas();

                //Chequeamos si se puede vender el edificio con la cantidad dada:
                check = sePuedeVenderEdificio(edificio, numEdificiosExistentes, cantidad);
                if (!check) return;

                //Eliminamos el número de IDs determinado de edificaciones:
                //Iteramos por los ids:
                while (flag != cantidad)
                    //Si el id es del tipo de edificio a vender:
                    if (edificaciones.getIds().get(i).startsWith("casa-")){
                        //Eliminamos id
                        edificaciones.getIds().remove(i);
                        flag++;
                        //Reducimos el número de la propiedad en 1
                        edificaciones.setNumCasas(edificaciones.getNumCasas() - 1);
                        //Sumamos valor/2 a la variable dineroObtenido
                        dineroObtenido = dineroObtenido + edificaciones.getCosteCasas()/2;
                    }
                    else{
                        //aumentamos contador
                        i++;
                    }
                //Le sumamos al jugador el dinero obtenido:
                dinero = dinero + dineroObtenido;
                break;

            case "Hotel":
                numEdificiosExistentes = edificaciones.getNumHoteles();

                //Chequeamos si se puede vender el edificio con la cantidad dada:
                check = sePuedeVenderEdificio(edificio, numEdificiosExistentes, cantidad);
                if (!check) return;

                //Eliminamos el número de IDs determinado de edificaciones:
                //Iteramos por los ids:
                while (flag != cantidad)
                    //Si el id es del tipo de edificio a vender:
                    if (edificaciones.getIds().get(i).startsWith("hotel-")){
                        //Eliminamos id
                        edificaciones.getIds().remove(i);
                        flag++;
                        //Reducimos el número de la propiedad en 1
                        edificaciones.setNumHoteles(edificaciones.getNumHoteles() - 1);
                        //Sumamos valor/2 a la variable dineroObtenido
                        dineroObtenido = dineroObtenido + edificaciones.getCosteHoteles()/2;
                    }
                    else{
                        //aumentamos contador
                        i++;
                    }
                //Le sumamos al jugador el dinero obtenido:
                dinero = dinero + dineroObtenido;
                break;

            case "Piscina":
                numEdificiosExistentes = edificaciones.getNumPiscinas();

                //Chequeamos si se puede vender el edificio con la cantidad dada:
                check = sePuedeVenderEdificio(edificio, numEdificiosExistentes, cantidad);
                if (!check) return;

                //Eliminamos el número de IDs determinado de edificaciones:
                //Iteramos por los ids:
                while (flag != cantidad)
                    //Si el id es del tipo de edificio a vender:
                    if (edificaciones.getIds().get(i).startsWith("piscina-")){
                        //Eliminamos id
                        edificaciones.getIds().remove(i);
                        flag++;
                        //Reducimos el número de la propiedad en 1
                        edificaciones.setNumPiscinas(edificaciones.getNumPiscinas() - 1);
                        //Sumamos valor/2 a la variable dineroObtenido
                        dineroObtenido = dineroObtenido + edificaciones.getCostePiscinas()/2;
                    }
                    else{
                        //aumentamos contador
                        i++;
                    }
                //Le sumamos al jugador el dinero obtenido:
                dinero = dinero + dineroObtenido;
                break;

            case "PistaDeporte":
                numEdificiosExistentes = edificaciones.getNumPistasDeporte();

                //Chequeamos si se puede vender el edificio con la cantidad dada:
                check = sePuedeVenderEdificio(edificio, numEdificiosExistentes, cantidad);
                if (!check) return;

                //Eliminamos el número de IDs determinado de edificaciones:
                //Iteramos por los ids:
                while (flag != cantidad)
                    //Si el id es del tipo de edificio a vender:
                    if (edificaciones.getIds().get(i).startsWith("deporte-")){
                        //Eliminamos id
                        edificaciones.getIds().remove(i);
                        flag++;
                        //Reducimos el número de la propiedad en 1
                        edificaciones.setNumPistasDeporte(edificaciones.getNumPistasDeporte() - 1);
                        //Sumamos valor/2 a la variable dineroObtenido
                        dineroObtenido = dineroObtenido + edificaciones.getCostePistasDeporte()/2;
                    }
                    else{
                        //aumentamos contador
                        i++;
                    }
                //Le sumamos al jugador el dinero obtenido:
                dinero = dinero + dineroObtenido;
                break;

        }

        //Printeamos:
        //String Auxiliar dependiendo del edificio:
        String stringAux = "";
        switch (edificio){
            case "Casa":
                stringAux = "casa(s)";
                break;
            case "Hotel":
                stringAux = "hotel(es)";
                break;
            case "Piscina":
                stringAux = "piscina(s)";
                break;
            case "PistaDeportes":
                stringAux = "pista(s) de deportes";
                break;
        }

        System.out.println(getNombre()+ " ha vendido " + cantidad + " " + stringAux + " en " + nombreCasilla + ", y ha recibido "
                + dineroObtenido + " €. Quedan " + (numEdificiosExistentes-cantidad) + " " + stringAux + " en la propiedad.");
    }

    //Método auxiliar para comprobar si se pueden vender una cantidad determinada de edificios:
    private boolean sePuedeVenderEdificio(String edificio, int numExistentes, int numVender){

        //String Auxiliar dependiendo del edificio:
        String stringAux = "";
        switch (edificio){
            case "Casa":
                stringAux = "casa(s)";
                break;
            case "Hotel":
                stringAux = "hotel(es)";
                break;
            case "Piscina":
                stringAux = "piscina(s)";
                break;
            case "PistaDeportes":
                stringAux = "pista(s) de deportes";
                break;
        }

        if(numVender > numExistentes){
            System.out.println("No puedes vender " + numVender + " " + stringAux + ", solamente tienes " +
                    numExistentes + " " + stringAux + ".");
            return false;
        }
        else{
            return true;
        }
    }

    //Método para hipotecar una propiedad:
    public void hipotecarPropiedad(EstadoPartida estadoPartida){

        //Variables
        int i = 0;
        String casilla;
        Scanner scanner = new Scanner(System.in);
        Casilla casillaAux = null;

        //Check para que si no tienes propiedades ya no puedas edificar:
        if(getPropiedades().isEmpty()){
            System.out.println("No puedes hipotecar ninguna casilla ya que no tienes propiedades.");
            return;
        }

        //Menu para indicar de que GrupoSolar quieres vender:
        System.out.println("Indica en que casilla quieres hipotecar: ");
        casilla = scanner.next();

        //Chequeamos que sea una casilla existente:
        for (i = 0; i < 40; i++){
            if (estadoPartida.getTablero().getCasilla(i).getNombreCasilla().equals(casilla)){
                casillaAux = estadoPartida.getTablero().getCasilla(i);
                break;
            }
        }
        //Si no se ha encontrado la casilla por la que se pregunta:
        if (casillaAux == null){
            System.out.println("La casilla seleccionada no existe.");
            return;
        }

        //Chequeamos que sea GrupoSolar, GrupoTransporte o GrupoServicios
        switch(casillaAux.getGrupoCasilla()){
            case "Solar":
                //Chequeamos que el solar sea del jugador a vender:
                if (!casillaAux.getGrupoSolar().getPropietario().equals(this)){
                    System.out.println("No puedes hipotecar el solar seleccionado porque no te pertenece.");
                    return;
                }
                //Chequeamos que la propiedad no tenga edificios:
                if(!casillaAux.getGrupoSolar().getEdificaciones().esVacioEdificaciones()){
                    System.out.println("No puedes hipotecar el solar seleccionado porque todavía tiene edificios" +
                            " construidos. Véndelos antes de hipotecar.");
                    return;
                }
                //Chequeamos que la casilla no esté ya hipotecada
                if(casillaAux.getGrupoSolar().getEsHipotecada()){
                    System.out.println("No puedes hipotecar el solar seleccionado: ya ha sido hipotecado previamente.");
                    return;
                }
                //Se han pasado todos los checks, procedemos a hipotecar:
                //Atributo
                casillaAux.getGrupoSolar().setEsHipotecada(true);

                //Damos el dinero al jugador:
                dinero = dinero + (casillaAux.getGrupoSolar().getValor()/2);

                //Printeamos:
                System.out.println("Has hipotecado la casilla " + casillaAux.getNombreCasilla() + ", y has recibido " +
                        (casillaAux.getGrupoSolar().getValor()/2) + " €. Ahora ya no puedes cobrar alquileres en esta" +
                        " casilla ni construir edificios.");
                return;

            case "Transporte":
                //Chequeamos que el transporte sea del jugador a vender:
                if (!casillaAux.getGrupoTransporte().getPropietario().equals(this)){
                    System.out.println("No puedes hipotecar la casilla de transporte seleccionada porque no te pertenece.");
                    return;
                }
                //Chequeamos que la casilla no esté ya hipotecada
                if(casillaAux.getGrupoTransporte().getEsHipotecada()){
                    System.out.println("No puedes hipotecar la casilla de transporte seleccionada: ya ha sido hipotecado previamente.");
                    return;
                }
                //Se han pasado todos los checks, procedemos a hipotecar:
                //Atributo
                casillaAux.getGrupoTransporte().setEsHipotecada(true);

                //Damos el dinero al jugador:
                dinero = dinero + (casillaAux.getGrupoTransporte().getValor()/2);

                //Printeamos:
                System.out.println("Has hipotecado la casilla " + casillaAux.getNombreCasilla() + ", y has recibido " +
                        (casillaAux.getGrupoTransporte().getValor()/2) + " €. Ahora ya no puedes cobrar alquileres en esta" +
                        " casilla.");
                return;

            case "Servicios":
                //Chequeamos que el solar sea del jugador a vender:
                if (!casillaAux.getGrupoServicios().getPropietario().equals(this)){
                    System.out.println("No puedes hipotecar la casilla de servicios seleccionada porque no te pertenece.");
                    return;
                }
                //Chequeamos que la casilla no esté ya hipotecada
                if(casillaAux.getGrupoServicios().getEsHipotecada()){
                    System.out.println("No puedes hipotecar la casilla de servicios seleccionada: ya ha sido hipotecado previamente.");
                    return;
                }
                //Se han pasado todos los checks, procedemos a hipotecar:
                //Atributo
                casillaAux.getGrupoServicios().setEsHipotecada(true);

                //Damos el dinero al jugador:
                dinero = dinero + (casillaAux.getGrupoServicios().getValor()/2);

                //Printeamos:
                System.out.println("Has hipotecado la casilla " + casillaAux.getNombreCasilla() + ", y has recibido " +
                        (casillaAux.getGrupoServicios().getValor()/2) + " €. Ahora ya no puedes cobrar alquileres en esta" +
                        " casilla.");
                return;


            default:
                System.out.println("No se puede hipotecar la casilla seleccionada ya que no es ni una casilla de solar, " +
                        "ni una casilla de transporte ni una casilla de servicios.");
                return;

        }
    }

    //Método sobrecargado para hipotecar propiedad según nombre:
    public void desHipotecarPropiedad(EstadoPartida estadoPartida){

        //Variables
        int i = 0;
        int flag = 0;
        String casilla;
        Scanner scanner = new Scanner(System.in);
        Casilla casillaAux = null;
        int coste = 0;

        //Check por si no tienes propiedades:
        if(getPropiedades().isEmpty()){
            System.out.println("No puedes deshipotecar ninguna casilla ya que no tienes propiedades.");
            return;
        }

        //Si tienes propiedades, se chequea que tengas alguna hipotecada:
        for (i = 0; i < getPropiedades().size(); i++){
            switch (getPropiedades().get(i).getGrupoCasilla()){
                case "Solar":
                    if(getPropiedades().get(i).getGrupoSolar().getEsHipotecada()) flag = 1;
                    break;
                case "Transporte":
                    if(getPropiedades().get(i).getGrupoTransporte().getEsHipotecada()) flag = 1;
                    break;
                case "Servicios":
                    if(getPropiedades().get(i).getGrupoServicios().getEsHipotecada()) flag = 1;
                    break;
            }
        }
        if (flag!=1){
            System.out.println("No puedes deshipotecar ninguna de tus casillas ya que ninguna ha sido hipotecada.");
        }

        //Menu para indicar que casilla deseas deshipotecar
        System.out.println("Indica en que casilla quieres deshipotecar: ");
        casilla = scanner.next();

        //Encontramos la casilla seleccionada:
        for (i = 0; i < 40; i++){
            if (estadoPartida.getTablero().getCasilla(i).getNombreCasilla().equals(casilla)){
                casillaAux = estadoPartida.getTablero().getCasilla(i);
                break;
            }
        }
        //Si no se ha encontrado la casilla por la que se pregunta:
        if (casillaAux == null){
            System.out.println("La casilla seleccionada no existe.");
            return;
        }

        //Chequeamos que la casilla seleccionada este hipotecada, calculamos coste, cobramos y printeamos:
        switch (casillaAux.getGrupoCasilla()){
            case "Solar":
                //Hipotecada?
                if (!casillaAux.getGrupoSolar().getEsHipotecada()){
                    System.out.println("El solar seleccionado no está hipotecado.");
                    return;
                }
                //Calculamos precio y chequeamos que el jugador lo pueda pagar:
                coste = (int)(((float)(casillaAux.getGrupoSolar().getValor() / 2)) * 1.1);
                if (getDinero()<coste){
                    System.out.println("No puedes deshipotecar el solar seleccionado, hacerlo vale " + coste + " €, y" +
                            " solamente tienes "+ getDinero() + " €.");
                    return;
                }
                //Si se pasan todos los checks, cobramos y deshipotecamos:
                setDinero(getDinero() - coste);
                casillaAux.getGrupoSolar().setEsHipotecada(false);
                System.out.println("Has deshipotecado el solar  " + casillaAux.getNombreCasilla() + ", y has" +
                        " pagado " + coste + " €, con lo que te quedan " + getDinero() + " €. Puedes volver a cobrar alquileres" +
                        " y a edificar en este solar.");
                return;

            case "Transporte":
                //Hipotecada?
                if (!casillaAux.getGrupoTransporte().getEsHipotecada()){
                    System.out.println("La casilla de transporte seleccionada no está hipotecada.");
                    return;
                }
                //Calculamos precio y chequeamos que el jugador lo pueda pagar:
                coste = (int)(((float)(casillaAux.getGrupoTransporte().getValor() / 2)) * 1.1);
                if (getDinero()<coste){
                    System.out.println("No puedes deshipotecar la casilla de transporte seleccionada, hacerlo vale " + coste + " €, y" +
                            " solamente tienes "+ getDinero() + " €.");
                    return;
                }
                //Si se pasan todos los checks, cobramos y deshipotecamos:
                setDinero(getDinero() - coste);
                casillaAux.getGrupoTransporte().setEsHipotecada(false);
                System.out.println("Has deshipotecado la casilla de transporte " + casillaAux.getNombreCasilla() + ", y has" +
                        " pagado " + coste + " €, con lo que te quedan " + getDinero() + " €. Puedes volver a cobrar alquileres" +
                        " en esta casilla de transporte.");
                return;

            case "Servicios":
                //Hipotecada?
                if (!casillaAux.getGrupoServicios().getEsHipotecada()){
                    System.out.println("La casilla de servicios seleccionada no está hipotecada.");
                    return;
                }
                //Calculamos precio y chequeamos que el jugador lo pueda pagar:
                coste = (int)(((float)(casillaAux.getGrupoServicios().getValor() / 2)) * 1.1);
                if (getDinero()<coste){
                    System.out.println("No puedes deshipotecar la casilla de servicios seleccionada, hacerlo vale " + coste + " €, y" +
                            " solamente tienes "+ getDinero() + " €.");
                    return;
                }
                //Si se pasan todos los checks, cobramos y deshipotecamos:
                setDinero(getDinero() - coste);
                casillaAux.getGrupoServicios().setEsHipotecada(false);
                System.out.println("Has deshipotecado la casilla de servicios " + casillaAux.getNombreCasilla() + ", y has" +
                        " pagado " + coste + " €, con lo que te quedan " + getDinero() + " €. Puedes volver a cobrar alquileres" +
                        " en esta casilla de servicios.");
                return;
        }
    }

    //TODO: El método solo sirve para declararse en bancarrota, necesitamos agregar cuando llamarlo y dónde, asi como
    //TODO: llamar tambien a hipótecar y a vender edificios.
    //Método para declararse en bancarrota con la banca:
    void entrarBancarrotaBanca(EstadoPartida estadoPartida){

        //Pasamos las propiedades a la banca
        pasarPropiedades(EstadoPartida.getBanca(), "Todas");

        //Imprimimos mensaje
        System.out.println("El jugador " + this.getNombre() + " ha entrado en bancarrota. Todas sus propiedades han sido" +
                " devueltas a la Banca y puestas a la venta nuevamente.");

        //Eliminamos al jugador
        estadoPartida.getJugadores().remove(this);
        estadoPartida.setNumeroJugadores(estadoPartida.getNumeroJugadores()-1);

        //COMPROBAR SI SOLO QUEDA UN JUGADOR EN LA PARTIDA
        estadoPartida.ganarPartida();

    }

    //Método para declararse en bancarrota con un jugador:
    void entrarBancarrotaJugador(EstadoPartida estadoPartida, Jugador destinatario){

        //Pasamos las propiedades al jugador
        pasarPropiedades(destinatario, "Todas");

        //Imprimimos mensaje
        System.out.println("El jugador " + this.getNombre() + " ha entrado en bancarrota. Todas sus propiedades han sido" +
                " transpasadas al jugador " + destinatario.getNombre() + ".");

        //Eliminamos al jugador
        estadoPartida.getJugadores().remove(this);

        //COMPROBAR SI SOLO QUEDA UN JUGADOR EN LA PARTIDA
        estadoPartida.ganarPartida();

    }

    //Método auxiliar para pasar propiedades de un jugador a otro:
    void pasarPropiedades(Jugador destinatario, String propiedadString){

        //Variables
        int i = 0;

        //CASO 1: Queremos pasar todas las propiedades:
        if (propiedadString.equals("Todas")){
            //Añadimos todas las propiedades:
            destinatario.getPropiedades().addAll(this.getPropiedades());
            //Eliminamos las propiedades del jugador original:
            this.getPropiedades().clear();
        }

        //CASO 2: Queremos transpasar una propiedad en concreto:
        else{
            //Movemos la propiedad:

        }

    }




}