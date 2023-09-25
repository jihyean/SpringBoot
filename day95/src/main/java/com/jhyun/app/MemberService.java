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
		map.put("data1", mDTO.getMid());
		map.put("data2", mDTO.getMpw());
		return mDAO.selectOne(map);
	}

	@Override
	public boolean insert(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.insert(mDTO);
	}

	@Override
	public boolean update(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.update(mDTO);
	}

	@Override
	public boolean delete(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.delete(mDTO);
	}

}
