class Gear {
	int chainRingTeeth;
	int sprocketTeeth;
	final static double wheelDiameter =  27 ;
	public Gear(int chr, int cog) {
		chainRingTeeth  = chr;
		sprocketTeeth = cog;
	}
	double  computeGearInches() {	
		return  (wheelDiameter * chainRingTeeth  * sprocketTeeth);
	}
}
