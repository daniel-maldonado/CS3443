/**
 * @author Daniel Maldonado
 */
package length;

/**
 * @author Daniel Maldonado
 */
public class Foot extends Length {
	public static final double METERS_PER_FOOT =  0.3048;

	public Foot(double length) {
		super(length);
	}

	/**
	 * Converts this length and the other length to meters and then reconverts back to Foot type.
	 * 
	 * @param other An object that is a subclass of Length.
	 */
	@Override
	public void add(Length other) {
		this.setLength((other.toMeters() / METERS_PER_FOOT) + this.getLength());
	}

	/**
	 * Returns 'feet' if length is greater than 1 and 'foot' if it is 1 or less.
	 * 
	 * @return String of the correct singular and plural version of unit.
	 */
	@Override
	public String getUnit() {
		if (this.getLength() <= 1.0) {
			return "foot";
		}
		return "feet";
	}

	/**
	 * Takes length value of objects and converts it to meters.
	 * 
	 * @return double value of length in meters.
	 */
	@Override
	public double toMeters() {
		return this.getLength() * METERS_PER_FOOT;
	}

}
