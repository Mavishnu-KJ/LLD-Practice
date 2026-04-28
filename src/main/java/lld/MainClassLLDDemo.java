package lld;

import lld.bookmyshow.*;
import lld.cabbooking.*;
import lld.elevatorcontroller.Direction;
import lld.elevatorcontroller.ElevatorController;
import lld.parkinglot.ParkingLot;
import lld.parkinglot.Ticket;
import lld.parkinglot.Vehicle;
import lld.parkinglot.VehicleType;
import lld.snakeandladdergame.Player;
import lld.snakeandladdergame.SnakeAndLadderGame;
import lld.splitwise.Group;
import lld.splitwise.SplitType;
import lld.splitwise.SplitwiseService;
import lld.splitwise.User;
import lld.tinyurl.TinyUrlService;
import lld.VendingMachine.Coin;
import lld.VendingMachine.VendingMachine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class MainClassLLDDemo {

    public static void main(){

        ParkingLot parkingLot = new ParkingLot(3);
        SplitwiseService splitwiseService = new SplitwiseService();
        TinyUrlService tinyUrlService = new TinyUrlService();
        BookMyShowService bookMyShowService = new BookMyShowService();
        CabBookingService cabBookingService = new CabBookingService();
        SnakeAndLadderGame snakeAndLadderGame;
        ElevatorController elevatorController;
        VendingMachine VendingMachine = new VendingMachine();

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

        /*BookMyShow LLD START*/
        System.out.println("============ BOOKMYSHOW LLD - START =========");

        // Admin Operations
        Movie movie = new Movie("M001", "Avengers: Secret Wars", "Super Hero");
        Theater theatre = new Theater("T001", "PVR ParkSquare Mall", "Bangalore");
        Screen screen = new Screen("SC001", "Screen - 01", 50);

        bookMyShowService.onboardTheater(theatre);
        bookMyShowService.addScreenToTheater(theatre, screen);
        bookMyShowService.addShow(movie, screen, LocalDateTime.of(LocalDate.now(), LocalTime.of(2, 30)), 5);

        //BookMyShowUser Operations
        BookMyShowUser Rahul = new BookMyShowUser("rahul@gmail.com", "Rahul");
        List<String> seats = Arrays.asList("S12", "S13", "S14");
        Booking booking = bookMyShowService.bookTickets(Rahul, "SH-4", seats);
        //Note: In real code, use actual showId
        System.out.println("Booking successful for " + Rahul.getUsername());

        System.out.println("============ BOOKMYSHOW LLD - END =========");
        /*BookMyShow LLD END*/

        /*CabBooking LLD START*/
        System.out.println("============ CAB BOOKING LLD - START =========");

        //Admin operations
        //Onboard drivers
        Driver d1 = new Driver("D001", "Ramesh",
                new lld.cabbooking.Vehicle("KA01AB1234", lld.cabbooking.VehicleType.SEDAN),
                new Location("Whitefield", 12.97, 77.75));
        Driver d2 = new Driver("D002", "Suresh",
                new lld.cabbooking.Vehicle("KA02CD5678", lld.cabbooking.VehicleType.MINI),
                new Location("Indiranagar", 12.98, 77.64));

        cabBookingService.onboardDriver(d1);
        cabBookingService.onboardDriver(d2);

        //Customer operations
        //Rider requests ride
        Rider rahul = new Rider("U001", "Rahul");
        Location pickup = new Location("Whitefield", 12.97, 77.75);
        Location drop = new Location("Koramangala", 12.93, 77.62);

        Ride ride = cabBookingService.requestRide(rahul, pickup, drop);

        //Simulate ride flow
        cabBookingService.startRide(ride.getRideId());
        cabBookingService.completeRide(ride.getRideId());

        //Show ride details
        cabBookingService.showRideDetails(ride.getRideId());

        //Another flow to showcase the driver busy flow
        Rider rider2 = new Rider("U002", "Rider2");
        Rider rider3 = new Rider("U003", "Rider3");
        Rider rider4 = new Rider("U004", "Rider4");

        Ride rider2Ride = cabBookingService.requestRide(rider2, pickup, drop);
        Ride rider3Ride = cabBookingService.requestRide(rider3, pickup, drop);
        //Ride rider4Ride = cabBookingService.requestRide(rider4, pickup, drop); //Expecting exception as drivers are busy

        //Simulate ride flow
        cabBookingService.startRide(rider2Ride.getRideId());
        cabBookingService.startRide(rider3Ride.getRideId());
        //cabBookingService.startRide(rider4Ride.getRideId());
        cabBookingService.completeRide(rider2Ride.getRideId());
        cabBookingService.completeRide(rider3Ride.getRideId());
        //cabBookingService.completeRide(rider4Ride.getRideId());

        //Show ride details
        cabBookingService.showRideDetails(rider2Ride.getRideId());
        cabBookingService.showRideDetails(rider3Ride.getRideId());
        //cabBookingService.showRideDetails(rider4Ride.getRideId());

        System.out.println("============ CAB BOOKING LLD - END =========");
        /*CabBooking LLD END*/

        /*SnakeAndLadder LLD START*/
        System.out.println("============ SNAKE AND LADDER LLD - START =========");

        //Initialize players with position 0
        List<Player> playerList = Arrays.asList(
                new Player("Sachin", 0),
                new Player("Rahul", 0),
                new Player("Priya", 0),
                new Player("Amit", 0)
        );

        snakeAndLadderGame = new SnakeAndLadderGame(playerList);

        //Start game
        snakeAndLadderGame.playGame();

        System.out.println("============ SNAKE AND LADDER LLD - END =========");
        /*SnakeAndLadder LLD END*/

        /*ElevatorController LLD START*/
        System.out.println("============ ELEVATOR CONTROLLER LLD - START =========");
        elevatorController = new ElevatorController(3, 15);

        //User requests from different floors
        elevatorController.requestElevator(12, Direction.DOWN);
        elevatorController.requestElevator(5, Direction.UP);
        elevatorController.requestElevator(1, Direction.UP);

        // Simulate movement
        for (int i = 0; i < 15; i++) {
            elevatorController.simulateMovement();
        }

        // Internal request
        elevatorController.requestFloor(1, 1);


        System.out.println("============ ELEVATOR CONTROLLER LLD - END =========");
        /*ElevatorController LLD END*/

        /*VendingMachine LLD START*/
        System.out.println("============ VENDING MACHINE SERVICE LLD - START =========");

        //Show inventory
        VendingMachine.showInventory();

        //Happy path
        VendingMachine.insertCoin(Coin.FIFTY);
        VendingMachine.selectProduct("Coke");
        VendingMachine.dispense();

        System.out.println("\n--- Next Transaction ---");
        VendingMachine.insertCoin(Coin.TEN);
        VendingMachine.selectProduct("Water");
        VendingMachine.cancelTransaction();

        System.out.println("============ VENDING MACHINE SERVICE LLD - END =========");
        /*VendingMachine LLD END*/


    }
}
