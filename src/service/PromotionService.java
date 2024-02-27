package service;

import model.Facility;
import service.BookingService;
import model.Booking;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class PromotionService {
    BookingService bs = new BookingService();
    Scanner sc = new Scanner(System.in);
    TreeSet<Booking> cusServList = new TreeSet<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public PromotionService() {
    }

    public void showCusService() {
        System.out.println("Enter the year use service to find customer: ");
        int year = sc.nextInt();
        checkYear(year);
        displayListBooking();
    }

    public void checkYear(int year) {
        for (Booking booking : bs.listBooking) {
            if (booking.getYear(booking.getBookingDate()) == year) {
                cusServList.add(booking);
            }
        }
    } 

    public void giveVoucher() {
        Stack<Booking> voucherStack = new Stack<>();
        ArrayList<Booking> currentMonthBookings = new ArrayList<>();
        System.out.println("Enter Number Of Voucher 10%: ");
        int voucher1 = sc.nextInt();
        System.out.println("Enter Number Of Voucher 20%: ");
        int voucher2 = sc.nextInt();
        System.out.println("Enter Number Of Voucher 50%: ");
        int voucher3 = sc.nextInt();
        Date now = new Date();
        for (Booking booking : bs.listBooking) {
            if (booking.getMonth(now) == booking.getMonth(booking.getBookingDate())) {
                currentMonthBookings.add(booking);
            }
        }
        Collections.sort(currentMonthBookings, Comparator.comparing(Booking::getBookingDate).reversed());
        for (Booking booking : currentMonthBookings) {
            voucherStack.push(booking);
        }

        Collections.reverse(voucherStack);

        int count = 0;
        System.out.println("Voucher List: ");
        System.out.println("+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s |\n", "Booking ID", "Voucher");
        while (!voucherStack.isEmpty()) {
            System.out.println("+-----------------+-----------------+");
            Booking booking = voucherStack.pop();
            if (count < voucher1) {
                System.out.printf("| %-15s | %-15s |\n", booking.getBookingId(), "10%");
            } else if (count < voucher1 + voucher2) {
                System.out.printf("| %-15s | %-15s |\n", booking.getBookingId(), "20%");
            } else if (count < voucher1 + voucher2 + voucher3) {
                System.out.printf("| %-15s | %-15s |\n", booking.getBookingId(), "50%");
            }
            count++;
        }
        System.out.println("+-----------------+-----------------+");
    }

    public void displayListBooking() {
        System.out.println("Booking List By Year: ");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s |\n", "Booking ID", "Booking Date", "Customer ID", "Service ID", "Quantity");

        for (Booking b : cusServList) {
            Map<Facility, Integer> bill = b.getBill();
            for (Map.Entry<Facility, Integer> entry : bill.entrySet()) {
                Facility f = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("+-----------------+-----------------+-----------------+-----------------+");
                System.out.printf("| %-15s | %-15s | %-15s | %-15s |\n", b.getBookingId(), dateFormat.format(b.getBookingDate()), b.getCusId(), f.getName());

            }
            System.out.println("+-----------------+-----------------+-----------------+-----------------+");

        }

    }
}
