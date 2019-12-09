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
import javax.enterprise.inject.Default;
import javax.inject.Inject;



/**
 *
 * @author wolley
 */
@Default
public class ClienteDAO {
   @Inject 
   private Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ClienteDAO() {
        this(null); //CDI
    }
    

    public void cadastrar(Cliente cliente){
        
        try{      

            String sql = "INSERT INTO cliente (nome, cpf, telefone, endereco) VALUES (?,?,?,?)";
            
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.execute();
            

            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    
    
    
    public List<Cliente> lista(){

        try{
            
     
            
            String sql="SELECT * FROM cliente";
            
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            ResultSet rs =  pstmt.executeQuery();
            
            List<Cliente> listaCliente = new ArrayList<Cliente>();
            
            while(rs.next()){
                Cliente novoCliente = new  Cliente();
                novoCliente.setId(rs.getInt("id"));
                novoCliente.setNome(rs.getString("nome"));
                novoCliente.setCpf(rs.getString("cpf"));
                novoCliente.setTelefone(rs.getString("telefone"));
                novoCliente.setEndereco(rs.getString("endereco"));
                
                listaCliente.add(novoCliente);
                
            }

          return listaCliente;
          
          
          
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }
    
    
    
    public Cliente pesquisaPorId(Cliente cliente){
        try{
            
            
            String sql="SELECT * FROM cliente WHERE id=?";
       
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, cliente.getId());
            ResultSet  rs= pstmt.executeQuery();
            
            Cliente clienteConsulta = new Cliente();
            while(rs.next()){
                clienteConsulta.setId(rs.getInt("id"));
                clienteConsulta.setNome(rs.getString("nome"));
                clienteConsulta.setTelefone(rs.getString("telefone"));
                clienteConsulta.setEndereco(rs.getString("endereco"));
                clienteConsulta.setCpf(rs.getString("cpf"));
            }
            
            return clienteConsulta;
            
        }catch(Exception e){
            throw  new RuntimeException(e);
        }
    }
    
    
    
      public  void atualizar(Cliente cliente) {
        
       
       try{
           
           String sql = "UPDATE cliente SET nome=?, cpf=?, telefone=?, endereco=? WHERE id=?";
           
    
           PreparedStatement pstmt = conexao.prepareStatement(sql);
           pstmt.setString(1, cliente.getNome());
           pstmt.setString(2, cliente.getCpf());
           pstmt.setString(3, cliente.getTelefone());
           pstmt.setString(4, cliente.getEndereco());
           pstmt.setInt(5, cliente.getId());
           
           pstmt.executeUpdate();
           
           
           
           
           
           
       }catch(Exception e){
           throw  new RuntimeException(e);
       }
       
       
       
    }
      
      public  void excluir(Cliente cliente) {
    
         
       try{
           
           String sql = "DELETE FROM cliente WHERE id=?";
           
 
           PreparedStatement pstmt = conexao.prepareStatement(sql); 
           pstmt.setInt(1, cliente.getId());
           
           pstmt.execute();

           
       }catch(Exception e){
           throw  new RuntimeException(e);
       }
       
       
    }
    
    
    
    
    
}
