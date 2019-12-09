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
public class ReceitaDAO {
    
    @Inject 
   private Connection conexao;
    
   
}
