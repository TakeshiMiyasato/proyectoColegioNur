package Notas;

public class Nota {
    private int id;
    private int estudianteId;
    private int materiaId;
    private int trimestre_1;
    private int trimestre_2;
    private int trimestre_3;
    private String nombreCompleto;

    public Nota(){
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }

    public int getTrimestre_1() {
        return trimestre_1;
    }

    public void setTrimestre_1(int trimestre_1) {
        this.trimestre_1 = trimestre_1;
    }

    public int getTrimestre_2() {
        return trimestre_2;
    }

    public void setTrimestre_2(int trimestre_2) {
        this.trimestre_2 = trimestre_2;
    }

    public int getTrimestre_3() {
        return trimestre_3;
    }

    public void setTrimestre_3(int trimestre_3) {
        this.trimestre_3 = trimestre_3;
    }
}
