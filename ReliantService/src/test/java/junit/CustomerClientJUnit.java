package junit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.reliant.electricityservice.client.rest.CustomerClient;
import com.reliant.electricityservice.model.registration.Customer;

public class CustomerClientJUnit {

	@Test
	public void test() {

		CustomerClient mockCustomerClient = Mockito.mock(CustomerClient.class);
		Customer customer = new Customer();
		customer.setId(22);
		customer.setFirstname("naveen");
		customer.setLastname("kurakula");
		customer.setPassword("nana");
		customer.setUsername("nkurakula");

		when(mockCustomerClient.getCustomerById(22)).thenReturn(customer);

		Customer cust = mockCustomerClient.getCustomerById(22);
		assertSame(customer, cust);
	}

}
