package interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LoadBalancerTest {
    
	//It should be possible to register an instance,identified by an address;
    @Test
    void instanceInsertTest()
    {
    	 long ip=1;
    	 LoadBalancer register = new LoadBalancer();
    	 RegisterInstance registerInstance = new RegisterInstance();   	     	 
         assertEquals(true, register.register(registerInstance,ip));
    }
    
    //Each address should be unique; It should not be possible to register the same address more than once;
    @Test
    void duplicatedInstanceInsertTest()
    {
    	 long ip=1;
    	 LoadBalancer register = new LoadBalancer();
    	 RegisterInstance registerInstance = new RegisterInstance();   	     	 
         assertEquals(true, register.register(registerInstance,ip));
         assertEquals(false, register.register(registerInstance,ip));
    }
    
    //Load Balancer should accept up to 10 addresses
    @Test
    void insertMoreThanTenInstancesTest()
    {
    	 long ip=1;
    	 LoadBalancer register = new LoadBalancer();
    	 RegisterInstance registerInstance = new RegisterInstance();
    	 for(int i=0;i<register.MAX_CONNECTIONS;i++)
    	 {
    		 assertEquals(true, register.register(registerInstance,ip+i));
    	 }         
         assertEquals(false, register.register(registerInstance,ip-1));
    }
}
