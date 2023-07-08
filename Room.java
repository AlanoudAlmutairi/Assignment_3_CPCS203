/*
Name : Alanoud
 */
package kauhospitalsystem;


public class Room {
    //Data fild
    private int roomNO ;
    private String floor ;
    private String block ;
    private double charges;
    
    //constructor
     Room(int roomNO , String floor , String block , double charges){
        this.roomNO = roomNO ;
        this.floor = floor ;
        this.charges = charges ;
        this.block = block ;   
    }
   
    //getter 
     public int getRoomNO(){
         return roomNO;
     }
    
     //setter 
    public void setRoomNO(int roomNo){
        this.roomNO = roomNO;
    } 
    
    //getter
    public String getFloor(){
       return floor;
   }
    //setter
    public void setFloor (String floor){
        this.floor = floor ;
    }
    //getter
    public String getBlock(){
        return block;
    }
   //setter
    public void setBlock(String block){
        this.block = block;
    }
   //getter
    public double getCharges(){
        return charges;
    }
    //setter
    public void setCharges(double charges){
        this.charges = charges;
    }
    
    @Override// override toString
    public String toString(){
        return 	"\tRoom No: " + getRoomNO() + "\n\tLocated in floor: "+getFloor() +"\n\tBlock :"+getBlock() +
                "\n\tCharges: "+getCharges(); 
    }
}
