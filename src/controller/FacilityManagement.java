package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.FacilityService;
import view.Menu;

public class FacilityManagement extends Menu{

    FacilityService facilityService = new FacilityService();
    FuramaController parentMenu; // Thêm thuộc tính để lưu trữ menu cha

    public FacilityManagement() {
    }

    public FacilityManagement(String td, String[] mc) {
        super(td, mc);
    }          
    
    public void setParentMenu(FuramaController parentMenu) {
        this.parentMenu = parentMenu;
    }

    @Override
    public void execute(int n) {
        switch (n){
            case 1 ->{ try {
                //"Display list facility"
                facilityService.displayFacility();
            } catch (IOException ex) {
                Logger.getLogger(FacilityManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
            case 2 ->{ try {
                //"Add new facility"
                facilityService.addNewFacility();
            } catch (Exception ex) {
                Logger.getLogger(FacilityManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
            case 3 ->{ //"Display list facility maintenance"
                facilityService.displayFacilityMaintainence();
            }
            
            case 4 ->{ // "Return main menu"
                System.out.println("Return main menu..");
                parentMenu.run(); // Gọi phương thức run() của menu cha (FuramaController)
                return;
            }
        }
    }
    
}
