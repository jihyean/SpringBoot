package com.jhyun.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterfaceMemberDAO {
	public List<MemberDTO> selectAll(MemberDTO mDTO);
	public MemberDTO selectOne(Map<String, String> map);
	public boolean insert(MemberDTO mDTO);
	public boolean update(MemberDTO mDTO);
	public boolean delete(MemberDTO mDTO);
}
