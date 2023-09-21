package com.jhyun.app;

import java.util.List;

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
		// TODO Auto-generated method stub
		return mDAO.selectOne(mDTO);
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
