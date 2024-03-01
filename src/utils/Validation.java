package utils;
//hello anh em
<<<<<<< HEAD
//hello anh ngay 25/2
//hihihihi 25/2
=======
//hihi
>>>>>>> 4ef9bd3d6e4be822f83cb233403cc05db4da7e13
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.Employee;

import java.util.Date;

public class Validation {

    public static double getDoubleFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print("Enter " + name + ": ");
            try {
                number = sc.nextDouble();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the double number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the double number > 0 ");
                sc.next();
            }
        }
    }
    
    public static int getIntFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Enter " + name + ": ");
            try {
                number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the integer number > 0 ");
                sc.next();
            }
        }
    }
    
    

    public static String getStringFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print("Enter " + name + ": ");
            s = sc.nextLine().toLowerCase().trim();
        }
        //Xoa 2 cac dau cach lien tiep
        String sOut = s.charAt(0) + "";
        for (int i = 1;i < s.length(); i++){
            if (s.charAt(i-1) != ' ' || s.charAt(i) != ' '){
                sOut += s.charAt(i);
            }
        }
        return sOut;
    }
    
    public static String getChoiceYesNoNFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter " + name + ": ");
            String s = sc.nextLine().toLowerCase();
            if (s.equals("y")||s.equals("n")) {
                    return s;
            } else {
                    System.err.println("Please enter Y(Yes) or N(No)");
            }
        }      
    }
          
    
    
    public static String getEmpIDFromInput(String name){
    //name: "Employee ID <NV-YYYY> (Y is a number)"
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValid = false;

        do {
            System.out.print("Enter " + name + ": ");
            input = scanner.nextLine();

            if (input.matches("NV-\\d{4}")) {
                isValid = true;
            } else {
                System.out.println("Enter unsuccessfully, please try again..");
            }
        } while (!isValid);      
        return input;
    }
    
    public static String getCusIDFromInput(String name){
    //name: "Employee ID <KH-YYYY> (Y is a number)"
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValid = false;

        do {
            System.out.print("Enter " + name + ": ");
            input = scanner.nextLine();

            if (input.matches("KH-\\d{4}")) {
                isValid = true;
            } else {
                System.out.println("Enter unsuccessfully, please try again..");
            }
        } while (!isValid);      
        return input;
    }
    
    public static String getPerNameFromInput(String name) {
    //name: "fullname"
        Scanner scanner = new Scanner(System.in);
        String fullName;
        boolean isValid = false;

        do {
            System.out.print("Enter " + name + ": ");
            fullName = scanner.nextLine();

            if (isValidFullName(fullName)) {
                isValid = true;
            } else {
                System.out.println("Please capitalize the first letter in each word..");
            }
        } while (!isValid);
        return formatFullName(fullName);
    }

    private static boolean isValidFullName(String fullName) {
        return fullName.matches("[A-Z][a-zA-Z]*( [A-Z][a-zA-Z]*)*");
    }

    private static String formatFullName(String fullName) {
        String[] words = fullName.split(" ");
        StringBuilder formattedFullName = new StringBuilder();

        for (String word : words) {
            char firstChar = Character.toUpperCase(word.charAt(0));
            String restOfWord = word.substring(1).toLowerCase();
            String formattedWord = firstChar + restOfWord;
            formattedFullName.append(formattedWord).append(" ");
        }
        return formattedFullName.toString().trim();
    }
    
    public static String getPerCMNDFromInput(String name){
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValid = false;

        do {
            System.out.print("Enter " + name + ": ");
            input = scanner.nextLine();

            if (input.matches("\\d{9}")||input.matches("\\d{12}")) {
                isValid = true;
            } else {
                System.out.println("Please enter a string of 9 numbers or 12 numbers..");
            }
        } while (!isValid);      
        return input;
    }
    
    public static String getPerPhoneFromInput(String name){
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValid = false;

        do {
            System.out.print("Enter " + name + ": ");
            input = scanner.nextLine();

            if (input.matches("0\\d{9}")) {
                isValid = true;
            } else {
                System.out.println("Please enter the correct phone number format 0xxxxxxxxx..");
            }
        } while (!isValid);      
        return input;
    }

    public static int getSvPeopleFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Enter " + name + ": ");
            try {
                number = sc.nextInt();
                if (number > 0 && number < 20) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 and < 20 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the integer number > 0 and < 20 ");
                sc.next();
            }
        }
    }

    public static String getSvTypeFromInput(String name){
        //name = "service name <villa/room/house>"
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValid = false;
        do {
            System.out.print("Enter " + name + ": ");
            input = scanner.nextLine().toLowerCase();

            if (input.equalsIgnoreCase("villa")||input.equalsIgnoreCase("house")||input.equalsIgnoreCase("room")) {
                isValid = true;
            } else {
                System.out.println("Enter unsuccessfully, please try again..");
            }
        } while (!isValid);      
        return input;
    }
    
    
    public static int getAreaOrPoolFromInput(String name){
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Enter " + name + ": ");
            try {
                number = sc.nextInt();
                if (number > 30) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 30 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the integer number > 30 ");
                sc.next();
            }
        }
    }

    
    public static Date getBirthFromInput(String name){
        Scanner sc = new Scanner(System.in);
        
        boolean validAge = false;
        Date birthDate = null;
        
        while (!validAge) {
            System.out.println("Enter " + name + ": ");
            String input = sc.nextLine();
                    
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                birthDate = dateFormat.parse(input);
                
                // Calculate age
                Date currentDate = new Date();
                int age = calculateAge(birthDate, currentDate);
                
                // Check age >= 18
                if (age >= 18) {
                    validAge = true;
                } else {
                    System.out.println("Only enter the birthday that enough 18 age, please re-enter..");
                }
            } catch (ParseException e) {
                System.out.println("Birthday is not valid, please re-enter..");
            }
        }
        return birthDate;
    }
    
    private static int calculateAge(Date birthDate, Date currentDate) {
        int age = 0;
        
        // Tính tuổi dựa trên năm sinh và năm hiện tại
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        int birthYear = Integer.parseInt(yearFormat.format(birthDate));
        int currentYear = Integer.parseInt(yearFormat.format(currentDate));
        
        age = currentYear - birthYear;
        
        // Kiểm tra nếu ngày hiện tại đã qua ngày sinh của năm nay
        // Nếu đã qua, tuổi tăng 1
        SimpleDateFormat dayMonthFormat = new SimpleDateFormat("ddMM");
        int birthDayMonth = Integer.parseInt(dayMonthFormat.format(birthDate));
        int currentDayMonth = Integer.parseInt(dayMonthFormat.format(currentDate));
        
        if (currentDayMonth < birthDayMonth) {
            age--;
        }
        return age;
    }  

    public static Date parse(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(dateString);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean isValidPhone(String phone){
        if (phone.matches("0\\d{9}")) {
            return true;
        }
        return false;
    }

    public static boolean isValidCMND(String CMND){
        if (CMND.matches("\\d{9}")||CMND.matches("\\d{12}")) {
            return true;
        }
        return false;
    }

     //kiểm tra chuỗi kí tự có phải là chuỗi date theo định dạng không
     public static boolean isValidDate(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static  boolean checkIDEmp(String id, List<Employee> list) {
        for(Employee emp : list){
            if (id.equals(emp.getPerId())) {
                return false;
            }     
        }

        if (id.matches("NV-\\d{4}")) {
            return true;
        }else{
            return false;
        }
    }

    public static  boolean checkIDCus(String id, List<Customer> list) {
        for(Customer cus : list){
            if (id.equals(cus.getPerId())) {
                return false;
            }     
        }

        if (id.matches("KH-\\d{4}")) {
            return true;
        }else{
            return false;
        }
    }
}
