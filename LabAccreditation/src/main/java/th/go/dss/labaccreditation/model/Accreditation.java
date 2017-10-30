package th.go.dss.labaccreditation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accreditation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	// หมายเลขการรับรองภาษาไทย 
	// เช่น "ทดสอบ - 0001"
	private String NumTh;

	// หมายเลขการรับรองภาษาอังกฤษ 
	// เช่น "Testing - 0001"
	private String NumEn;
	
	// ขอบข่ายการรับรอง
	private Set<AccreditedScope> scopes;
	
	// path file ใบรับรอง pdf 
	private String filePath;
}
