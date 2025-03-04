public class Name {

    private final String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("FirstName and LastName must not be null nor blank");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public boolean equals(Name otherName) {
        return firstName.equals(otherName.firstName) && lastName.equals(otherName.lastName);
    }

}
