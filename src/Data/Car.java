package Data;

public class Car {
	private Boolean cool ;
	public Car(Boolean cool) {
		this.cool = cool;
	}
	@Override
    public String toString() {
		if (cool == true) {
			return (" has a cool car");
		}
		else {
			return (" doesn't have a cool car");
		}   
    }
    
}
