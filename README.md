# 🐾 Java OOP Inheritance & Polymorphism Project

## 📌 Overview
This project demonstrates core Object-Oriented Programming (OOP) principles in Java, focusing on:

- Inheritance
- Polymorphism
- Abstraction
- Method Overriding
- Dynamic Binding

The system is divided into two main parts:
1. 🐘 Zoo Management System
2. 💰 Price Abstraction System

---

# 🐘 Part 1: Zoo Management System

## 📖 Description
A simulation of a zoo that contains different types of animals.  
Each animal behaves differently when:

- Going out of the cage
- Communicating
- Returning back

## 🧬 Hierarchy

Animal (Abstract Class)
│
├── Walker (Elephants, Deer)
└── Reptile (Snakes, Crocodiles)

## 🎯 Features
- Each animal has:
  - Name
  - Weight
  - Gender

- Additional attributes:
  - Walker: speed, tail length
  - Reptile: body length

## 🧪 Behavior
- goOut() → animals leave cages
- converse() → animals make sounds
- getBack() → animals return to cages

## 🏁 Main Program
- Creates a zoo array of animals
- Runs full simulation (go out → converse → return)
- Finds and prints the heaviest animal
- Demonstrates array manipulation and cloning for elephants

---

# 💰 Part 2: Price System

## 📖 Description
Implements a flexible pricing system using polymorphism.

Two representations of price:

### 1️⃣ DiscretePrice
- Integer-based representation
- Shekels + Agorot
- Discount as percentage

### 2️⃣ DecimalPrice
- Floating-point representation
- Total price as double
- Discount as ratio (0–1)

---

## 🧬 Hierarchy

Price (Abstract Class)
│
├── DiscretePrice
└── DecimalPrice

---

## 🎯 Features
- Raise / Reduce price:
  - by value (shekels/agorot)
  - by percentage
- Calculate final price after discount
- Compare two prices using equals()

---

## 🧪 Key Method

```java
static Price maxPrice(Price p1, Price p2)
