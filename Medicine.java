/*
Name : Alanoud 
 */
package kauhospitalsystem;


public class Medicine {
 //Data fild
    private int medicineCode;
    private String name ;
    private double price;
    
//constructor
    Medicine(int MedicineCode , String name , double price){
       this.medicineCode =MedicineCode;
       this.name = name;
       this.price = price;
   }

  //getter
  public int getMedicineCode(){
      return medicineCode;
  } 
  //setter
  public void setMedicineCode(int medicineCode){
      this.medicineCode=medicineCode;
  }
  //getter
  public String getName(){
      return name ;
  }
  //setter
  public void setName(String Name){
      this.name =Name;
  }
   //getter
  public double getPrice(){
      return price;
  }
  //setter
  public void setPrice(double price){
      this.price=price;
  } 
  
    @Override // override toString 
  public String toString(){
      return "\tMedicine Code: " + getMedicineCode()+"\n\tName: " +getName()+"\n\tPrice :" +getPrice();
              
              }
  

   
    
    
}
