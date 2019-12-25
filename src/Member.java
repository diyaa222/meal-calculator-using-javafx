import java.text.DecimalFormat;

public class Member {
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	String name;
	double bazar;
	int meal;
	double will_pay = 0;
	double will_get = 0;
	double meal_rate;
	
	public Member() {
		
	}
	
	public Member (String name, double bazar, int meal) {
		this.name = name;
		this.bazar = bazar;
		this.meal = meal;
		this.will_get = 0;
		this.will_pay = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBazar() {
		return bazar;
	}

	public void setBazar(int bazar) {
		this.bazar = bazar;
	}

	public int getMeal() {
		return meal;
	}

	public void setMeal(int meal) {
		this.meal = meal;
	}
	public String getMealRate() {
		return df2.format(this.meal_rate);
	}
	
	public void calculateMealRate(double total_bazar, int total_meal) {
		double meal_rate = total_bazar/total_meal;
		this.meal_rate = meal_rate;
	}
	
	public void calculatePayOrGet() {
		double eaten_meal = meal*meal_rate;
//		System.out.println("eaten_meal = " +eaten_meal);
//		System.out.println("bazar = "+bazar);
		if(this.bazar > eaten_meal) {
			this.will_get = this.bazar - eaten_meal;
		}
		if(this.bazar < eaten_meal) {
			this.will_pay = eaten_meal - this.bazar;
		}
		if(this.bazar == eaten_meal) {
			will_pay = 0;
			will_get = 0;
		}
	}
	
	@Override
	public String toString() {
		String msg = "Name: " + this.name +" has eaten " + this.meal + " meals. Bazar: " + this.bazar;
		if(this.will_get > 0) {
			msg = msg + " He will get " + this.will_get + " taka back";
		}
		else if(this.will_pay > 0) {
			msg = msg + " He will pay " + this.will_pay + " taka more";
		}
		return msg;
	}

	public String getWill_pay() {
		return df2.format(will_pay);
	}

	public void setWill_pay(double will_pay) {
		this.will_pay = will_pay;
	}

	public String getWill_get() {
		return df2.format(will_get);
	}

	public void setWill_get(double will_get) {
		this.will_get = will_get;
	}
}
