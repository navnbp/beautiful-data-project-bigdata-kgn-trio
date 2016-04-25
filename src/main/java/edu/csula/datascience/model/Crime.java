package edu.csula.datascience.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Crime   {
	
	public Boolean arrest;
	public String caseNumber;
	public String date;
	public String description;
	public String district;
	public String domestic;
	public String fbiCode;
	public int id;
	public String locationDescription;
	public String primaryType;
	public String updatedOn;
	public int year;
	
	public Crime(){}
	
	public Crime(Boolean arrest, String caseNumber, String date, String description, String district, String domestic,
			String fbi_code, int id, String location_description, String primary_type, String updated_on, int year) {
		super();
		this.arrest = arrest;
		this.caseNumber = caseNumber;
		this.date = date;
		this.description = description;
		this.district = district;
		this.domestic = domestic;
		this.fbiCode = fbi_code;
		this.id = id;
		this.locationDescription = location_description;
		this.primaryType = primary_type;
		this.updatedOn = updated_on;
		this.year = year;
	}
	
	public Boolean getArrest() {
		return arrest;
	}
	
	public void setArrest(Boolean arrest) {
		this.arrest = arrest;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getDomestic() {
		return domestic;
	}
	public void setDomestic(String domestic) {
		this.domestic = domestic;
	}
	public String getFbiCode() {
		return fbiCode;
	}
	public void setFbiCode(String fbi_code) {
		this.fbiCode = fbi_code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocationDescription() {
		return locationDescription;
	}
	public void setLocationDescription(String location_description) {
		this.locationDescription = location_description;
	}
	public String getPrimaryType() {
		return primaryType;
	}
	public void setPrimaryType(String primary_type) {
		this.primaryType = primary_type;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updated_on) {
		this.updatedOn = updated_on;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	public static int nullValueCt=1;
	
	public static int getNullValueCt() {
		return nullValueCt;
	}

	public static void setNullValueCt(int nullValueCt) {
		Crime.nullValueCt = nullValueCt;
	}

	public Crime convertToCrimeEntity(CrimeJSON json)
	{
		if(json.getArrest()==null || json.getCase_number()==null||
			json.getDate()==null || json.getDistrict()==null ||
			json.getDescription()==null|| json.getDomestic()==null ||
			json.getFbi_code()==null|| json.getId()==null ||
			json.getLocation_description()==null|| json.getPrimary_type()==null ||
			json.getUpdated_on()==null|| json.getYear()==null )
		{
			System.out.println("Null Value -->"+nullValueCt);
			nullValueCt++;
			return null;
		}
		
		Crime crime=new Crime();
		crime.setArrest(json.getArrest().equals("true")?Boolean.TRUE:Boolean.FALSE);
		crime.setCaseNumber(json.getCase_number());
		crime.setDate(json.getDate().substring(0, 10));
		crime.setDistrict(json.getDistrict());
		crime.setDescription(json.getDescription());
		crime.setDomestic(json.getDomestic());
		crime.setFbiCode(json.getFbi_code());
		crime.setId(Integer.parseInt(json.getId()));
		crime.setLocationDescription(json.getLocation_description());
		crime.setPrimaryType(json.getPrimary_type());
		crime.setUpdatedOn(json.getUpdated_on().substring(0, 10));
		crime.setYear(Integer.parseInt(json.getYear()));
		return crime;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caseNumber == null) ? 0 : caseNumber.hashCode());
		result = prime * result + id;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		if (caseNumber == null) {
			if (other.caseNumber != null)
				return false;
		} else if (!caseNumber.equals(other.caseNumber))
			return false;
		if (id != other.id)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	   public String toString() {
 	   return this.getCaseNumber()+"~"+this.getId()+"~"+this.getYear()+"~"+this.getArrest()+"~"+this.getDate()+"~"+this.getDescription()+"~"+this.getDistrict()+"~"+this.getDomestic()+"~"+this.getFbiCode()+"~"+this.getLocationDescription()+"~"+this.getPrimaryType()+"~"+this.getUpdatedOn();
	   }

	
	

}
