/*
Name : Alanoud Owaed Almutairi 
ID : 2105088
Section : BBR 


 */
package kauhospitalsystem;


public class Doctor extends Staff {
    //data file 
    private double consultationFree;
    
    //constructor 
   Doctor (double consultationFree, String staffid , String specializion , int id ,
            String name , String nationality , char gender , int phone){
        super( staffid ,  specializion ,  id , name ,  nationality ,  gender ,phone);
        this.consultationFree = consultationFree;
        
    }
    //getter
    public double getConsultationFree(){
        return consultationFree;
    }
    //setter
    public void setConsultationFree( double conFree){
        this.consultationFree = conFree;
    }
    
    @Override//override toString
    public String toString(){
        return	super.toString()+"\n\tConsultation Fees :"+getConsultationFree();
    }
}
