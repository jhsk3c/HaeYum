package Repository.Vspot;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.ShopDTO;
import Model.DTO.ShopReviewDTO;
import Model.DTO.SpotReviewDTO;
import Model.DTO.StartEndPageDTO;
import Model.DTO.VspotDTO;

@Repository
public class VspotRepository {

	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "spotMapper";

	
	public Integer vspotInsert(VspotDTO spot) { //휴양지 등록 
		String statement = namespace + ".vspotInsert";
		return sqlSession.insert(statement, spot);
	}


	public List<VspotDTO> memList() { //휴양지 리스틑 뽑기.
		String statement = namespace + ".memList";
		return sqlSession.selectList(statement);
	}


	public VspotDTO listDetail(VspotDTO vspot) { //휴양지 디테일(리스트에서 누르면)
		String statement = namespace + ".listDetail";
		return sqlSession.selectOne(statement, vspot);
		
	}


	public VspotDTO insertList(VspotDTO vdto) { //후기 작성을 위한 num값 찾기.
		String statement = namespace + ".insertList";
		return sqlSession.selectOne(statement, vdto);
		
	}


	public Integer insert(SpotReviewDTO srdto) { //후기 등록.
		String statement = namespace + ".insert";
		return sqlSession.insert(statement, srdto);
		
	}


	public List<SpotReviewDTO> listReview(String vspotNum, int page, int limit) { // 후기 내용을 디테일에 출력하기 (페이징은 일단 뽑고 => 그다음 페이징 => 그다음 평점 )
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		Integer su1 = Integer.parseInt(vspotNum);
		StartEndPageDTO spage = new StartEndPageDTO(startRow, endRow, su1);
		String statement = namespace + ".listReview";
		return sqlSession.selectList(statement, spage);
	}


	public Integer listReviewCount(SpotReviewDTO srto) { //후기 개수 나오는것.
		String statement = namespace + ".listReviewCount";
		return sqlSession.selectOne(statement, srto);
	}


	public VspotDTO jointest(VspotDTO vdto) { // 아직은 안씀..
		String statement = namespace + ".jointest";
		return sqlSession.selectOne(statement, vdto);
		
	}


	public List<ShopDTO> listShop(ShopDTO sdto) { //디테일에 추천 상점 나타내는 것.
		String statement = namespace + ".listShop";
		return sqlSession.selectList(statement, sdto);
	}


	public ShopDTO shoplistDetail(ShopDTO sdto1) { // 휴양지 디테일에서 상점 클릭하면 상점 디테일 들어가기.
		String statement = namespace + ".shoplistDetail";
		return sqlSession.selectOne(statement, sdto1);
	}


	public ShopDTO listNum(ShopDTO sdto) { // 상점 후기 등록하기 위해서 num값 출력
		String statement = namespace + ".listNum";
		return sqlSession.selectOne(statement, sdto);
		
	}


	public Integer insertshr(ShopReviewDTO shrdto) { // 상점 후기 등록
		String statement = namespace + ".insertshr";
		return sqlSession.insert(statement, shrdto);
		
	}


	public List<ShopReviewDTO> listShopReview(String shopNum, Integer page, int limit) { // 상점 후기 리스트 뽑기.
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		Integer su1 = Integer.parseInt(shopNum);
		StartEndPageDTO spage = new StartEndPageDTO(startRow, endRow, su1);
		String statement = namespace + ".listShopReview";
		return sqlSession.selectList(statement, spage);
	}


	public Integer listShopReviewCount(ShopReviewDTO shredto) { //상점 후기 개수 
		String statement = namespace + ".listShopReviewCount";
		return sqlSession.selectOne(statement, shredto);
	}
	
}
