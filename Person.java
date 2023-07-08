/*
Name : Alanoud 
 */
package kauhospitalsystem;


public class Person implements Comparable<Person>{
    //data fild
    int id ;
    String name ;
    String nationality;
    char gender ;
    int phone ;
    //constructor
    public Person(int id, String name , String nationality , char gender , int phone ){
        this.id =id;
        this.name = name ;
        this.nationality =nationality;
        this.gender=gender;
        this.phone=phone;
    }
    //getter
    public int getId(){
        return id;
    }
    //setter
    public void setId(int id){
        this.id=id;
    }
    //getter
    public String getName(){
        return name ;
    } 
    //setter
    public void setName(String name){
        this.name = name ;
    }
    //getter
    public String getNationality(){
        return nationality;
    }
    //setter
    public void setNationality(String nationality ){
        this.nationality = nationality;
    }
    //getter
    public char getGender(){
        return gender ;
    }
    //setter
    public void setGender(char gender ){
        this.gender = gender ;
    }
    //getter
    public int getPhone(){
        return phone ;
    }
    //setter
    public void setPhone (int phone){
        this.phone = phone ;
    }
    
    
    @Override // override toString
    public String toString(){
        	return "\tID: "+getId()+ "\n\tName: "+getName()+"\n\tNationality :" + getNationality()+
                        "\n\tGender: "+getGender()+"\n\tPhone: "+getPhone();
	
    }


    @Override // override compareTo interface
    public int compareTo(Person o) {
      if(getId() > o.getId())
          return 1;
      else if(getId()< o.getId())
          return -1;
      else
          return 0 ;
    }
    
    
    
    
    
}
