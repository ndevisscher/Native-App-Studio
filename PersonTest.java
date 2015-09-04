class Person {

   // Properties of the class...
   private String name;
   private int    age;
   private string birthplace;
    
   // Constructor of the class...
   public Person(String aName, int anAge, string aBirthplace) {
      name = aName;
      age  = anAge;
      birthplace = aBirthplace;
   }

   // Methods of the class...
   public void talk() {
      System.out.println("Hi, my name's " + name);
      System.out.println("and my age is " + age);
      System.out.println("and my birthplace is " + birthplace);
      System.out.println();
   }
   public void commentAboutAge() {
      if (age < 5) {
         System.out.println("baby");
      }
      if (age == 5) {
         System.out.println("time to start school");
      }
      if (age>60) {
      System.out.println("old person");
      }
   }

   public void growOlder() {
      age += 1;
   }
   public void giveKnighthood() {
      name = "Sir " + name;
   }

}

class PersonTest {

   // The main method is the point of entry into the program...
   public static void main(String[] args) {

      Person ls = new Person("Luke Skywalker",34,"Alderaan");
      Person wp = new Person("Winston Peters",48,"london");

      ls.talk();
      wp.giveKnighthood();
      wp.talk();
      ls.commentAboutAge();
      wp.commentAboutAge();
      wp.growOlder();

   }

}

