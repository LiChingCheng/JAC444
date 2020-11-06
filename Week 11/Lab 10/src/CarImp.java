
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarImp extends UnicastRemoteObject implements CarInterface {
    protected CarImp() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    public String carRegister(Car car) throws RemoteException {
        return " " + Math.abs(car.hashCode());
    }
}
