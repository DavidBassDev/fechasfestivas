package fechasfestivas.api.dominio.entidades;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Festivo")
public class Festivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_festivo")
    @GenericGenerator(name="secuencia_festivo", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "dia", nullable = false)
    private int dia;
    @Column(name = "mes", nullable = false)
    private int mes;
    @Column(name = "diaspascua", nullable = false)
    private int diasPascua;
    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id", nullable = false)
    private Tipo idTipo;

    public Festivo() {
    }

    public Festivo(int id, String nombre, int dia, int mes, int diasPascua, Tipo idTipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        this.idTipo = idTipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(int diasPascua) {
        this.diasPascua = diasPascua;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
       this.idTipo = idTipo;
    }

   

}
