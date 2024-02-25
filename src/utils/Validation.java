package utils;
//hello anh em
//hihi
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
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
                    System.out.println("Enter successfully!");
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
                    System.out.println("Enter successfully!");
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
                System.out.println("Enter successfully!");
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
                System.out.println("Enter successfully!");
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
                System.out.println("Enter successfully!");
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
                System.out.println("Enter successfully!");
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
                System.out.println("Enter successfully!");
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
                    System.out.println("Enter successfully!");
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
    
    public static String getSvIDFromInput(String name){
    //name: "Service ID <SVxx-yyyy> (xx is VL/HO/RO,y is a number)"
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValid = false;
        do {
            System.out.print("Enter " + name + ": ");
            input = scanner.nextLine();

            if (input.matches("SV(VL|HO|RO)-\\d{4}")) {
                isValid = true;
                System.out.println("Enter successfully!");
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
                    System.out.println("Enter successfully!");
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
                    System.out.println("Enter successfully!");
                } else {
                    System.out.println("Only enter the birthday that enough 18 age!, please re-enter..");
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
}