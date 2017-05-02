/**
 * This file was generated by the Jeddict
 */
package entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author aluno
 */
@Entity
public class Acompanhamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dtacompanhamento;

    @Column
    private String descricao;

    @OneToOne(targetEntity = Franquia.class)
    private Franquia franquia;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtacompanhamento() {
        return this.dtacompanhamento;
    }

    public void setDtacompanhamento(Date dtacompanhamento) {
        this.dtacompanhamento = dtacompanhamento;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Franquia getFranquia() {
        return this.franquia;
    }

    public void setFranquia(Franquia franquia) {
        this.franquia = franquia;
    }

}
