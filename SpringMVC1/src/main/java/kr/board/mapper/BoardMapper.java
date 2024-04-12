package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;

@Mapper //- Mybatis API
//구현 클래스가 SqlSessinFactoryBean 에 만들어짐
public interface BoardMapper {
	public List<Board> getLists();//전체리스트
	public void boardInsert(Board vo);
	public Board boardContent(int idx);
	public void boardDelete(int idx);
	public void boardUpdate(Board vo);
	
	@Update("update my_board set count=count+1 where idx=#{idx}")
	public void boardCount(int idx);
	
}	
