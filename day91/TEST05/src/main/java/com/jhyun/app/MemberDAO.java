package com.jhyun.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	// 의존관계(멤버변수)
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 응집도를 높여줌
	private final String SQL_SELECTALL ="SELECT * FROM MEMBER"; 
	private final String SQL_SELECTONE_LOGIN ="SELECT * FROM MEMBER WHERE MID = ? AND MPW = ? ";
	private final String SQL_SELECTONE ="SELECT * FROM MEMBER WHERE MID = ? ";
	private final String SQL_INSERT ="INSERT INTO MEMBER (MID, MPW) VALUES(?,?) ";
	private final String SQL_UPDATE ="UPDATE MEMBER SET MPW = ? WHERE MID = ? ";
	private final String SQL_DELETE ="DELETE FROM MEMBER WHERE MID = ? ";
	
	
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		// 반복적인 로직을 대신 수행하는 "템플릿 패턴"을 활용
		//jdbcTemplate.query(SQL_SELECTALL, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		
		return jdbcTemplate.query(SQL_SELECTALL, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	
	public MemberDTO selectOne(MemberDTO mDTO) {
		try {
			if(mDTO.getMSearch().equals("로그인")) {
				Object[] args = { mDTO.getMid(), mDTO.getMpw() };
				return jdbcTemplate.queryForObject(SQL_SELECTONE_LOGIN, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			}
			else {// 존재확인
				Object[] args = { mDTO.getMid() };
				return jdbcTemplate.queryForObject(SQL_SELECTONE, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			}
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public boolean insert(MemberDTO mDTO) {
		int result = jdbcTemplate.update(SQL_INSERT, mDTO.getMid(), mDTO.getMpw());

		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean update(MemberDTO mDTO) {
		int result = jdbcTemplate.update(SQL_UPDATE, mDTO.getMpw(), mDTO.getMid());

		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean delete(MemberDTO mDTO) {
		int result = jdbcTemplate.update(SQL_DELETE, mDTO.getMid());

		if(result <= 0) {
			return false;
		}
		return true;
	}

}
