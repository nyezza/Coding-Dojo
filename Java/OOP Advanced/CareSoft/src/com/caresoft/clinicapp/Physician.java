package com.caresoft.clinicapp;


public class Physician extends User implements HIPAACompliantUser {
//... imports class definition...
    
   
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
   // TO DO: Setters & Getters 
	public Physician(int i) {
		this.id=i;
	}
    

    @Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if (pin < 4 || pin > 9999) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		
		if (this.id == confirmedAuthID) {
			return true;
		}
		return false;
	}
	
    

}
