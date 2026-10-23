# Java Interfaces: Core Summary & Concepts

## 1. What is an Interface?
* **A Pure Contract:** An interface defines *what* a class must do, not *how* it does it.
* **Method Declarations Only:** Methods in an interface have signatures but no implementation bodies (`{}`).
* **Cannot be Instantiated:** You cannot create an object directly using `new InterfaceName()`.

## 2. Key Object-Oriented Benefits

* **Polymorphism:** 
  * Different classes can implement the same interface method in completely different ways.
  * Example: `SendTransaction` subtracts from a balance, while `ReceiveTransaction` adds to a balance, but both execute via `t.transaction(target)`.

* **Decoupling (Independence):** 
  * The main program interacts only with the interface type, staying unaware of concrete class internals.

* **Open/Closed Principle:** 
  * You can introduce new classes (e.g., `CryptoTransaction`) without modifying existing code or loops in `Main`.

* **Multiple Implementation:** 
  * A Java class can only extend **one** class, but it can implement **multiple** interfaces (`implements InterfaceA, InterfaceB`).

## 3. Abstract Class vs. Interface

| Feature | Abstract Class | Interface |
| :--- | :--- | :--- |
| **Primary Goal** | Sharing code/state among related classes. | Defining a common contract/behavior. |
| **State / Attributes** | Can hold instance variables with state. | Cannot hold state (constants only). |
| **Inheritance** | Single inheritance (`extends Class`). | Multiple implementation (`implements A, B`). |

## 4. Good OOP Code Pattern

```java
// 1. The Blueprint / Contract
public interface TransactionOption {
    void transaction(Marketplace target);
    Marketplace getAccount(); // Guarantees direct access without type casting
}

// 2. Concrete Implementation
public class SendTransaction implements TransactionOption {
    private Marketplace account;
    private float amount;

    public SendTransaction(Marketplace account, float amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public Marketplace getAccount() {
        return account;
    }

    @Override
    public void transaction(Marketplace target) {
        // Specific logic here
    }
}

// 3. Polymorphic Usage (No instanceof / No type casting needed!)
for (TransactionOption t : fleet) {
    Marketplace acc = t.getAccount(); // Polymorphic call
    t.transaction(targetUser);        // Polymorphic call
}