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
    @Column(name = "Nombre", length = 100)
    private String nombre;
    @Column(name = "Dia")
    private int dia;
    @Column(name = "Mes")
    private int mes;
    @Column(name = "DiasPascua")
    private int diasPascua;
    @ManyToOne
    @JoinColumn(name = "IdTipo", referencedColumnName = "id")
    private Tipo IdTipo;

    public Festivo() {
    }

    public Festivo(int id, String nombre, int dia, int mes, int diasPascua, Tipo idTipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        IdTipo = idTipo;
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
        return IdTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        IdTipo = idTipo;
    }

   

}
