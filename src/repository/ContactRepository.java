/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import Model.Constract;
import Model.Facility;
import static Service.BookingRepository.bookingPath;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author mb
 */
public class ConstractRepository {
    private ArrayList<Constract> listConstract = new ArrayList<>();

    public ConstractRepository(ArrayList<Constract> listConstract) {
        this.listConstract = listConstract;
    }

    static String constractPath = "Constract.txt";


    public void loadConstract() throws IOException, ParseException {

        listConstract.clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader(constractPath));
            String line;
            while ((line = br.readLine()) != null) {
                
                String[] linearr = line.trim().split(",");
                
                listConstract.add(new Constract(linearr[0], linearr[1], Integer.parseInt(linearr[2]), Integer.parseInt(linearr[3])));
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Input invalid !");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format !");
        }
    }
    
        public void saveConstract() {

        try {
//            String line = null;

            BufferedWriter bw = new BufferedWriter(new FileWriter(bookingPath));
            for (Constract c : listConstract) {               
                    bw.write(c.getConstractId() + "," + c.getBookingId() + "," + c.getDeposit() + "," + c.getTotal() +"\n"); 
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

