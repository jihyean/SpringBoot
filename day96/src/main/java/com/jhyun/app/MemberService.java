package com.jhyun.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements InterfaceMemberService {

	@Autowired
	private InterfaceMemberDAO mDAO;
	
	@Override
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.selectAll(mDTO);
	}

	@Override
	public MemberDTO selectOne(MemberDTO mDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mid", mDTO.getMid());
		map.put("mpw", mDTO.getMpw());
		map.put("mSearch", mDTO.getMSearch());
		return mDAO.selectOne(map);
	}

	@Override
	public boolean insert(MemberDTO mDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mid", mDTO.getMid());
		map.put("mpw", mDTO.getMpw());
		return mDAO.insert(map);
	}

	@Override
	public boolean update(MemberDTO mDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mid", mDTO.getMid());
		map.put("mpw", mDTO.getMpw());
		return mDAO.update(map);
	}

	@Override
	public boolean delete(MemberDTO mDTO) {
		return mDAO.delete(mDTO.getMid());
	}

}
