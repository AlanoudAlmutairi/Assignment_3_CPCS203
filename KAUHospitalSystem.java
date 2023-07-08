/*
Name : Alanoud Owaed Almutairi 
ID : 2105088
Section : BBR 


 */
package kauhospitalsystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;

public class KAUHospitalSystem {

   
    public static void main(String[] args) throws Exception , InputMismatchException{
       // creat and deaclare a file object and Scanner + check if the file exists or not
        File input = new File ("input.txt");
        if(!input.exists())
            System.out.println("The file is not exisit");
        Scanner input1 = new Scanner (input);
        //ceart an output file 
        File output = new File ("output.txt");
        PrintWriter output1= new PrintWriter(output);
       
        Room [] HRoom = new Room [input1.nextInt()]; 
        Medicine [] HMedicine = new Medicine[input1.nextInt()];
        Person [] HPerson = new Person[input1.nextInt()]; 
        String command ;
        output1.println("--------------- Welcome to KAU Hospital System ---------------");
        // read first command from file
       command = input1.next();
       int counter = 0 ; 
        do{
            if(command.equalsIgnoreCase("Add_Room")){
                //loop for all rooms to print all information 
              for(int i = 0 ; i<HRoom.length ; i++){
                  HRoom[i] = getRoom(input1);//in this indix I will fill the array using getRoom method
                  //print the information in output file
                  output1.println("Command "+command + ": Add a new room record in the System");
                  output1.println( HRoom[i].toString());
                  output1.println();
                     output1.println("----------------------------------------------------------------");
                  command = input1.next();
              } }
            if(command.equalsIgnoreCase("Add_Medicine"))  {
                // loop for all medicine to print al information about medicine
                for(int i = 0 ; i<HMedicine.length;i++){
                    HMedicine[i] = getMedicine(input1);//in this indix I will fill the array using getMedicine  method
                    //print the information in output file
                    output1.println("Command "+command+": Add a new Medicine record in the System");
                    output1.println(HMedicine[i].toString());
                    output1.println();
                    command = input1.next();   
                    output1.println("----------------------------------------------------------------");
                }
            }
            
        if(command.equalsIgnoreCase("Add_Doctor")){
            // loop for doctors 
            for(int i = counter ; i<HPerson.length ; i++){
                if(command.equalsIgnoreCase("Add_Doctor") ){
                HPerson[i]=  getDoctor(input1);//in this indix I will fill the array using getDoctor method
                output1.println("Command "+command+": Add a new doctor record in the System");
                output1.println(HPerson[i].toString());
                output1.println();
                output1.println("----------------------------------------------------------------");

                counter++;// this counter to count how mana objects I fill 
                command= input1.next();
                }}}
        
        if(command.equalsIgnoreCase("Add_Nurse")){
            //loop for nurse to print all informatio 
            for(int i = counter ; i<HPerson.length;i++){
                //I start this loop from counter because I use one array with diffrent type of objects
                if(command.equalsIgnoreCase("Add_Nurse")){
                HPerson[i]=getNurse(input1);//in this indix I will fill the array using getNurse method
                // print nurse information
                output1.println("Command "+command+": Add a new nurse record in the System");
                output1.println(HPerson[i].toString());
                output1.println();
                 output1.println("----------------------------------------------------------------");

                counter++; // this counter to count how mana objects I fill 
                command=input1.next();
                
                }
            }}
            
            if(command.equalsIgnoreCase("Add_Patient")){
                //loop for patint to print all information 
              for(int i = counter ; i<HPerson.length;i++){
                //I start this loop from counter because I use one array with diffrent type of objects
                  if(command.equalsIgnoreCase("Add_Patient")){
                HPerson[i]= getPatientRecord( input1);//in this indix I will fill the array using getPatientRecord method
                //print all information about patient   
                output1.println("Command "+command+": \nAdd a new Patient record in the System");
                  output1.println(HPerson[i].toString());
                  output1.println("-------------------------------------------------------------------------------------------");
                  output1.println("Illness: "+((Patient)HPerson[i]).getIllness() + ", Blood Group: "+((Patient)HPerson[i]).getBloodGroup());
                  output1.println("-------------------------------------------------------------------------------------------");
                  output1.println();
                  output1.println("----------------------------------------------------------------");

                  counter++; // this counter to count how mana objects I fill 
                  command = input1.next();
              }  }
            }
            
             while (command.equalsIgnoreCase("Assign_Doctor_Patient")){
                 // read the var from file    
                    int Id_Doctor = input1.nextInt();
                    int Id_Patient = input1.nextInt();
                    boolean flag1= true;
                     output1.println("Command "+command+":" ); 
                 for (Person HPerson1 : HPerson) {//this loop passes through all elements of the HPerson array 
                    if (HPerson1.getId() == Id_Doctor) { // search about the doctor + compare the Ids
                        for (Person HPerson2 : HPerson) {//this loop passes through all elements of the HPerson array
                            if (HPerson2.getId() == Id_Patient) {// search about the patient + compare the Ids
                                ((Patient)HPerson2).setDoctor((Doctor)HPerson1);// set doctor to save doctor information
                                // print information 
                                output1.println("Successfully Processed by the System: " +"\nFollowing are the details:");
                                output1.println("\t\t    Patient: " + HPerson2.getName());
                                output1.println("\t\t    Assigned to Doctor: " + HPerson1.getName());
                                flag1=false;// this flag to check if the program inter here or not
                                
                            } 
                            else if (HPerson2==null) {//check the doctor is found or not
                                output1.println("Doctor* " + HPerson2.getId() + " NOT FOUND");
                                flag1 = false;// this flag to check if the program inter here or not
                        }} 
                        if(flag1 ){//check the pateint is found or not
                            output1.println("Patient " + Id_Patient+ " NOT FOUND");
                             flag1 = false ;// this flag to check if the program inter here or not
                        }
                        
                    } 
                    else if (HPerson1== null) //check the patient is found or not
                        output1.println("Patient " + HPerson1.getId() + " NOT FOUND");
                    
                }
                if(flag1)//check the doctor is found or not
                    output1.println("Doctor " + Id_Doctor+ " NOT FOUND");      
                command = input1.next();
                output1.println("----------------------------------------------------------------");
  
            }
            
            while(command.equalsIgnoreCase("Assign_Room_Patient")){
                // read information from file 
                int RoomNO=input1.nextInt() ;
                int Id_P= input1.nextInt();
                
                 output1.println("Command "+command + ":" ); 
                 boolean flag = true;
                 for ( Room room : HRoom) {//this loop passes through all elements of the HRoom array
                    if (RoomNO == room.getRoomNO()){//search about RoomNO 
                        for (Person HPerson1 : HPerson) {//this loop passes through all elements of the HPerson array
                            if (Id_P == HPerson1.getId()) { // search about patient Id
                                ((Patient)HPerson1).setRoom(room); // set Room to save all information 
                                // print all information 
                                output1.println("Successfully Processed by the System:" +"\nFollowing are the details:");
                                output1.println("\t  Patient: " + HPerson1.getName());
                                output1.println("\t  Assigned to Room: "+"\t Room No: "+room.getRoomNO());
                                output1.println("\t  Located in floor: "+room.getFloor());
                                output1.println("\t  Block :"+room.getBlock());
                                output1.println("\t   Charges: "+room.getCharges());
                                output1.println();
                                flag = false;// this flag to check if the program inter here or not
                            }
                            else if(HPerson1==null) { // check patient is found or not 
                                output1.println("Patient " + HPerson1.getId() + " NOT FOUND");
                                output1.println("----------------------------------------------------------------");
                                flag = false;// this flag to check if the program inter here or not
                            }
                        }
                        if(flag){//check patient is found or not 
                            output1.println("Patient " +Id_P+ " NOT FOUND");
                            flag = false;// this flag to check if the program inter here or not
                    }
                    else if (room == null)  // check room is found or not          
                        output1.println("Room " + room.getRoomNO()+ " NOT FOUND");  
                 
                     }}
                 if(flag)//check room is found or not
                     output1.println("Room " + RoomNO+ " NOT FOUND");  
                command= input1.next();
                output1.println("----------------------------------------------------------------");
                 
                        }
            
            while(command.equalsIgnoreCase("Assign_Medicine_Patient")){
             //read data from file 
             int Id_Patient = input1.nextInt();
             int numOfMed = input1.nextInt();
             int[] Med = new int[numOfMed];// array for medicine to store medicinse from file
             String [] MedName = new String [numOfMed];//array for medicines namse 
             int count = 0 ;
             boolean flag = true ;
             for(int i = 0 ; i <numOfMed ;i++){ // loop to store all medicines in Med array 
                 Med[i]=input1.nextInt();
             }

             output1.println("Command " + command +":" );
             
             for(Person HPerson1 : HPerson){//this loop passes through all elements of the HPerson  array
                 if(HPerson1.getId() == Id_Patient){//search about patient Id + compare tha Ids
                    if(((Patient)HPerson1).getTotalMedicine()==numOfMed){//check the number of medicines are equal or not 
                     for(int j = 0 ; j<Med.length;j++){//this loop passes through all elements of the Med array
                         flag = true ;
                        for(Medicine HMed : HMedicine){//this loop passes through all elements of the HMedicine array
                             if(HMed.getMedicineCode() == Med[j]){//search about Medicine code + compare codes
                                 flag = false ;// this flag to check if the program inter here or not
                                 count++;// this counter to count how many objects I fill 
                                 MedName[j]=HMed.getName();// store medicine names in the array 
                          ((Patient)HPerson1).setMedicine(HMed, j); // set the medicines 
                              }}
                        if(flag){// check medicines are found or not 
                            output1.println("Medicines "+Med[j]+" NOT FOUND");
                             flag = false ; }// this flag to check if the program inter here or not   
             } if(count==numOfMed){ // check the counter (number of objects I fill it ) equal number of medicines or not 
                output1.println("Successfully Processed by the System:" +"\nFollowing are the details:");
                output1.println("\t  Patient: "+HPerson1.getName());
                 for(int g = 0 ; g < MedName.length;g++){// loop to print medicine names 
                    output1.println("\t  Medicine Prescribed: "+MedName[g]);
                 }
             }
                    }
                    else { //if counter not equal numOfMed 
                           output1.println("Information mismatch: Patient "+Id_Patient +"must have "+ 
                               ((Patient) HPerson1).getTotalMedicine() + " medicine not " + numOfMed);
                            flag = false ;        }// this flag to check if the program inter here or not
           flag =false ; }    }// this flag to check if the program inter here or not
            if(flag)//check the patient found or not  
                output1.println("Patient "+Id_Patient +" NOT FOUND ");
            
              command = input1.next();
                 output1.println("----------------------------------------------------------------");
              
            }
            
            if(command.equalsIgnoreCase("Print_Bill")){
               // print Data
                output1.println();
                output1.println();
                output1.println("Command: "+command+"\n");
                output1.println("\n\n--------------- Welcome to KAU Hospital System ---------------");
                Date D = new Date (); // Date
                output1.println("\n--------- Current Date :  "+ D +"--------");
                output1.println("\n==================================================================");
             
            java.util.Arrays.sort(HPerson); // sort HPerson array by Ids
                for (Person HPerson1 : HPerson){//this loop passes through all elements of the HPerson  array
                    
                    if(HPerson1 instanceof Patient ){//check the object in this index instansof Patient
                        //print
                        output1.println(((Patient) HPerson1).printPatientBasicInfo());
                        output1.print("\t  Medicinens are: ");
                        for(int j = 0  ; j<(((Patient)HPerson1).getTotalMedicine());j++){//loop to print medicin
                        
                      output1.printf("\n\t %-15s%-14s%-7s%.1f%-5s" ," Medicine name: ",((Patient)HPerson1).getMedicine(j).getName() 
                      ," Price: ",((Patient)HPerson1).getMedicine(j).getPrice() , " SR")  ;}
                        output1.println("\n\t  Room: "+(((Patient) HPerson1).getRoom()).getRoomNO()+"  Room Charges: "+(((Patient) HPerson1).getRoom()).getCharges()+ " SR");
                        
                        output1.println("\t\t\t==== Total Charges : "+((Patient) HPerson1).calTotalBill()+" SR ====");
                        output1.println("----------------------------------------------------------------");

                        
                    }
                }
                
            }
            output1.println("Thank you for using KAU Hospital System, Good Bye!");
        input1.close();
        output1.close();
    
        } while(command.equalsIgnoreCase("Quit"));
        
        }
    
////////////////////////////////////////////////////////////////////////////////
private static Doctor getDoctor(Scanner input1){//this method fills tha array
    // read data from file 
                String cons = input1.next();
                Double consultationFree = Double.valueOf(cons);
                String specializion =input1.next();
                String staffid = input1.next();
                int id = input1.nextInt();
                String name = input1.next();
                String nationality = input1.next();
                char gender = input1.next().charAt(0);
                int phone = input1.nextInt();
               // creat new object and return it 
                Doctor D = new Doctor ( consultationFree,  staffid ,specializion ,id , name ,nationality ,gender ,phone);
             
    return D ;
   } 
  //////////////////////////////////////////////////////////////////////////////  
   private static Nurse getNurse(Scanner input1){//this method fills tha array
       //read data from file 
     int experience= input1.nextInt();
      String specializion =input1.next();
                String staffid = input1.next();
                int id = input1.nextInt();
                String name = input1.next();
                String nationality = input1.next();
                char gender = input1.next().charAt(0);
                int phone = input1.nextInt();
                //creat new object and return it 
                Nurse N = new Nurse(experience,staffid ,specializion ,id , name ,nationality ,gender ,phone);
                return N;
   }
   /////////////////////////////////////////////////////////////////////////////
   private static Room getRoom(Scanner input1){//this method fills tha array
       // read data from file
        int roomNO = input1.nextInt();
        String floor = input1.next();
        String block = input1.next();
        String charg = input1.next();
        Double charges =Double.parseDouble(charg);
        //creat new object and return it 
        Room R = new Room (roomNO , floor , block ,charges);
                  return R;
   }
  //////////////////////////////////////////////////////////////////////////////
   private static Medicine getMedicine( Scanner input1){//this method fills tha array
       //read data from file 
        int medicineCode = input1.nextInt();
        String name = input1.next();
        String pri = input1.next();
        Double price = Double.parseDouble(pri);
        // creat new object and return it
        Medicine M  = new Medicine (medicineCode , name, price);
        return M;
   }
  ////////////////////////////////////////////////////////////////////////////// 
   private static Patient getPatientRecord(Scanner input1){//this method fills tha array
       //read data from file 
          String illness = input1.next();
                        String bloodGroup  = input1.next();
                        int id =input1.nextInt();
                        String name =input1.next();
                        String nationality =input1.next();
                        char gender =input1.next().charAt(0);
                        int phone =input1.nextInt();
                        int totMedicine = input1.nextInt(); 
                        //creat new object and return it 
              Patient P = new Patient( illness ,  bloodGroup ,id ,name ,nationality ,gender , phone ,totMedicine);
                   
       return P;
   }
}
   
