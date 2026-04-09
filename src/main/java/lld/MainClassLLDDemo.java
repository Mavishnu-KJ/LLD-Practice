package lld;

import lld.splitwise.Group;
import lld.splitwise.SplitType;
import lld.splitwise.SplitwiseService;
import lld.splitwise.User;

public class MainClassLLDDemo {

    public static void main(){

        SplitwiseService splitwiseService = new SplitwiseService();

        //Happy Path Execution
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


    }
}
