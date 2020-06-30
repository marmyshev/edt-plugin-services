package playground;

public class RegistryWorker extends ClassicWorker {

	public RegistryWorker(ServiceRegistry registry) {

		super(registry.getService(TimeService.class), registry.getService(DataBaseSrvice.class));
	}

}
