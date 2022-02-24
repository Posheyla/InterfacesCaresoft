package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends Usuario implements UsuarioCompatibleConHIPAA {
	   
    private ArrayList<String> patientNotes;
    
    public Physician(Integer id) {
		super(id);
		this.patientNotes = new ArrayList<String>();
		
	} 
    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
    public boolean assignPin(int pin) {
    	
    	String aux = Integer.toString(pin);
    	if (aux.length()== 4 ) {
    		
    		return true;
    	}
    	
    	return false;
    	
    }
    
	public boolean accessAuthorized(Integer idIngreso) {
		if(this.id.equals(idIngreso)) {
			return true;
		}
		else {
			return false;
		}
		
	}
    

	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Fecha y hora de envío: %s \n", date);
        report += String.format("Reportado por ID: %s\n", this.id);
        report += String.format("Nombre del paciente: %s\n", patientName);
        report += String.format("Notas: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
    
}
