package playground;

public class Main2 {

	public static void main(String[] args) {

		System.out.println("Service Registry worker");

		ServiceRegistry registry = new ServiceRegistry();
		initServices(registry);

		RegistryWorker worker = new RegistryWorker(registry);

		worker.execute();
	}

	private static void initServices(ServiceRegistry registry) {

		initModuleA(registry);

		initModuleB(registry);

	}

	private static void initModuleA(ServiceRegistry registry) {
		TimeService timeService = new TimeService();
		registry.register(TimeService.class, timeService);
	}

	private static void initModuleB(ServiceRegistry registry) {
		DataBaseSrvice db = new DataBaseSrvice();
		registry.register(DataBaseSrvice.class, db);
	}

}
