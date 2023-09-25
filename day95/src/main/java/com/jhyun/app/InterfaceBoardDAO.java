package com.jhyun.app;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterfaceBoardDAO {
	public List<BoardDTO> selectAll(BoardDTO bDTO);
	public BoardDTO selectOne(int bid); // #{param1}
	public boolean insert(BoardDTO bDTO);
	public boolean update(BoardDTO bDTO);
	public boolean delete(@Param("BID")int bid); // #{BID}
}
