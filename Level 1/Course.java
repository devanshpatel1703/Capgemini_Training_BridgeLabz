class Course {
    String courseName;
    int duration;
    int fee;
    static String instituteName="Unknown";
    public Course(String courseName, int duration, int fee){
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    public void displayCourseDetails(){
        System.out.println(this.courseName+"--"+this.duration+"--"+this.fee+" Lakh--"+instituteName);
    }
    public static void updateInstituteName(String newInstitueName){
        instituteName=newInstitueName;
    }
    public static void main(String[] args) {
        Course c1=new Course("B.tech",4,20);
        Course c2=new Course("M.tech",3,15);
        c1.displayCourseDetails();
        updateInstituteName("GLA University");
        c2.displayCourseDetails();
        c1.displayCourseDetails();
    }
}
