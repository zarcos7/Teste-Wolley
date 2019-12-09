/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.umc.model.Cliente;
import br.umc.model.Medico;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 *
 * @author Leandro
 */
@Default
public class MedicoDAO {
    
     @Inject 
   private Connection conexao;

    public MedicoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public MedicoDAO() {
        this(null); //CDI
    }
    

    public void cadastrar(Medico medico){
        
        try{      

            String sql = "INSERT INTO cliente (nome, cpf, telefone, endereco, crm) VALUES (?,?,?,?,?)";
            
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getCpf());
            pstmt.setString(3, medico.getTelefone());
            pstmt.setString(4, medico.getEndereco());
            pstmt.setString(5, medico.getCrm());
            pstmt.execute();
            

            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    
    
    
    public List<Medico> lista(){

        try{
            
     
            
            String sql="SELECT * FROM medico";
            
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            ResultSet rs =  pstmt.executeQuery();
            
            List<Medico> listaMedico = new ArrayList<Medico>();
            
            while(rs.next()){
                Medico novoMedico = new  Medico();
                novoMedico.setId(rs.getInt("id"));
                novoMedico.setNome(rs.getString("nome"));
                novoMedico.setCpf(rs.getString("cpf"));
                novoMedico.setTelefone(rs.getString("telefone"));
                novoMedico.setEndereco(rs.getString("endereco"));
                novoMedico.setCrm(rs.getString("crm"));
                
                
                listaMedico.add(novoMedico);
                
            }

          return listaMedico;
          
          
          
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }
    
    
    
    public Medico pesquisaPorId(Medico medico){
        try{
            
            
            String sql="SELECT * FROM medico WHERE id=?";
       
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(6, medico.getCrm());
            ResultSet  rs= pstmt.executeQuery();
            
            Medico medicoConsulta = new Medico();
            while(rs.next()){
                medicoConsulta.setId(rs.getInt("id"));
                medicoConsulta.setNome(rs.getString("nome"));
                medicoConsulta.setCpf(rs.getString("cpf"));
                medicoConsulta.setTelefone(rs.getString("telefone"));
                medicoConsulta.setEndereco(rs.getString("endereco"));
                medicoConsulta.setCrm(rs.getString("crm"));
            }
            
            return medicoConsulta;
            
        }catch(Exception e){
            throw  new RuntimeException(e);
        }
    }
    
    
    
      public  void atualizar(Medico medico) {
        
       
       try{
           
           String sql = "UPDATE medico SET nome=?, cpf=?, telefone=?, endereco=? WHERE id=?";
           
    
           PreparedStatement pstmt = conexao.prepareStatement(sql);
           pstmt.setString(1, medico.getNome());
           pstmt.setString(2, medico.getCpf());
           pstmt.setString(3, medico.getTelefone());
           pstmt.setString(4, medico.getEndereco());
           pstmt.setInt(5, medico.getId());
           
           pstmt.executeUpdate();
           
           
           
           
           
           
       }catch(Exception e){
           throw  new RuntimeException(e);
       }
       
       
       
    }
      
      public  void excluir(Medico medico) {
    
         
       try{
           
           String sql = "DELETE FROM medico WHERE crm=?";
           
 
           PreparedStatement pstmt = conexao.prepareStatement(sql); 
           pstmt.setString(6, medico.getCrm());
           
           pstmt.execute();

           
       }catch(Exception e){
           throw  new RuntimeException(e);
       }
       
       
    }
    
}
