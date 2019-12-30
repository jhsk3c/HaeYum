package Service.Shop;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import Model.DTO.ShopDTO;
import Model.DTO.ShopReviewDTO;
import Model.DTO.SpotReviewDTO;
import Model.DTO.VspotDTO;
import Repository.Vspot.VspotRepository;

@Service
public class ShopDetailService {
	
	@Autowired
	private VspotRepository vspotRepository;

	@Transactional
	public void shopDetail(String shopNum, Model model, Integer page) {
		
		
		ShopDTO sdto1 = new ShopDTO();
		sdto1.setShopNum(Integer.parseInt(shopNum));
		ShopDTO list = vspotRepository.shoplistDetail(sdto1);
		
		if(list.getGoodsOriginal() != null) {
				String [] original = list.getGoodsOriginal().split("-"); 
				String [] store = list.getGoodsStore().split("-");
				
				model.addAttribute("original", original);
				model.addAttribute("store", store);
			}
		model.addAttribute("list", list);
		// 여기까지가 가장 맨윗부분 이미지 나타내는거 .
		
		int limit = 10;
		
		ShopReviewDTO shredto = new ShopReviewDTO();
		shredto.setShopNum(Integer.parseInt(shopNum));
		System.out.println("접근 넘버 : " + Integer.parseInt(shopNum));
		List<ShopReviewDTO> srdto = vspotRepository.listShopReview(shopNum, page, limit);
		Integer Count = vspotRepository.listShopReviewCount(shredto);
		System.out.println("접근 카운트 : " + Count);
		
		double sum1 = 0;
		double sum2 = 0;
		double sum3 = 0;
		double sum4 = 0;
		double max = 0;
		double maxAvg = 0;
		for(int i = 0; i < srdto.size(); i++) {
			sum1 += srdto.get(i).getShopReviewStar1(); 
			sum2 += srdto.get(i).getShopReviewStar2();
			sum3 += srdto.get(i).getShopReviewStar3();
			sum4 += srdto.get(i).getShopReviewStar4();
		}
		double Avg1 = Math.round((sum1/Count)*10)/10.0;
		double Avg2 = Math.round((sum2/Count)*10)/10.0;
		double Avg3 = Math.round((sum3/Count)*10)/10.0;
		double Avg4 = Math.round((sum4/Count)*10)/10.0;
		max = (Avg1 + Avg2 + Avg3 + Avg4);
		maxAvg = Math.round((max/4)*100)/100.0;
		
		int maxPage = (int)((double)Count / limit + 0.95);
		int startPage = (int)(((double)page / 10 + 0.9 ) -1) * 10 +1;
		int endPage = startPage + 10 -1;
		
		if(endPage > maxPage)endPage= maxPage;
		
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("srdto", srdto);
		model.addAttribute("count", Count);
		
		model.addAttribute("avg1", Avg1);
		model.addAttribute("avg2", Avg2);
		model.addAttribute("avg3", Avg3);
		model.addAttribute("avg4", Avg4);
		model.addAttribute("maxAvg", maxAvg);
		
		

		List<VspotDTO> Vlist = vspotRepository.memList();
		Collections.shuffle(Vlist);
		model.addAttribute("vlist", Vlist);
		
		
		ShopDTO sdto = new ShopDTO();
		sdto.setVspotNum(Integer.parseInt(shopNum));
		List<ShopDTO> shop = vspotRepository.listShop(sdto);
		Collections.shuffle(shop);
		model.addAttribute("shop", shop);
		
	}

}
