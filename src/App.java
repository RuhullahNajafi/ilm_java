
public class App {
    public static void main(String[] args) throws Exception {
        
        // Create a new address in Hamburg
        Address hamburg = new Address("Abc-Street", "1 a", "Hamburg", "20095");

        // Create two new persons named Bob Muster and Alice Muster living in Hamburg
        Person bob = new Person(new Name("Bob", "Muster"), 27, Sex.MALE, hamburg);
        Person alice = new Person(new Name("Alice", "Muster"), 25, Sex.FEMALE, hamburg);

        bob.marry(alice);
        Person tom = bob.haveChild(new Name("Tom", "Muster"), Sex.MALE);
        Person eve = alice.haveChild(new Name("Eve", "Muster"), Sex.FEMALE);
        Person ben = bob.haveChild(new Name("Ben", "Muster"), Sex.MALE);
        Person ana = alice.haveChild(new Name("Ana", "Muster"), Sex.FEMALE);

        System.out.println();
        System.out.println("Spouse of Bob: " + bob.getSpouse());
        System.out.println("Spouse of Alice: " + alice.getSpouse());

        System.out.println();
        System.out.println("Children of Bob: " + bob.getChildren());
        System.out.println("Children of Alice: " + alice.getChildren());

        System.out.println();
        System.out.println("Parents of Tom: " + tom.getParents());
        System.out.println("Parents of Eve: " + eve.getParents());

        System.out.println();
        System.out.println("Father of Tom: " + tom.getFather());
        System.out.println("Mother of Tom: " + tom.getMother());
        System.out.println("Father of Eve: " + eve.getFather());
        System.out.println("Mother of Eve: " + eve.getMother());

        System.out.println();
        System.out.println("Siblings of Tom: " + tom.getSiblings());
        System.out.println("Siblings of Eve: " + eve.getSiblings());
        System.out.println("Sisters of Ana: " + ana.getSisters());
        System.out.println("Sisters of Tom: " + tom.getSisters());

        ben.setAge(30);
        Address berlin = new Address("Xyz-Street", "2 b", "Berlin", "10000");
        Person nicole = new Person(new Name("Nicole", "Bauer"), 28, Sex.FEMALE, berlin);
        ben.marry(nicole);
        Person tim = ben.haveChild(new Name("Tim", "Muster"), Sex.MALE);

        System.out.println();
        System.out.println("Parents of Tim: " + tim.getParents());
        System.out.println("GrandParents of Tim: " + tim.getGrandParents());
        System.out.println("GrandChildren of Bob: " + bob.getGrandChildren());
        System.out.println("GrandChildren of Alice: " + alice.getGrandChildren());

    }
}
