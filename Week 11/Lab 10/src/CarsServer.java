//a simple client/server application: car registration
//a SERVER program that uses a stream socket connection to exchange objects

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarsServer {

	public static void main(String[] args) {

		try {
			CarInterface car = new CarImp();
			Registry registry = LocateRegistry.createRegistry(0106);
			registry.rebind("CarService", car);
			System.out.println("*** this server is going to register the cars ***");
			System.out.println("listening for a connection...");

		} catch (Throwable throwable) {
            System.out.println("Car Throwable: " + throwable.getMessage());
            System.exit(1);
		}
		//System.out.println("*** the server is going to stop running ***");
	}
}