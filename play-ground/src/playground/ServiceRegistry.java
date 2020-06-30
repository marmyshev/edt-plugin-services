package playground;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {

	private Map<Class<?>, Object> services = new HashMap<>();

	@SuppressWarnings("unchecked")
	public <T> T getService(Class<T> clazz) {
		return (T) services.get(clazz);
	}

	public <T, E extends T> void register(Class<T> clazz, E instance) {
		services.put(clazz, instance);
	}
}
