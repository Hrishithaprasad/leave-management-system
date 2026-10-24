# Leave Management System

A simple Java console application that manages employee leave and applies different leave rules by employee type. It was built step by step to practise Object-Oriented Programming: encapsulation, inheritance, polymorphism, abstraction, method overriding, method overloading and access modifiers.

## Features

- Stores employee ID, name, department and leave balance
- Apply for leave, cancel leave, check the balance and display details
- Four employee types, each with its own leave rules
- Custom exceptions for invalid requests and insufficient balance
- A leave history for each employee
- A scripted demo (`LeaveManagementApp`) that runs the same steps every time

## Leave rules

| Employee type | Annual leave (days) | Max days per request | Extra benefit |
|---|---|---|---|
| Full-Time | 24 | 10 | none |
| Part-Time | 12 | 5 | none |
| Intern | 6 | 2 | none |
| Manager | 30 + 5 bonus = 35 | 15 | 5 bonus leave days |

## Project structure

```
leave-management-system/
├── README.md
├── src/
│   ├── Employee.java                         abstract base class
│   ├── FullTimeEmployee.java
│   ├── PartTimeEmployee.java
│   ├── Intern.java
│   ├── Manager.java                          extends FullTimeEmployee
│   ├── LeaveRecord.java                      package-private history entry
│   ├── LeaveException.java                   base exception
│   ├── InvalidLeaveRequestException.java
│   ├── InsufficientLeaveBalanceException.java
│   └── LeaveManagementApp.java               scripted demo (main)
└── docs/
    ├── Leave_Management_System_Report.docx   full report
    ├── class-diagram-design.png              diagram drawn before coding
    ├── class-diagram-final.png               final class diagram
    └── screenshots/                          sample program output
```

## How to run

Requires JDK 8 or later.

```
cd src
javac *.java
java LeaveManagementApp
```

The program prints the employee details, applies leave under each employee type's rules, shows the edge cases (zero days, negative days, not enough balance, cancelling too much, a blank name), then prints the final balances and leave history.

## Design notes

- `Employee` is abstract. Subclasses only state what differs: their label and their per-request limit.
- Applying and cancelling leave are written once in `Employee`, so no subclass repeats the validation.
- The employee classes never print results. They throw `LeaveException` subclasses and the application decides what to show.
- `Manager` extends `FullTimeEmployee`, so the Manager change request needed only the differences.

See `docs/Leave_Management_System_Report.docx` for the design, the OOP explanation and the refactoring notes.
