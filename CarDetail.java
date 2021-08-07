package Implementation;

import java.util.Comparator;

public class CarDetail {

	public int carID;
	public String modelName;
	public String brand;
	public int mileage;
	public double cost;
	
	public CarDetail(int carID, String modelName, String brand,
			int mileage, double cost) {
		super();
		this.carID = carID;
		this.modelName = modelName;
		this.brand = brand;
		this.mileage = mileage;
		this.cost = cost;
	}

	public CarDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCarID() {//getters & setters for each parameter
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getmodelName() {
		return modelName;
	}
	public void setmodelName(String modelName) {
		this.modelName = modelName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public static Comparator<CarDetail> carIdComparator = new Comparator<CarDetail>() {//to sort based on car id
		public int compare(CarDetail c1, CarDetail c2) {
			return c1.getCarID()-c2.getCarID();
		}
	};
	
	public static Comparator<CarDetail> modelComparator = new Comparator<CarDetail>() {//to sort based on model
		public int compare(CarDetail c1, CarDetail c2) {
			return c1.getmodelName().compareToIgnoreCase(c2.getmodelName());
		}
	};
	
	public static Comparator<CarDetail> brandComparator = new Comparator<CarDetail>() {//to sort based on brand
		public int compare(CarDetail c1, CarDetail c2) {
			return c1.getBrand().compareToIgnoreCase(c2.getBrand());
		}
	};
	
	public static Comparator<CarDetail> mileageComparator = new Comparator<CarDetail>() {//to sort based on mileage
		public int compare(CarDetail c1, CarDetail c2) {
			return c1.getMileage()-c2.getMileage();
		}
	};
	
	public static Comparator<CarDetail> costComparator = new Comparator<CarDetail>() {//to sort based on cost
		public int compare(CarDetail c1, CarDetail c2) {
			return Double.compare(c1.getCost(), c2.getCost());
		}
	};
	
	@Override
    public String toString() {
        return "Car{" +
                "CarID='" + carID + '\'' +
                ", Model Name='" + modelName + '\'' +
                ", Brand='" + brand + '\'' +
                ", Mileage='" + mileage + '\'' +
                ", Cost='" + cost + '\'' +
                '}';
    } 
}
