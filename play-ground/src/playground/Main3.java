package playground;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main3 {

	public static void main(String[] args) {

		System.out.println("Injecting worker");

		Injector injector = Guice.createInjector();

		InjectWorker worker = injector.getInstance(InjectWorker.class);

		worker.execute();
	}
}
