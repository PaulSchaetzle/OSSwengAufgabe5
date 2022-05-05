package de.hfu.residents.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.junit.Test;
import org.junit.Assert.*;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentRepositoryTest {
		
	@Test(expected=ResidentServiceException.class, timeout=1000)
	public void test_unique_wildcard() throws ResidentServiceException {		
		Resident Filter = new Resident("*", "*", "*", "*", new Date());
		ResidentRepository stub = new ResidentRepositoryStub();
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(stub);
		service.getUniqueResident(Filter);
	}

	@Test
	public void test_uniqueresident() throws ResidentServiceException {
		Resident Paul = new Resident("Paul", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		Resident Raphael = new Resident("Raphael", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		BaseResidentService service = new BaseResidentService();
		stub.addResident(Paul);
		stub.addResident(Raphael);
		service.setResidentRepository(stub);
		assert(service.getUniqueResident(Paul) == Paul);
		assert(service.getUniqueResident(Raphael) != Paul);
	}
	
	@Test(expected=ResidentServiceException.class, timeout=1000)
	public void test_uniqueresident_not_unique() throws ResidentServiceException {
		Resident Paul = new Resident("Paul", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		Resident Paul2= new Resident("Paul", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		BaseResidentService service = new BaseResidentService();
		stub.addResident(Paul);
		stub.addResident(Paul2);
		service.setResidentRepository(stub);
		service.getUniqueResident(Paul);
	}
	
	@Test 
	public void test_emptyFields() {
		Resident Paul = new Resident("Paul", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		Resident Raphael = new Resident("Raphael", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		Resident Filter = new Resident("", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		BaseResidentService service = new BaseResidentService();
		stub.addResident(Paul);
		stub.addResident(Raphael);
		service.setResidentRepository(stub);
		assert(service.getFilteredResidentsList(Filter).size()==2);
	}
	
	@Test 
	public void test_filter_wildcard() {
		Resident Paul = new Resident("Paul", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		Resident Raphael = new Resident("Raphael", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		Resident Filter = new Resident("*", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		BaseResidentService service = new BaseResidentService();
		stub.addResident(Paul);
		stub.addResident(Raphael);
		service.setResidentRepository(stub);
		assert(service.getFilteredResidentsList(Filter).size()==2);	
	}
	
	@Test 
	public void test_filter() {
		Resident Paul = new Resident("Paul", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		Resident Raphael = new Resident("Raphael", "Schaetzle", "Obertal", "Titisee-Neustadt", new Date());
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		BaseResidentService service = new BaseResidentService();
		stub.addResident(Paul);
		stub.addResident(Raphael);
		service.setResidentRepository(stub);
		assert(service.getFilteredResidentsList(Paul).contains(Paul));
	}
	

}
