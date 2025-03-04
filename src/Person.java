import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private Name name;
    private int age;
    private Sex sex;
    private Address address;

    private Person spouse;
    private final List<Person> children;
    private final List<Person> parents;

    public Person(Name name, int age, Sex sex, Address address) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (sex == null) {
            throw new IllegalArgumentException("Sex cannot be null");
            }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;

        this.spouse = null;
        this.children = new ArrayList<Person>();
        this.parents = new ArrayList<Person>();
    }

    public Name getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public Sex getSex() {
        return this.sex;
    }
    public Address getAddress() {
        return this.address;
    }
    public Person getSpouse() {
        return this.spouse;
    }
    public List<Person> getChildren() {
        return this.children;
    }
    public List<Person> getParents() {
        return this.parents;
    }
    public List<Person> getSiblings() {
        return this.parents.stream().flatMap(p -> p.getChildren().stream())
                .collect(Collectors.toSet()).stream().filter(p -> p != this).toList();
    }
    public List<Person> getGrandParents() {
        return this.parents.stream().flatMap(p -> p.getParents().stream())
                .collect(Collectors.toSet()).stream().toList();
    }
    public List<Person> getGrandChildren() {
        return this.children.stream().flatMap(p -> p.getChildren().stream()).collect(Collectors.toList());
    }
    public List<Person> getBrothers() {
        return this.getSiblings().stream().filter(p -> p.getSex() == Sex.MALE).toList();
    }
    public List<Person> getSisters() {
        return this.getSiblings().stream().filter(p -> p.getSex() == Sex.FEMALE).toList();
    }
    public Person getFather() {
        return this.parents.stream().filter(p -> p.getSex() == Sex.MALE).findFirst().orElse(null);
    }
    public Person getMother() {
        return this.parents.stream().filter(p -> p.getSex() == Sex.FEMALE).findFirst().orElse(null);
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }
    public void setName(Name name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }
    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        this.address = address;
    }

    public void marry(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        if (this.spouse != null || person.spouse != null) {
            throw new IllegalArgumentException("Only single persons can marry");
        }
        if (this.sex == person.sex) {
            throw new IllegalArgumentException("Two person of the same sex cannot marry");
        }
        this.spouse = person;
        person.spouse = this;
    }
    public Person haveChild(Name name, Sex sex) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (this.children.stream().anyMatch(p -> p.getName().equals(name))) {
            throw new IllegalArgumentException("Child with name " + name + " already exists");
        }
        if (this.spouse == null) {
            throw new IllegalArgumentException("Single person cannot have a child");
        }
        Person child = new Person(name, 0, sex, this.address);
        this.children.add(child);
        this.spouse.children.add(child);
        child.parents.add(this);
        child.parents.add(this.spouse);

        return child;
    }

    public String toString() {
        return this.name.toString();
    }
}
