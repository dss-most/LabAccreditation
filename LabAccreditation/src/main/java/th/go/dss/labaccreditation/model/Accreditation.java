package th.go.dss.labaccreditation.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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
	@ElementCollection(targetClass=AccreditedScope.class)
	@CollectionTable(name="AccreditedScope", joinColumns = @JoinColumn(name="accreditation_id"))
	@Column(name="scope_name",nullable = true)
	@Enumerated(EnumType.STRING)
	private Set<AccreditedScope> scopes;
	
	// path file ใบรับรอง pdf 
	private String filePath;
}
