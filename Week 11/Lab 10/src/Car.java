
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Car extends UnicastRemoteObject {

	private String model;
	private String color;
	private double mileage;
	private String registration;
	//private String owner;


	public Car() throws RemoteException {
		super();
		model = null;
		color = null;
		mileage = 0.0;
		registration = null;
//		owner = null;
	}

	public Car(String brand, String color, double mile) throws RemoteException {
		setModel(brand);
		setColor(color);
		setMileage(mile);
		setRegistered("unregistered");
	}

	public void setModel(String model) {
		if (model != null) {
			this.model = model;
		}
	}

	public String getModel() {
		return model;
	}

	public void setColor(String color) {
		if (color != null) {
			this.color = color;
		}
	}

	public String getColor() {
		return color;
	}

	public void setMileage(double mileage) {
		if (mileage > 0.0) {
			this.mileage = mileage;
		}
	}

	public double getMileage() {
		return mileage;
	}

	public void setRegistered(String plate) {
		registration = plate;
	}

	public String getRegistered() {
		return registration;
	}

//	public void setOwner(String owner) {
//		if (model != null) {
//			this.owner = owner;
//		}
//	}
//
//	public String getOwner() {
//		return owner;
//	}

	public String toString() {
		return "Model: " + getModel() +
				"  Color: " + getColor() +
				"  Mileage: " + getMileage() +
				"  Registration: " + getRegistered();
	}
}
