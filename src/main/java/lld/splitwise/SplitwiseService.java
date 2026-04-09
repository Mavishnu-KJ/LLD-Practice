package lld.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseService {

    //userId -> User map
    private final Map<String, User> userMap = new HashMap<>();
    //groupId -> Group map
    private final Map<String, Group> groupMap = new HashMap<>();
    private final List<Expense> expenseList = new ArrayList<>();

    //Core Balance Sheet: fromUserId → (toUserId → amount owed)
    private final Map<String, Map<String, Double>> balanceSheetMap = new HashMap<>();

    private int userCounter = 1;
    private int groupCounter = 1;
    private int expenseCounter = 1;

    // Create Group
    public Group createGroup(String groupName) {
        String groupId = "G" + groupCounter++;
        Group group = new Group(groupId, groupName);
        groupMap.put(groupId, group);
        System.out.println("✅ Group created: " + groupName);
        return group;
    }

    // Add User
    public User addUser(String name, String email) {
        String userId = "U" + userCounter++;
        User user = new User(userId, name, email);
        userMap.put(userId, user);
        balanceSheetMap.put(userId, new HashMap<>());   // Initialize balance map
        System.out.println("✅ User added: " + user);
        return user;
    }

    // Add Member to Group
    public void addMemberToGroup(String groupId, String userId) {
        Group group = groupMap.get(groupId);
        User user = userMap.get(userId);
        if (group != null && user != null) {
            group.addMember(user);
            System.out.println("✅ " + user.getUsername() + " added to group " + group.getGroupName());
        }
    }

    // Add Expense (Equal Split)
    public Expense addExpense(String description, double amount, String paidByUserId,
                              String groupId, SplitType splitType) {

        User paidBy = userMap.get(paidByUserId);
        Group group = groupMap.get(groupId);

        if (paidBy == null || group == null) {
            throw new IllegalArgumentException("Invalid user or group");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        String expenseId = "E" + expenseCounter++;
        Expense expense = new Expense(expenseId, description, amount, paidBy, group, splitType);
        expenseList.add(expense);

        updateBalanceSheetMap(expense);

        System.out.println("✅ Expense added: " + description + " ₹" + amount + " paid by " + paidBy.getUsername());
        return expense;
    }

    private void updateBalanceSheetMap(Expense expense) {
        if (expense.getSplitType() == SplitType.EQUAL) {
            List<User> groupMembers = expense.getGroup().getGroupMembers();
            double share = expense.getAmount() / groupMembers.size();
            User paidBy = expense.getPaidBy();

            for (User groupMember : groupMembers) {
                if (!groupMember.getUserId().equals(paidBy.getUserId())) {
                    addDebt(groupMember.getUserId(), paidBy.getUserId(), share);
                }
            }
        }
    }

    // Improved addDebt() with mutual debt simplification
    private void addDebt(String fromUserId, String toUserId, double amount) {
        if (amount <= 0) return;

        Map<String, Double> fromMap = balanceSheetMap.get(fromUserId);
        Map<String, Double> toMap = balanceSheetMap.get(toUserId);

        double currentFromOwesTo = fromMap.getOrDefault(toUserId, 0.0);
        double currentToOwesFrom = toMap.getOrDefault(fromUserId, 0.0);

        double netAmount = currentFromOwesTo + amount - currentToOwesFrom;

        if (netAmount > 0) {
            // fromUserId owes toUserId 'netAmount'
            fromMap.put(toUserId, netAmount);
            toMap.put(fromUserId, 0.0);        // clear opposite direction
        }
        else if (netAmount < 0) {
            // toUserId owes fromUserId '|netAmount|'
            toMap.put(fromUserId, -netAmount);
            fromMap.put(toUserId, 0.0);
        }
        else {
            // They cancel each other
            fromMap.put(toUserId, 0.0);
            toMap.put(fromUserId, 0.0);
        }
    }

    // Show all balances
    public void showAllBalances() {
        System.out.println("\n=== All Balances ===");
        boolean hasBalance = false;
        for (String fromId : balanceSheetMap.keySet()) {
            Map<String, Double> owes = balanceSheetMap.get(fromId);
            for (String toId : owes.keySet()) {
                double amt = owes.get(toId);
                if (amt > 0.00) {
                    System.out.println(userMap.get(fromId).getUsername() + " owes "
                            + userMap.get(toId).getUsername() + " : ₹" + String.format("%.2f", amt));
                    hasBalance = true;
                }
            }
        }
        if (hasBalance == false) {
            System.out.println("No pending balances.");
        }
    }

    public void showUserBalance(String userId) {
        User user = userMap.get(userId);
        if (user == null) {
            System.out.println("User not found with ID: " + userId);
            return;
        }

        System.out.println("\n=== Balance for " + user.getUsername() + " (" + userId + ") ===");

        Map<String, Double> owesMap = balanceSheetMap.get(userId);
        boolean hasBalance = false;

        for (String toUserId : owesMap.keySet()) {
            double amount = owesMap.get(toUserId);
            if (amount > 0.01) {
                User toUser = userMap.get(toUserId);
                System.out.println(user.getUsername()+"   → owes " + toUser.getUsername() + " : ₹" + String.format("%.2f", amount));
                hasBalance = true;
            }
        }

        if (!hasBalance) {
            System.out.println(user.getUsername()+"   No pending balances.");
        }
    }

    public void settleUp(String fromUserId, String toUserId) {
        User fromUser = userMap.get(fromUserId);
        User toUser = userMap.get(toUserId);

        if (fromUser == null || toUser == null) {
            System.out.println("Invalid user ID for settle up.");
            return;
        }

        Map<String, Double> fromMap = balanceSheetMap.get(fromUserId);
        double amount = fromMap.getOrDefault(toUserId, 0.0);

        if (amount > 0.00) {
            fromMap.put(toUserId, 0.0);   // Clear the debt
            System.out.println("✅ " + fromUser.getUsername() + " settled up ₹"
                    + String.format("%.2f", amount) + " with " + toUser.getUsername());
        } else {
            System.out.println("No balance to settle between " + fromUser.getUsername()
                    + " and " + toUser.getUsername());
        }
    }
}
