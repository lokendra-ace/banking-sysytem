
# Banking System Using Java and OOP Concepts

## Overview
This project is a simple **console-based banking system** implemented entirely in a single Java file using **Object-Oriented Programming (OOP)** principles. It allows users to:

- Create customer accounts
- Deposit and withdraw money
- View account details and transaction history

It demonstrates the power of OOP with encapsulated classes and interactive CLI-based functionality.

---

## Features
- Modular design within one file
- Unique account number generation
- Transaction logging (deposit and withdrawal)
- Account detail viewer with full history
- Easy to run and extend

---

## OOP Concepts Demonstrated
- **Encapsulation**: Each class controls access to its data via private fields and public methods.
- **Abstraction**: Banking logic abstracted into methods like `deposit()`, `withdraw()`, and `printDetails()`.
- **Modularity**: All classes like `Customer`, `Account`, `Transaction`, and `Bank` are implemented in one file but maintain separation of responsibilities.

---

## How to Run

### 1. Compile the program
```bash
javac BankingSystem.java
```

### 2. Run the program
```bash
java BankingSystem
```

---

## Usage Guide
- **Option 1**: Create an account (enters a customer name and assigns account number)
- **Option 2**: Deposit money to an existing account
- **Option 3**: Withdraw money from an account
- **Option 4**: View full account details and transaction history
- **Option 5**: Exit the system

---

## Example Output
```
--- Banking System Menu ---
1. Create Account
2. Deposit
3. Withdraw
4. View Account Details
5. Exit
Select an option:
```

---

## Future Enhancements
- Add persistent storage using a file or database
- Add user authentication and password protection
- Introduce a GUI using JavaFX or Swing
- Add support for multiple currencies and multilingual UI

---

## Developed By
- Lokendra Singh
- Shubh Choudhary
- Dheeraj Lodhi
- Harsh Pandey

---

## License
This project is for educational purposes and open-source. You are free to modify and redistribute it with attribution.
