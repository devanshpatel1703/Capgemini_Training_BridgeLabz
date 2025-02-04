class Employee {
    static String companyName="Unknown";
    static int instance=0;
    String name="Unknown";
    final int id;
    String designation="Unknown";
    public Employee(String companyName,String name,int id,String designation){
        this.name=name;
        this.id=id;
        this.designation=designation;
        setCompanyName(companyName);
        instance++;
    }
    public static void setCompanyName(String s){
        companyName = s;
    }
    public static void displayTotalProducts(){
        System.out.println("Number of employees :"+instance);
    }
    public void display(){
        System.out.println(companyName+"--"+name+"--"+designation+"--"+id);
    }
    public static void main(String[] args) {
        Employee obj=new Employee("CG","Gora",10,"Chaprasi");
        Employee obj1=new Employee("CG","Gora",10,"Chaprasi");
        obj.display();
        if(obj1 instanceof Employee){
            displayTotalProducts();
        }
    }
}
