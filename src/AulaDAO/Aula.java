package AulaDAO;

public class Aula {
    private int id ;

    private  String denominacion;


    public Aula(String denominacion , int id ) {
        this.denominacion=denominacion;
        this.id=id;
    }

    public Aula() {

    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    public int getId() {
        return id;
    }

    public void setId(int  id) {
        this.id = id;
    }
}
