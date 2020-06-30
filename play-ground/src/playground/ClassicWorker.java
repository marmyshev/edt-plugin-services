package playground;

public class ClassicWorker {

	private final TimeService timeService;

	private final DataBaseSrvice db;

	public ClassicWorker(final TimeService timeService, final DataBaseSrvice db) {
		super();

		this.timeService = timeService;
		this.db = db;
	}

	public void execute() {
		System.out.println(timeService.getTime());

		db.connect();

		String result = db.execute("My new query");
		System.out.println(result);

		db.disconnect();

		System.out.println(timeService.getTime());

	}
}
