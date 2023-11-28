package paquetePartida;

public class Turno {

    //ATRIBUTO
    private int numTurno;

    //GETTERS
    public int getNumTurno() {
        return numTurno;
    }

    //SETTERS
    public void setNumTurno(int numTurno) {
        //CHECKEO DE QUE EL TURNO NO PUEDE SER NEGATIVO
        if(numTurno < 0){
            //Imprimir que el turno no uede ser negativo
            System.out.println("Error, el turno no puede ser negativo.");
            this.numTurno = 0;
        }
        this.numTurno = numTurno;
    }

    //CONSTRUCTOR
    public Turno(){
        setNumTurno(0);
    }

    //Constructor por si queremos introducir un turno determinado:
    public Turno(int numTurno){setNumTurno(numTurno);}

    //MÉTODOS
    //MÉTODO ACTUALIZAR TURNO
    public void actualizarTurno(){
        setNumTurno(getNumTurno() + 1);
    }




}
