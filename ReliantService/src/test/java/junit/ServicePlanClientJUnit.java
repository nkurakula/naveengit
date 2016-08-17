package junit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reliant.electricityservice.client.soap.ServicePlanClient;
import com.reliant.electricityservice.client.soap.mavimport.ServicePlan;

public class ServicePlanClientJUnit {

	private static ServicePlanClient mockedClient;
	private static ServicePlan plan1;
	private static ServicePlan plan2;

	@BeforeClass
	public static void setUp() {

		mockedClient = mock(ServicePlanClient.class);

		ServicePlan plan1 = new ServicePlan();
		plan1.setSId(1);
		plan1.setSName("Home Plan");
		plan1.setSAmount(50);

		ServicePlan plan2 = new ServicePlan();
		plan2.setSId(3);
		plan2.setSName("Student Plan");
		plan2.setSAmount(30);

		when(mockedClient.getPlanList()).thenReturn(Arrays.asList(plan1, plan2));

	}

	@Test
	public void testGetPlans() {

		List<ServicePlan> planList = mockedClient.getPlanList();

		assertEquals(2, planList.size());

		ServicePlan plan = planList.get(0);

		assertEquals(1, plan.getSId());
		assertEquals("Home Plan", plan.getSName());

	}

}
