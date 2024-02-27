package controller;

import service.BookingService;
import service.FacilityService;

import java.io.IOException;
import java.text.ParseException;

import repository.PromotionRepository;
import service.PromotionService;
import view.Menu;


public class PromotionManagement extends Menu {
    BookingService b = new BookingService();
    FacilityService fc = new FacilityService();
    PromotionRepository pr = new PromotionRepository();
    PromotionService ps = new PromotionService();
    FuramaController parentMenu; // Thêm thuộc tính để lưu trữ menu cha
    
    public PromotionManagement() {
    }

    public PromotionManagement(String td, String[] mc) {
        super(td, mc);
    }
    
    public void setParentMenu(FuramaController parentMenu) {
        this.parentMenu = parentMenu;
    }

    @Override
    public void execute(int n) throws ParseException, IOException {
        switch (n){
            case 1 ->{ //"Display list customers use service"
                ps.showCusService();
            }
            
            case 2 ->{ //"Display list customers get voucher"
                ps.giveVoucher();
            }
            
            case 3 ->{ // "Return main menu"
                System.out.println("Return main menu..");
                parentMenu.run(); // Gọi phương thức run() của menu cha (FuramaController)
            
            }         
        }
    }
}
