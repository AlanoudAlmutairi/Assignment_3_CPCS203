/*
Name : Alanoud 


 */
package kauhospitalsystem;


public class Nurse extends Staff {
    //Data fild 
    private int experience ;
    
    //constructor
    Nurse( int experience  , String specialization, String staffid ,int id ,
            String name ,String nationality ,char gender ,int phone  ){
        super(specialization,staffid ,id, name , nationality , gender , phone);
        this.experience = experience ;
        
    }
    //getter
    public int getExperience(){
        return experience ;
    }
    //setter
    public void setExperience(int experience){
        this.experience = experience ;
    }
    
    @Override // override toString
    public String toString(){
      return super.toString() +"\n\tExperience Year: "+getExperience();
    }
    
}
