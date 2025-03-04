public class Address {
    
    private String street;
    private String number;
    private String zip;
    private String city;

    public Address(String street, String number, String city, String zip) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
    }

    @Override
    public String toString() {
        return street + " " + number + ", " + zip + " " + city;
    }

    public boolean equals(Address otherAddress) {
        return street.equals(otherAddress.street) && number.equals(otherAddress.number)
                && zip.equals(otherAddress.zip) && city.equals(otherAddress.city);
    }
}
