package lld;

import lld.parkinglot.ParkingLot;
import lld.parkinglot.Ticket;
import lld.parkinglot.Vehicle;
import lld.parkinglot.VehicleType;
import lld.splitwise.Group;
import lld.splitwise.SplitType;
import lld.splitwise.SplitwiseService;
import lld.splitwise.User;
import lld.tinyurl.TinyUrlService;

import java.time.LocalDateTime;

public class MainClassLLDDemo {

    public static void main(){

        ParkingLot parkingLot = new ParkingLot(3);
        SplitwiseService splitwiseService = new SplitwiseService();
        TinyUrlService tinyUrlService = new TinyUrlService();

        /*ParkingLot LLD START*/
        System.out.println("============ PARKING LOT LLD - START =========");

        //Printing the available parking spots in the parking lot
        parkingLot.findAvailableSpots();

        Vehicle car = new Vehicle("TN01AB1234", VehicleType.COMPACT);
        Vehicle bike = new Vehicle("MH02AB1234", VehicleType.MOTORCYCLE);
        Vehicle bus = new Vehicle("KA02AB1234", VehicleType.LARGE);

        //Park vehicles
        Ticket carTicket = parkingLot.parkVehicle(car);
        Ticket bikeTicket = parkingLot.parkVehicle(bike);
        Ticket busTicket = parkingLot.parkVehicle(bus);

        //Checking the parking lot available spots after parking the vehicles
        parkingLot.findAvailableSpots();

        // Simulate exit after some time
        try {
            Thread.sleep(1500);
        } catch (Exception ignored) {

        }

        //Exit vehicle
        parkingLot.exitVehicle(carTicket.getTicketId(), LocalDateTime.now());

        //Checking the parking lot available spots after unparking the vehicles
        parkingLot.findAvailableSpots();

        System.out.println("============ PARKING LOT LLD - END =========");
        /*ParkingLot LLD END*/

        /*TinyUrl LLD START*/
        System.out.println("============ TINY URL LLD - START =========");

        String longUrl = "https://www.myblog.com/articles/goa/best-places-to-visit-in-goa-with-budget-and-itinerary?source=newsletter&utm_campaign=summer";

        //Shorten URL
        String shortCode1 = tinyUrlService.shortenUrl(longUrl);
        System.out.println("Generated Short Code: " + shortCode1);

        //Simulate clicks
        tinyUrlService.redirect(shortCode1);
        tinyUrlService.redirect(shortCode1);
        tinyUrlService.redirect(shortCode1);

        //Check analytics
        tinyUrlService.showAnalytics(shortCode1);

        //Custom Alias
        try {
            tinyUrlService.shortenWithCustomAlias(longUrl, "goasummer");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            tinyUrlService.shortenWithCustomAlias(longUrl, "goasummer");
        } catch (Exception e) {
            System.out.println("Error while trying the same shortCode again : " + e.getMessage());
        }

        System.out.println("============ TINY URL LLD - END =========");
        /*TinyUrl LLD END*/

        /*SplitWise LLD START*/
        System.out.println("============ SPLITWISE LLD - START =========");
        //Create Users
        User jishnu = splitwiseService.addUser("Jishnu", "jishnu@gmail.com");
        User madhan = splitwiseService.addUser("Madhan", "madhan@gmail.com");
        User uk = splitwiseService.addUser("UK", "uk@gmail.com");
        User karthik = splitwiseService.addUser("Karthik", "karthik@gmail.com");
        User mukesh = splitwiseService.addUser("Mukesh", "mukesh@gmail.com");

        //Create group and add members
        Group goaTrip = splitwiseService.createGroup("Goa Trip");
        splitwiseService.addMemberToGroup(goaTrip.getGroupId(), jishnu.getUserId());
        splitwiseService.addMemberToGroup(goaTrip.getGroupId(), madhan.getUserId());
        splitwiseService.addMemberToGroup(goaTrip.getGroupId(), uk.getUserId());
        splitwiseService.addMemberToGroup(goaTrip.getGroupId(), karthik.getUserId());
        splitwiseService.addMemberToGroup(goaTrip.getGroupId(), mukesh.getUserId());

        //Add expenses
        splitwiseService.addExpense("Hotel Booking", 5000, jishnu.getUserId(), goaTrip.getGroupId(), SplitType.EQUAL);
        splitwiseService.addExpense("Food & Drinks", 2000, madhan.getUserId(), goaTrip.getGroupId(), SplitType.EQUAL);

        //Balance check
        splitwiseService.showAllBalances();
        splitwiseService.showUserBalance(jishnu.getUserId());

        //Settle up
        splitwiseService.settleUp(uk.getUserId(), jishnu.getUserId());

        //Show all balances after settleUp
        splitwiseService.showAllBalances();
        System.out.println("============ SPLITWISE LLD - END =========");
        /*SplitWise LLD END*/




    }
}
