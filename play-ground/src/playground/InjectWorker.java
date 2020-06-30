package playground;

import com.google.inject.Inject;

public class InjectWorker extends ClassicWorker {

	@Inject
	public InjectWorker(TimeService timeService, DataBaseSrvice db) {
		super(timeService, db);
	}

}
