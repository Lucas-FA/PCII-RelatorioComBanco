package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteJdbcDAO {
    private Connection conn;
	
	public ClienteJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Cliente> listar() {
		String sql = "select * from cliente";
        System.out.println(sql);		
        List<Cliente> cliente = new ArrayList<Cliente>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				//c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setComplemento(rs.getString("complemento"));
				c.setUf(rs.getString("uf"));
				c.setTelefone(rs.getString("telefone"));
				cliente.add(c);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
}
