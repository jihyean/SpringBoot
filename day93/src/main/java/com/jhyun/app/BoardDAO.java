package com.jhyun.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements InterfaceBoardDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SELECTALL="SELECT * FROM BOARD ORDER BY BID DESC";
	private final String SELECTONE="SELECT * FROM BOARD WHERE BID=?";
	private final String INSERT="INSERT INTO BOARD VALUES((SELECT NVL(MAX(BID),100)+1 FROM BOARD),?,?)";
	private final String UPDATE="UPDATE BOARD SET CONTENT=? WHERE BID=?";
	private final String DELETE="DELETE FROM BOARD WHERE BID=?";

	@Override
	public List<BoardDTO> selectAll(BoardDTO bDTO) {
		return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	@Override
	public BoardDTO selectOne(BoardDTO bDTO) {
		Object[] args= { bDTO.getBid() };
		try {
			return jdbcTemplate.queryForObject(SELECTONE, args, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		}
		catch(Exception e) {
			return null;
		}
	}
	@Override
	public boolean insert(BoardDTO bDTO) {
		int result=jdbcTemplate.update(INSERT, bDTO.getMid(), bDTO.getContent());
		return result>0 ? true : false;
	}
	@Override
	public boolean update(BoardDTO bDTO) {
		int result=jdbcTemplate.update(UPDATE, bDTO.getContent(), bDTO.getBid());
		return result>0 ? true : false;
	}
	@Override
	public boolean delete(BoardDTO bDTO) {
		int result=jdbcTemplate.update(DELETE, bDTO.getBid());
		return result>0 ? true : false;
	}

}
