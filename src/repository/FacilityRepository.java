package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Facility;
import model.House;
import model.Room;
import model.Villa;
import service.BookingService;

/**
 *
 * @author DELL
 */
public class FacilityRepository {

    private LinkedHashMap<Facility, Integer> facilityMap = new LinkedHashMap<>();
    
    public FacilityRepository() {
    }

    public LinkedHashMap<Facility, Integer> getFacilityMap() {
        return facilityMap = BookingService.getMap();
    }

    public void setFacilityMap(LinkedHashMap<Facility, Integer> facilityMap) {
        this.facilityMap = facilityMap;
    }

    public void addDataFromList(List<Facility> facilityList) {
        for (Facility facility : facilityList) {
            facilityMap.put(facility, 0);
        }
    }

    ;
    
    public void printFacilityMap() {
        
        System.out.println(
                "\n\n+----------------------------------------------------+");
        System.out.println(
                "|           List of Facility Maintainence            |");
        System.out.println(
                "|----------------------------------------------------|");
        System.out.println(String.format("| %-12s | %-12s | %-20s |", "Service code","Service name", "Number of booking"));
        System.out.println(
                "|--------------|--------------|----------------------|");
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            Facility key = entry.getKey();
            int val = entry.getValue();
            if(val>=5){
                System.out.println(String.format("| %-12s | %-12s | %-20s |",key.getId(), key.getName(), val));
            };
        }
        System.out.println(
                "+----------------------------------------------------+");
    }

    public static List<Facility> readFile() throws FileNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\Data\\DataFacility.txt"));
        List<Facility> listFacility = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {

            String[] splitLine = line.split(",");
            String ID = null;
            String name = null;
            int square = 0;
            long price = 0;
            int numOfPer = 0;
            String type = "null";
            boolean flag = true;
            
            String roomType = null; //thuoc tinh cua villa
            String poolSquare = null;
            String floor = null;
            
            String houseType = null; //thuoc tinh cua house
//            String floor = null;
            
            String service = null; //thuoc tinh cua room
            for (int i = 0; i < 6; i++) {
                String[] lines = splitLine[i].split("=");
                if (lines.length != 2) {
                    break;
                }
                String value = lines[1];
                if (i == 0) {
                    ID = value;
                    if (ID.contains("VL")) {
                        for (int j = 6; j < 9; j++) {
                            String[] splitData = splitLine[j].split("=");
                            String val = splitData[1];
                            if (j==6){
                                roomType = val;
                            } else if (j==7){
                                try {
                                    int check = Integer.parseInt(val);
                                } catch (Exception e) {
                                    flag = false;
                                }
                                poolSquare = val;
                            } else if (j==8){
                                try {
                                    int check = Integer.parseInt(val);
                                } catch (Exception e) {
                                    flag = false;
                                }
                                floor = val;
                            }
                        }
                    } else if (ID.contains("HO")){
                        for (int j =6; j<8; j++){
                            String[] splitData = splitLine[j].split("=");
                            String val = splitData[1];
                            if (j==6){
                                houseType = val;
                            } else if (j==7){
                                try {
                                    int check = Integer.parseInt(val);
                                } catch (Exception e) {
                                    flag = false;
                                }
                                floor = val;
                            }
                        }
                    } else if(ID.contains("RO")){
                        String[] splitData = splitLine[6].split("=");
                        service = splitData[1];
                    }
                } else if (i == 1) {
                    name = value;
                } else if (i == 2) {
                    try {
                        square = Integer.parseInt(value);
                    } catch (Exception e) {
                        flag = false;
                    }
                } else if (i == 3) {
                    try {
                        price = Long.parseLong(value);
                    } catch (Exception e) {
                        flag = false;
                    }
                } else if (i == 4) {
                    try {
                        numOfPer = Integer.parseInt(value);
                    } catch (Exception e) {
                        flag = false;
                    }
                } else if (i == 5) {
                    type = value;
                    if(flag){
                        Facility facility;
                        if (ID.contains("VL")){
                            facility = new Villa(ID, name, square, price, numOfPer, type, roomType, poolSquare, floor);
                        } else if (ID.contains("HO")){
                            facility = new House(ID, name, square, price, numOfPer, type, houseType, floor);
                        } else {
                            facility = new Room(ID, name, square, price, numOfPer, type, service);
                        }
                        listFacility.add(facility);
                    }
                }
            }
        }
        bufferedReader.close();
        return listFacility;
    }
    
    public static void writeFile(List<Facility> list) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Data\\DataFacility.txt"));
        for (Facility facility : list) {
            if (facility instanceof Villa){
                Villa villa = (Villa) facility;
                bw.write("ID="+villa.getId()+", Name="+villa.getName()+", Square="+villa.getSquare()+", Price="+villa.getPrice()+", numOfPer="+villa.getNumOfPer()+",type="+villa.getType()+", roomType="+villa.getRoomType()+", poolSquare="+villa.getPoolSquare()+", floor="+villa.getFloor());
            } else if (facility instanceof House){
                House house = (House) facility;
                bw.write("ID="+house.getId()+", Name="+house.getName()+", Square="+house.getSquare()+", Price="+house.getPrice()+", numOfPer="+house.getNumOfPer()+",type="+house.getType()+", houseType="+house.getHouseType()+", floor="+house.getFloor());

            } else {
                Room room = (Room) (facility);
                bw.write("ID="+room.getId()+", Name="+room.getName()+", Square="+room.getSquare()+", Price="+room.getPrice()+", numOfPer="+room.getNumOfPer()+", type="+room.getType()+", service="+room.getService());
            }
            bw.newLine();
        }
        bw.close();
    }
}
