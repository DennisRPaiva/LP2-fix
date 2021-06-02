public class Account {
    String name;
    int age;

    public static void main (String[] args){
        Account a = new Account();

        a.age = 34;
        a.name = "Ramon";

        a.printDetails();
    }

    public void printDetails() {
        System.out.println(name + "," + age);
    }
}
