/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.model;

import com.google.gson.annotations.SerializedName;
import static com.oracle.webservices.internal.api.databinding.DatabindingModeFeature.ID;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*; 
/**
 *
 * @author Leandro 
 */
@Entity
@Table(name = "receita")
public class Receita implements Serializable{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     public int id ;

     @Column(name = "receitas")
    public String receitas ;

    @Column(name = "medico")
    public String  medico;

    @Column(name = "paciente")
    public String paciente;

    public Receita() {
    }

    public Receita(int Id, String receitas, String medico, String paciente) {
        this.id = Id;
        this.receitas = receitas;
        this.medico = medico;
        this.paciente = paciente;
    }

    public long getId() {
        return id;
    }

    public void setId(int Id) { 
        this.id = Id;
    }

    public String getReceitas() {
        return receitas;
    }

    public void setReceitas(String receitas) {
        this.receitas = receitas;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString(){
        return "Receita("+ 
            "id=" + id +
            ", receitas='" + receitas +'\'' +
            ", medico='" + medico +'\'' +
            ", paciente='" + paciente +'\'' +
            ')';
    }
    
    



}
