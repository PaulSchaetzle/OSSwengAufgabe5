package de.hfu.residents.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {
		private List<Resident> residents = new ArrayList<Resident>();
		
		public void addResident(Resident resident) {
			this.residents.add(resident);
		}
		
		public List<Resident> getResidents() {
			return residents;
		}
}
