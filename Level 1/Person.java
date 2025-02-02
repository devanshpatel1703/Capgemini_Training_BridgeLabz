class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(Person obj) {
        this.name=obj.name;
        this.age=obj.age;
    }
    public void printPerson(){
        System.out.println(this.name+" "+this.age);
    }
    public static void main(String[] args) {
        Person p1=new Person("Dev",25);
        Person p2=new Person("Jon",30);
        Person p3=new Person(p1);
        p1.printPerson();
        p2.printPerson();
        p3.printPerson();
    }    
}
