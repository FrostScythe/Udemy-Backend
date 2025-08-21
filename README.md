# 📘 Udemy Lite – Learning Project Notes

## 🔹 Level 1 – Core Spring Boot Foundations

### 1. **Spring MVC**

* **MVC** = *Model–View–Controller*.
* **Model** → represents data (e.g., `User`, `Course`).
* **View** → how data is shown (HTML/JSON).
* **Controller** → receives HTTP requests and decides what to do.
* **DispatcherServlet** = traffic cop: it receives the request and forwards it to the correct Controller.

**Flow:**
👉 Request → Controller → Service → Repository → Database
👉 Database → Repository → Service → Controller → Response

---

### 2. **Beans**

* A **bean** = any object that Spring manages inside its container (`ApplicationContext`).
* Instead of `new UserService()`, Spring creates it for you.
* Benefits:

  * Automatic **dependency injection** (`@Autowired`).
  * More flexible and testable code.
* Created automatically when you use annotations like:

  * `@Service`
  * `@Repository`
  * `@Controller` / `@RestController`

---

### 3. **Annotations**

* Annotations are instructions for Spring about how to treat a class/method/field.
* Examples:

  * `@RestController` → marks a class as an API handler.
  * `@Service` → marks business logic layer.
  * `@Repository` → marks database interaction layer.
  * `@Autowired` → injects a bean into another class.

---

### 4. **Layers in Spring Boot**

* **Controller Layer** → handles incoming requests (API endpoints).
* **Service Layer** → holds business logic (what to do with the data).
* **Repository Layer** → interacts with the database (CRUD).

**Example:**

```text
Request (API) → Controller → Service → Repository → DB
DB → Repository → Service → Controller → Response
```

---

### 5. **Code Walkthrough – UserService**

```java
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
}
```

* `@Service` → tells Spring this class contains business logic.
* `@Autowired` → injects the `UserRepository` bean here (so you don’t manually create it).
* This class **cannot be directly exposed** (no API). A **Controller** must call it.

---

### 6. **Quick Analogies**

* **Spring MVC** = a restaurant (manages flow of requests/customers).
* **Beans** = the staff (Spring hires and manages them).
* **Annotations** = name badges on staff (Chef = `@Service`, Waiter = `@Controller`, Cashier = `@Repository`).
