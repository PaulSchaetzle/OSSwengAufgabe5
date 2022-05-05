package de.hfu.residents.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.junit.Test;
import org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentServiceTestMocks {
	
			
		@Test(expected=ResidentServiceException.class, timeout=1000)
		public void test_unique_wildcard() throws ResidentServiceException {		
			Resident Filter = new Resident("*", "*", "*", "*", new Date());
			ResidentRepository mock = createMock(ResidentRepository.class);
			
			BaseResidentService service = new BaseResidentService();
			service.setResidentRepository(mock);
			service.getUniqueResident(Filter);
		}
}
