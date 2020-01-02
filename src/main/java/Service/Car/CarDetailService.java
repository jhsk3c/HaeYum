package Service.Car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import Model.DTO.CarDTO;
import Repository.Car.CarRepository;

@Service
public class CarDetailService {
	
	@Autowired
	CarRepository careRepository;
	
	public void carDetatilOneSelect(String driveNum ,Model model) {
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		System.out.println("carDTO드라이브넘버" + driveNum);
		CarDTO carDTO = careRepository.carDetailOneSelect(Long.parseLong(driveNum));
		if(carDTO.getCarImage() != null) {
			
			String [] stores = carDTO.getCarImageStore().split("-");
			for(String store: stores) {
				list.add(store);
				}
				model.addAttribute("stores",list);
			}
		if(carDTO.getDriveInsurance() != null) {
			
			String [] stores1 = carDTO.getDriveInsuranceStore().split("-");
			for(String store1: stores1) {
				list1.add(store1);
				}
				model.addAttribute("stores1",list1);
			}
		if(carDTO.getDriveLicense() != null) {
			
			String [] stores2 = carDTO.getDriveLicenseStore().split("-");
			for(String store2: stores2) {
				list2.add(store2);
				}
				model.addAttribute("stores2",list2);
			}
		if(carDTO.getDriveCarcheck() != null) {
			
			String [] stores3 = carDTO.getDriveCarcheckStore().split("-");
			for(String store3: stores3) {
				list3.add(store3);
				}
				model.addAttribute("stores3",list3);
			}
		
		model.addAttribute("carDTO",carDTO);
		
	}

}
