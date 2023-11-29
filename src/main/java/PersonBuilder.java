public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address = null;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Person не может быть создан: Не указано значение поля name");
        }
        if (surname == null)
            throw new IllegalStateException("Person не может быть создан: Не указано значение поля surname");
        if (age > -1 && address != null) {
            return new Person(name, surname, age, address);
        }
        if (age > -1) {
            return new Person(name, surname, age);
        }
        if (address != null) {
            return new Person(name, surname, address);
        }
        return new Person(name, surname);
    }
}
