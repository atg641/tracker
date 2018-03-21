package bicycle;

class Gear {
	int chainRingTeeth = 53;
	int sprocketTeeth = 20;
	static final double wheelDiameter = 27.0;
	
	double computeGearInches() {
		return wheelDiameter * chainRingTeeth / sprocketTeeth;
	}
	
	void changeGear(int crt, int st){
		chainRingTeeth = crt;
		sprocketTeeth = st;
		}

	@Override
	public String toString() {
		return "Gear [chainRingTeeth=" + chainRingTeeth + ", sprocketTeeth=" + sprocketTeeth + "]";
	}
	}
