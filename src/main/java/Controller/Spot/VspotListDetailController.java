package Controller.Spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Vspot.VspotListDetailService;

@Controller
public class VspotListDetailController {
	
	@Autowired
	private VspotListDetailService vspotListDetailService;
	
	@RequestMapping("/vspotListDetail")
	public String Detail(@RequestParam(value = "num") String vspotNum, Model model) {
		
		vspotListDetailService.listDetail(vspotNum, model);
		
		return "Spot/vspotListDetail";
	}
	
	@RequestMapping("/vspotListDetailTwo")
	public String DetailTwo(@RequestParam(value = "num") String vspotNum, Model model) {
		
		vspotListDetailService.listDetail(vspotNum, model);
		
		return "Spot/vspotListDetailTwo";
	}

}
