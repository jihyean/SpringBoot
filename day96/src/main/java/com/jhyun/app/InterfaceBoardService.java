package com.jhyun.app;

import java.util.List;
import java.util.Map;

public interface InterfaceBoardService {
	List<BoardDTO> selectAll(BoardDTO bDTO);
	BoardDTO selectOne(BoardDTO bDTO);
	boolean insert(BoardDTO bDTO);
	boolean update(BoardDTO bDTO);
	boolean delete(BoardDTO bDTO);
}
