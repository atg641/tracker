class Gear {
	int chainRingTeeth;
	int sprocketTeeth;
	double wheelDiameter = 27;
	
	double computeGearInches() {
		return wheelDiameter * chainRingTeeth / sprocketTeeth;
		
	}
	void changeGear(int crt, int st){
		chainRingTeeth = crt;
		sprocketTeeth = st;
		}
	}
