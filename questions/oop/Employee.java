
package questions.oop;
import java.util.Comparator;
import java.util.Objects;

public class Employee {
    int id;
    String firstName;
    String lastName;
    int age;
    int phoneNumber;
    int salary;

    public Employee (int id, String firstName, String lastName, int age , int phoneNumber, int salary) {
        // this refers to the current instance of the object, while super refers to the immediate parent class object
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public Employee (int id, String firstName, String lastName, int age) {
        // this refers to the current instance of the object, while super refers to the immediate parent class object
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // name
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // lastName
    public String getLasName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // age
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // phoneNumber
    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // salary
    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // @Override String
    @Override
    public String toString() {
        return "Employee id: " + id + " firstName: " + firstName + " lastName: " + lastName+ " phoneNumber: "
                + phoneNumber + " salary: " + salary;
    }



    @Override
    public int hashCode() {
        // objects hash
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Employee emp = (Employee) o;
        return this.firstName == emp.firstName
                && this.lastName == emp.lastName
                && this.age == emp.age;
    }

    /**
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emp = (Employee) o;
        return age == emp.age && firstName.equals(emp.firstName);
    }
    **/



    /**
     * The Employee class implements the hashCode and equals methods, which are used to determine equality between objects.
     * The hashCode method is used to generate a unique identifier for an object based on its properties,
     * such as the name and age fields in this case. The equals
     * method is used to determine if two objects are equal based on their properties.
     *
     * It is important that the hashCode method returns the same value for a given object each time it is called, as
     * this value is used to store the object in hash-based data structures like HashMap. If the hashCode method
     * returns different values for the same object, it violates the consistency requirement and can cause problems in
     * these data structures.
     *
     * Additionally, it is important not to change the state of an object after it has been added to a HashMap, as this
     * could cause the hashCode value to change and result in inconsistencies. This is why the name and age fields are
     * declared as final, meaning their values cannot be changed after the object is created.
     *
     * Java 8 version uses the Objects.hash method from the java.util.Objects class to generate the hashCode value.
     * The Objects.equals method is used to compare the name and passport fields for equality, which ensures that
     * he hashCode and equals methods will behave consistently even if either of these fields is null.
     */
}

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int compareName =  e1.getFirstName().compareTo(e2.getFirstName());
        // 0 is same
        if (compareName != 0) {
            return compareName;
        } else {
            return e1.getLasName().compareTo(e2.getLasName());
        }
    }
}
