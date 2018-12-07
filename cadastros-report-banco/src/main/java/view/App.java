package view;

import java.sql.Connection;
import java.util.List;

import controller.ClienteJdbcDAO;
import controller.JdbUtil;
import model.Cliente;
import report.ClienteREL;

public class App 
{
    public static void main( String[] args )
    {
    	try{
    		Connection conn = JdbUtil.getConnection();
			ClienteJdbcDAO clienteJdbcDAO = new ClienteJdbcDAO(conn);

			List<Cliente> cliente = clienteJdbcDAO.listar();

			ClienteREL relatorio = new ClienteREL();
			relatorio.imprimir(cliente);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
    }
}
