/*
Name : Alanoud 


 */
package kauhospitalsystem;


public abstract class Staff extends Person {
//data fild     
 private String specialization ;
 private String staffid;
  //constructor
 public Staff(String specialization , String staffid ,int id ,String name  , String nationality , char gender , int phone ){
     super( id,name , nationality ,gender , phone);
     this.specialization = specialization ;
     this.staffid= staffid ;
 }
 //getter
 public String getSpecialization(){
     return specialization ;
 }
 //setter
 public void setSpecialization (String specialization){
     this.specialization = specialization ;
 }
 //getter
 public String getStaffid (){
     return staffid ;
 }
 //setter
 public void setStaffid(String staffid){
     this.staffid = staffid ;
 }
 
    
    @Override//override toString
 public String toString(){
     
     return super.toString()+"\n\tSpecilaization: "+getSpecialization()+"\n\tStaff ID: "+getStaffid();
	
 }
}
