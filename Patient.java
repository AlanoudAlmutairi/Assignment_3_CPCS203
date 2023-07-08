/*
Name : Alanoud



 */
package kauhospitalsystem;


public class Patient extends Person {
    //data fild
    private String illness;
    private String bloodGroup;
    private Doctor doctor ;
    private Medicine [] medicine ;
    private Room room ;
    //constructor
    public Patient(String illness , String bloodGroup , 
            int id , String name , String nationality , char gender ,int phone , int totMedicine){
   
        super(id, name , nationality , gender , phone);
        this.medicine = new Medicine [totMedicine];
        this.illness = illness;
        this.bloodGroup = bloodGroup ;
       
    }
    
 //getter   
public int getTotalMedicine(){
    return medicine.length;
}   
    
//getter
public String getIllness(){
    return illness;
}
//setter
public void setIllness(String illness){
    this.illness = illness;
}
 //getter   
public String getBloodGroup (){
    return bloodGroup;
}    
//setter
public void setBloodGroup( String bloodGroup){
    this.bloodGroup= bloodGroup;
}
//getter
public Doctor getDoctor(){
    return doctor;
}
//setter
public void setDoctor(Doctor doctor ){
    this.doctor = doctor;
}
//getter
public Medicine getMedicine (int index){
    return medicine[index];
}
 //setter   
public void setMedicine( Medicine medicine , int index ){
    this.medicine[index] = medicine ;
} 
//getter
public Room getRoom(){
    return room ;
}
//setter
public void setRoom(Room room ){
    this.room = room ;
}
// this method calcolate all prices to trturn total price
public double calTotalBill(){
    double total = 0 ; 
    for(int i = 0 ; i<medicine.length;i++){
     total +=medicine[i].getPrice()  ;
    }
    total+=getRoom().getCharges() + getDoctor().getConsultationFree();
    
    return total;
}
// this method return String (basic information )
public String printPatientBasicInfo(){
    return "Patient Detail: \n ID: "+getId()+" Name: "+getName()+"\n\t Doctor : "+ getDoctor().getName()+"\t Doctor Consultation Fees: " +getDoctor().getConsultationFree() + " SR";
    
}

    @Override  // override toString 
    public String toString (){
 return "\tID: "+getId()+"\n\tName: "+getName()+ "\n\tNationality :"+getNationality()+"\n\tGender: "+getGender()+
         "\n\tPhone: "+getPhone();
         
}
    
    
  
    
    
}
