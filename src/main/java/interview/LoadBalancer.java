package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Register instances
	OK - It should be possible to register an instance,identified by an address;
	OK - Each address should be unique; It should not be possible to register the same address more than once;
	OK - Load Balancer should accept up to 10 addresses
 * */
public class LoadBalancer {
	
	public final int MAX_CONNECTIONS = 10;	
	private final Map<Long,RegisterInstanceInterface> registerInstanceMap = new HashMap<>();	
	public boolean register(RegisterInstanceInterface registerInstance, Long ipAddress)
	{
		boolean isRegistred = false;
		if(registerInstanceMap.entrySet().size()>=MAX_CONNECTIONS)
		{
			return isRegistred;
		}
		if(!registerInstanceMap.containsKey(ipAddress))
		{
			isRegistred=true;
			registerInstanceMap.put(ipAddress, registerInstance);		
		}		
		return isRegistred;		
	}
}
