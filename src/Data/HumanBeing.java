package Data;

import java.time.LocalDateTime;

public class HumanBeing implements Comparable<HumanBeing>  {
	private Long id ;
    private String name; 
    private Coordinates coordinates; 
    private LocalDateTime creationDate; 
    private boolean realHero;
    private Boolean hasToothpick; 
    private Double impactSpeed; 
    private Integer minutesOfWaiting; 
    private WeaponType weaponType; 
    private Mood mood;
    private Car car;  
    public HumanBeing () {
    	super ();
    }
    public HumanBeing (Long id, String name, Coordinates coordinates, LocalDateTime creationDate, boolean realHero,
    	Boolean hasToothpick, Double impactSpeed, Integer minutesOfWaiting, WeaponType weaponType, Mood mood, Car car ) {
    	super () ;
    	this.id = id ;
    	this.name = name ;
    	this.coordinates = coordinates ;
    	this.creationDate = creationDate;
    	this.realHero = realHero ;
    	this.hasToothpick = hasToothpick ;
    	this.impactSpeed = impactSpeed ;
    	this.minutesOfWaiting = minutesOfWaiting ;
    	this.weaponType = weaponType ;
    	this.mood = mood;
    	this.car = car;
    	
    }
   public void setId (Long id) {
	   this.id = id;
   }
   public Long getId() {
	   return id ;
   }
   public String getName() {
	   return name;
   }
   public Coordinates getCoordinates() {
       return coordinates;
   }
   public LocalDateTime getCreationDate() {
       return creationDate;
   }
   public boolean getHero() {
	   return realHero;
   }
   public Boolean getToothpick () {
	   return hasToothpick;
   }
   public Double getSpeed () {
	   return impactSpeed ;   
   }
   public Integer getMinutesWaiting () {
	   return minutesOfWaiting ;
   }
   public WeaponType getWeaponType () {
	   return weaponType ;
   }
   public Mood getMood () {
	   return mood ;
   }
   
   public Car getCar() {
	   return car;
   }
   @Override
   public int compareTo(HumanBeing humanbeing) {
       return id.compareTo(humanbeing.getId());
   }

   @Override
   public String toString() {
       String info = "";
       info += "HumanBeing's ID" + id;
       info += " (Added " + creationDate.toLocalDate() + " " + creationDate.toLocalTime() + ")";
       info += "\n Name: " + name;
       info += "\n Coordinates: " + coordinates;
       if (realHero == true) {
    	   info += "\n " + name +" is a true hero" ;
	   }
	   else {
		   info += "\n " + name +" is not a true hero" ;
	   }   
       if (hasToothpick == true) {
    	   info += "\n " + name +" has a toothpick";	   }
	   else {
		   info += "\n " + name +" doesn't have a toothpick";	   }   
       info += "\n " + name + "'s impact Speed: " + impactSpeed;
       info += "\n " + name + " has been wating for " + minutesOfWaiting +" minutes";
       info += "\n " + name +"'s weapon type: " + weaponType;
       info += "\n " + name +"'s mood: " + mood;
       info += "\n " + name + car.toString();
       return info;
   }

 /*  @Override
   public String toString() {
	   return "HumanBeing [Id=" + id + ", name=" + name + ", Coordinates=" + coordinates + ", LocalDateTime=" 
   + creationDate + ", realHero=" + realHero + ", hasToothpick=" + hasToothpick + ", impactSpeed=" + impactSpeed + ", minutesOfWaiting=" + minutesOfWaiting
   + ", weaponType=" + weaponType + ", Mood=" + mood + ", Car=" + car + "]";
	   
   }
   */
   @Override
   public int hashCode() {
       return name.hashCode() + coordinates.hashCode() + + impactSpeed.hashCode() + (Integer) minutesOfWaiting 
    		   + weaponType.hashCode() + mood.hashCode() + car.hashCode();
   }

   @Override
   public boolean equals(Object obj) {
       if (this == obj) return true;
       if (obj instanceof HumanBeing) {
    	   HumanBeing humanObj = (HumanBeing) obj;
           return name.equals(humanObj.getName()) && coordinates.equals(humanObj.getCoordinates()) &&
                  (realHero == humanObj.getHero()) && (hasToothpick == humanObj.getToothpick()) &&
                  (impactSpeed == humanObj.getSpeed()) && (minutesOfWaiting == humanObj.getMinutesWaiting()) &&
                  (weaponType == humanObj.getWeaponType()) && (mood == humanObj.getMood()) &&
                  car.equals(humanObj.getCar());
       }
       return false;
   }
}
