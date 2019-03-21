 public class newDog{
   public void bark(){
     System.out.println("Moo");
   }
   public static void runFast(){
     System.out.println("Ruff Run");
   }
   public static void main(String[] args){
   	 newDog poppa = new newDog();
	 poppa.bark();
	 /*newDog.bark();*/
	 poppa.runFast();
	 newDog.runFast();
   }
 }