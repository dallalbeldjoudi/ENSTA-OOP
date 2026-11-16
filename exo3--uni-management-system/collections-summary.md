# University Course Management System — OOP Architecture Summary

## 1. System Architecture & Core OOP Principles

* **Encapsulation & Defensive Programming:**
  * Fields are marked `private final` wherever immutability is required (e.g., student IDs, course codes).
  * Direct collection access is shielded using `Collections.unmodifiableSet()` to prevent external caller mutation.
* **Package-Private Synchronization:**
  * Methods like `addCourse()` and `removeCourse()` inside domain objects use default (package-private) access so only manager/coordinating classes in the same package can maintain bidirectional consistency.
* **Coding to an Interface:**
  * Collection fields are declared using generic interfaces (`Set`, `Queue`, `Map`, `List`) and instantiated with concrete implementations (`HashSet`, `LinkedList`, `HashMap`, `ArrayList`).

---

## 2. Core Java Collections Framework (JCF) Summary

| Interface / Class | Type | Key Characteristics | Main Usage in System |
| :--- | :--- | :--- | :--- |
| **`Collection`** | Interface | Root interface defining common methods (`add`, `remove`, `size`). | Parent of `List`, `Set`, and `Queue`. |
| **`Collections`** | Class | Utility class containing static helper methods. | Returns read-only wrappers (`unmodifiableSet`). |
| **`Set` / `HashSet`** | Interface / Concrete | Unordered collection that forbids duplicates with $O(1)$ operations. | Holds enrolled students and courses. |
| **`Queue` / `LinkedList`** | Interface / Concrete | Ordered First-In, First-Out (FIFO) dynamic sequence. | Manages course waiting lists. |
| **`Map` / `HashMap`** | Interface / Concrete | Key-Value mapping enabling $O(1)$ lookup performance. | Indexes students by ID and courses by Code. |

---

## 3. Exception Handling Design Strategy

* **Base Custom Exception (`CourseManagementException`):**
  * Extends Java's built-in `Exception` (Checked Exception).
  * Provides a single polymorphic parent type for domain-specific errors.
* **Specific Subclasses:**
  * `CourseFullException`: Thrown when trying to enroll beyond capacity.
  * `DuplicateEnrollmentException`: Thrown when a student is already registered in a course.
* **Architectural Advantage:** Allows callers to either handle granular errors individually or catch all system errors via `catch (CourseManagementException e)`.

---

## 4. Entity Implementations

### Student.java
* **Key Traits:** Implements `Comparable<Student>` to define natural ordering alphabetically by name (`compareToIgnoreCase`).
* **Equality Contract:** Overrides `equals()` and `hashCode()` strictly based on the immutable `id` field.

