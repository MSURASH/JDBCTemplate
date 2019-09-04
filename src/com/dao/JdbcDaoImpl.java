package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.model.Team;

@Component
public class JdbcDaoImpl {
	
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	

//	public Team getTeam(int doco, int lnid) {
//		
//		Connection con = null;
//		try {
//		con = dataSource.getConnection();
//		String sql  = "select * from team where doco = ? and lnid = ?";
//		PreparedStatement ps =  con.prepareStatement(sql);
//		ps.setInt(1, doco);
//		ps.setInt(2, lnid);
//		Team team = null;
//
//		ResultSet rs = ps.executeQuery();
//		
//
//		if(rs.next()) {		
//			team = new Team(rs.getString("teams"), rs.getString("city"));
//		}
//		rs.close();
//		ps.close();
//		return team;
//		}
//		catch(Exception e) {
//			throw new RuntimeException(e);
//		}
//		finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	public List<Team> getTeamList(){
		String sql  = "select * from team order by teams";
		  List<Team> teams = jdbcTemplate.query(sql, new TeamMapper());
		  return teams;
	}
	
	
	
	public List<Team> getTeamId(int fromDoco, int toDoco){
		String sql  = "select * from team where doco between  ? and ? order by doco, lnid";
		  List<Team> teams = jdbcTemplate.query(sql, new Object[] {fromDoco,toDoco}, new TeamMapper());
		  return teams;
	}
	
	public String deleteTeam(int doco, int lnid) {
		String sql = "DELETE FROM Team WHERE doco=? and lnid=?";
		int update = jdbcTemplate.update(sql, new Object[] {doco, lnid});
		if(update == 1){
			return "Team is Deleted......";
		}else {
			return "No team exist";
		}
	}
	public String updateTeam(String teams, int doco, int lnid) {
		String sql = "UPDATE team set teams=? WHERE doco=? and lnid=?";
		int update = jdbcTemplate.update(sql, new Object[] {teams, doco, lnid});
		if(update == 1){
			return "Team is Updated....";
		}else {
			return "No team exist";
		}
	}
	
	public String updateTeam(String teams, String city, int doco, int lnid) {
		String sql = "UPDATE team set teams=?, city=? WHERE doco=? and lnid=?";
		int update = jdbcTemplate.update(sql, new Object[] {teams, city, doco, lnid});
		if(update == 1){
			return "Team is Updated....";
		}else {
			return "No team exist";
		}
	}
	
	public String createTeam(Team team) {
		String sql = "INSERT INTO team(doco,lnid,teams,city) VALUES(?,?,?,?)";
		int update = jdbcTemplate.update(sql, new Object[] {team.getDoco(), team.getLnid(), team.getTeams(), team.getCity()});
		
		if(update == 1){
			return "Team is created..";
		}else {
			return "No team created";
		}
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static final class TeamMapper implements RowMapper<Team>{

		@Override
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
			 Team team = new Team();
			 team.setDoco(rs.getInt("DOCO"));
			 team.setLnid(rs.getInt("LNID"));
			 team.setTeams(rs.getString("TEAMS"));
			 team.setCity(rs.getString("CITY"));

		        return team;

		}
		
	}
}
