class Student {
    String rollNumber="null";
    protected String name="Unknown";
    private double CGPA=0.0;
    public Student(String rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    public void modifyCGPA(double CGPA){
        this.CGPA = CGPA;
    }
    public void displayStudent(){
        System.out.println(this.rollNumber+"--"+this.name+"--"+this.CGPA);
    }
    public static void main(String[] args) {
        PostgraduateStudent obj=new PostgraduateStudent("32","Dev",7.5);
        obj.displayStudent();
        obj.displayName();
    }
}
class PostgraduateStudent extends Student{
    public PostgraduateStudent(String rollNumber,String name,double CGPA){
        super(rollNumber,name,CGPA);
    }
    public void displayName(){
        System.out.println("Name :"+name);
    };
}
