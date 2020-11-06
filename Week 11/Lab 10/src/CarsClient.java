
//a simple client application that exchanges OBJECTS
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarsClient {

	public static void main(String[] args) throws java.rmi.RemoteException {
		Car[] cars = new Car[3];
		cars[0] = new Car("Toyata Corolla", "Sapphire", 1000);
		cars[1] = new Car("Honda Civic", "Bronze black", 2000);
		cars[2] = new Car("Volvo S70", "Ruby red", 3000);

		for (int count = 0; count < 3; count++) {
			System.out.println("\n**** Send this car to the server for registration:\n\t" + cars[count].toString());

			try {
				CarInterface car = new CarImp();
				Registry registry = LocateRegistry.getRegistry(0106);
				registry.rebind("CarService", car);
//				CarInterface car = (CarInterface) Naming.lookup("rmi://localhost:0106/Server");
				cars[count].setRegistered(car.carRegister(cars[count]));
				System.out.println("==== The car returned by the server:\n\t" + cars[count].toString()+ "\n");

			} catch (Throwable throwable) {
				System.out.println("Car Throwable: " + throwable.getMessage());
			}
		}
		System.out.println("the client is going to stop running...");
	}
}

