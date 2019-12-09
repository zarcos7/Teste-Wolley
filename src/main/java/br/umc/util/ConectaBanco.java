/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

/**
 *
 * @author wolley
 */
public class ConectaBanco {

    @Produces
    @RequestScoped
    public Connection getConexao() {
        try {
            System.out.println("abre conexao......");
            Class.forName("org.postgresql.Driver");
            //local do banco                              //usuario  //senha
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbcliente", "postgres", "postgres"); //retorna um Connection

        } catch (Exception e) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    public void fecha(@Disposes Connection conexao) {
        try {
            System.out.println("fecha conexao......");
            conexao.close();
        } catch (SQLException e) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }
}
