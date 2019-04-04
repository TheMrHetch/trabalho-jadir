package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.bean.Aluno;
import br.edu.unicid.util.ConnectionFactory;

public class AlunoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public AlunoDAO(Connection conn)
	{
		this.conn = conn;
	}
	
	public void salvar(Aluno aluno) throws SQLException {
		ps = conn.prepareStatement("INSERT INTO aluno VALUES(?,?,?,?,?,?)");
		if (aluno != null) {
			ps.setInt(1, aluno.getRgm());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.setDate(4, aluno.getNascimento());
			ps.setInt(5, aluno.getIdade());
			ps.setString(6, aluno.getEndereco());
			
			System.out.println("Executado " + ps.executeUpdate() + " linha(s)"
					+ " modificada(s)");
			ConnectionFactory.close(conn, ps);
		}
	}
	
	public void modificar(Aluno aluno) throws SQLException
	{
		ps = conn.prepareStatement("UPDATE aluno SET nome=?,email=?,"
				+ "nascimento=?,idade=?,endereco=? WHERE rgm=?");
		if (aluno != null) {
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getEmail());
			ps.setDate(3, aluno.getNascimento());
			ps.setInt(4, aluno.getIdade());
			ps.setString(5, aluno.getEndereco());
			ps.setInt(6, aluno.getRgm());
			
			System.out.println("Executado " + ps.executeUpdate() + " linha(s)"
					+ " modificada(s)");
			
			ConnectionFactory.close(conn, ps);
		}
	}
	
	public void apagar(Aluno aluno) throws SQLException {
		ps = conn.prepareStatement("DELETE FROM aluno WHERE rgm=?");
		ps.setInt(1, aluno.getRgm());
		
		System.out.println("Executado " + ps.executeUpdate() + " linha(s)"
				+ " modificada(s)");
		
		ConnectionFactory.close(conn, ps);
	}
	
	public Aluno procurar(Integer rgm) throws SQLException {
		ps = conn.prepareStatement("SELECT * FROM aluno WHERE rgm=?");
		ps.setInt(1, rgm);
		
		rs = ps.executeQuery();
		Aluno al = null;
		if(rs.next()) {
			al = new Aluno(
					rs.getInt("rgm"),
					rs.getString("nome"),
					rs.getString("email"),
					rs.getDate("nascimento"),
					rs.getInt("idade"),
					rs.getString("endereco")
				);	
		}
		
		ConnectionFactory.close(conn, ps, rs);
		return al != null ? al : null;
	}
	
	public List<Aluno> buscaTodosAlunos() throws SQLException {
		ps = conn.prepareStatement("SELECT * FROM aluno");
		rs = ps.executeQuery();
		
		List<Aluno> list = new ArrayList<>();
		
		while (rs.next()) {
			list.add(new Aluno(
					rs.getInt("rgm"),
					rs.getString("nome"),
					rs.getString("email"),
					rs.getDate("nascimento"),
					rs.getInt("idade"),
					rs.getString("endereco")
			));
			
//			rs.next();
		}
		ConnectionFactory.close(conn, ps, rs);
		return list;	
	}
	
}
