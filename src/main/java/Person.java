import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age > -1;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder().setSurname(surname).setAge(0);
        if (hasAddress()) {
            childBuilder.setAddress(address);
        }
        return childBuilder;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Person{name=%s, surname=%s", name, surname));
        if (hasAge()) {
            stringBuilder.append(String.format(", age=%d", age));
        }
        if (hasAddress()) {
            stringBuilder.append(String.format(", address=%s", address));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
