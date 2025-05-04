package fechasfestivas.api.dominio.entidades;

import org.hibernate.annotations.GenericGenerator;


import jakarta.persistence.*;

@Entity
@Table(name = "Tipo")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_tipo")
    @GenericGenerator(name="secuencia_tipo", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "tipo", length = 100, nullable = false)
    private String tipo;

    public Tipo() {
    }

    public Tipo(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   

    

}
