package com.jhyun.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	
	// 의존관계(멤버변수)
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 응집도를 높여줌
	private final String SQL_SELECTALL ="SELECT * FROM BOARD"; 
	private final String SQL_SELECTONE ="SELECT * FROM BOARD WHERE BID = ? ";
	private final String SQL_INSERT ="INSERT INTO BOARD (MID, CONTENT) VALUES(?,?) ";
	private final String SQL_UPDATE ="UPDATE BOARD SET CONTENT = ? WHERE BID = ? ";
	private final String SQL_UPDATE_NAME ="UPDATE BOARD SET MID = '탈퇴회원' WHERE MID = ? "; 
	private final String SQL_DELETE ="DELETE FROM BOARD WHERE BID = ? ";
	
	
	public List<BoardDTO> selectAll(BoardDTO bDTO) {
		// 반복적인 로직을 대신 수행하는 "템플릿 패턴"을 활용
		//jdbcTemplate.query(SQL_SELECTALL, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		
		return jdbcTemplate.query(SQL_SELECTALL, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	public BoardDTO selectOne(BoardDTO bDTO) {
		try {
			Object[] args = { bDTO.getBid()};
			return jdbcTemplate.queryForObject(SQL_SELECTONE, args, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public boolean insert(BoardDTO bDTO) {
		int result = jdbcTemplate.update(SQL_INSERT, bDTO.getMid(), bDTO.getContent());

		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean update(BoardDTO bDTO) {
		int result;
		if(bDTO.getSearch().equals("회원탈퇴")) {
			result = jdbcTemplate.update(SQL_UPDATE_NAME, bDTO.getMid());
		}
		else { // 수정
			result = jdbcTemplate.update(SQL_UPDATE, bDTO.getContent(), bDTO.getBid());
		}
		
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean delete(BoardDTO bDTO) {
		int result = jdbcTemplate.update(SQL_DELETE, bDTO.getBid());

		if(result <= 0) {
			return false;
		}
		return true;
	}

}
