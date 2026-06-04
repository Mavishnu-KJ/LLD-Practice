# LLD Practice - Low-Level Design System

**12 Production-Ready Low-Level Design Implementations in Java**

A comprehensive collection of **Low-Level Design (LLD)** solutions built with **clean code**, **SOLID principles**, **design patterns**, and **senior-level considerations** for system design interviews.

---

## 🎯 Purpose

This repository serves as my **personal LLD mastery hub**. Each design focuses on:

- **Production-grade quality** (extensibility, maintainability, testability)
- Strong adherence to **SOLID principles**
- Proper use of **Gang of Four design patterns**
- Handling of **edge cases**, **concurrency**, and **scalability concerns**
- Clean, readable, and well-documented Java code
- Interview-ready explanations and trade-off discussions

---

## 🛠 Tech Stack

- **Language**: Java 17+
- **Build Tool**: Maven
- **Architecture**: Object-Oriented Design with layered structure

---

## 📋 List of LLDs

| # | System Design | Package | Key Features | Status |
|---|---------------|---------|--------------|--------|
| 1 | **Parking Lot System** | `lld.parkinglot` | Multi-level, vehicle-spot compatibility, fee calculation, ticket management | ✅ Complete |
| 2 | **Tiny URL / URL Shortener** | `lld.tinyurl` | Base62 encoding, collision handling, expiration, analytics | ✅ Complete |
| 3 | **Splitwise / Expense Sharing** | `lld.splitwise` | Group expenses, different split strategies, balance settlement | ✅ Complete |
| 4 | **BookMyShow / Movie Ticket Booking** | `lld.bookmyshow` | Show seating, booking lock, payment integration points | ✅ Complete |
| 5 | **Cab Booking / Ola-Uber** | `lld.cabbooking` | Driver-rider matching, real-time status, pricing strategy | ✅ Complete |
| 6 | **Snake and Ladder Game** | `lld.snakeandladder` | Multi-player, board design, dice strategy | ✅ Complete |
| 7 | **Elevator System** | `lld.elevator` | Multiple elevators, scheduling algorithms, request handling | ✅ Complete |
| 8 | **Vending Machine** | `lld.vendingmachine` | State machine, inventory management, transaction handling | ✅ Complete |
| 9 | **ATM Machine** | `lld.atm` | Card authentication, transaction types, state management | ✅ Complete |
| 10 | **Library Management System** | `lld.library` | Book issuance, fine calculation, user management | ✅ Complete |
| 11 | **Chess Game** | `lld.chess` | Piece movement rules, check/checkmate logic, undo support | ✅ Complete |
| 12 | **Restaurant Reservation System** | `lld.restaurant` | Table management, reservation slots, waitlist | ✅ Complete |

> Click on the package links in the code to explore each system.

---

## 📁 Project Structure

```bash
src/main/java/lld/
├── parkinglot/
├── tinyurl/
├── splitwise/
├── bookmyshow/
├── cabbooking/
├── snakeandladder/
├── elevator/
├── vendingmachine/
├── atm/
├── library/
├── chess/
├── restaurant/

Also includes:

LLD_Diagram_With_Details/ → Class & Sequence diagrams

🚀 How to Run

# Clone the repo
git clone https://github.com/Mavishnu-KJ/LLD-Practice.git

# Navigate and build
cd LLD-Practice
mvn clean compile

# Run main class for testing all LLDs at once 

