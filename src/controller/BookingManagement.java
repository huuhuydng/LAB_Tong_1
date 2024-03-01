
package controller;

import java.io.IOException;
import java.text.ParseException;

import service.BookingService;
import view.Menu;

/**
 *
<<<<<<< HEAD
 * @author Hung
=======
 * @author Huydeptrai
>>>>>>> 4ef9bd3d6e4be822f83cb233403cc05db4da7e13
 */
public class BookingManagement extends Menu {
    
    BookingService bookingService = new BookingService();
    FuramaController parentMenu; // Thêm thuộc tính để lưu trữ menu cha


    public BookingManagement() {
    }

    public BookingManagement(String td, String[] mc) {
        super(td, mc);
    }    
    
    public void setParentMenu(FuramaController parentMenu) {
        this.parentMenu = parentMenu;
    }

    @Override
    public void execute(int n) throws ParseException, IOException {
        switch (n){
            case 1 ->{ // "Add new booking"
                try {
                    bookingService.addBooking();
                } catch (ParseException e) {                  
                    e.printStackTrace();
                }
            }
            
            case 2 ->{ //"Display list booking"
                bookingService.displayListBooking();
            }
            
            case 3 ->{ // "Create new contracts"
                bookingService.addConstract();
            }
            
            case 4 ->{ // "Display list contracts"
                
            }
            
            case 5 ->{ //  "Edit contracts"
                
            }
        
            case 6 ->{ // "Return main menu"
                System.out.println("Return main menu..");
                parentMenu.run(); // Gọi phương thức run() của menu cha (FuramaController)
            }

         
        }
    }
}
