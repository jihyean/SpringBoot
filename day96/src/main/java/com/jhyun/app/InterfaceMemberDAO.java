package com.jhyun.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterfaceMemberDAO {
	public List<MemberDTO> selectAll(MemberDTO mDTO);
	public MemberDTO selectOne(Map<String, String> map);
	public boolean insert(Map<String, String> map);
	public boolean update(Map<String, String> map);
	public boolean delete(String mid);
}
