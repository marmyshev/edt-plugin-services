package playground;

public class Main {

	public static void main(String[] args) {

		System.out.println("Classic worker");

		final TimeService timeService = new TimeService();
		final DataBaseSrvice db = new DataBaseSrvice();

		ClassicWorker worker = new ClassicWorker(timeService, db);

		worker.execute();
	}

}
