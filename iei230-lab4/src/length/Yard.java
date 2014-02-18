/**
 * @author Daniel Maldonado
 */
package length;

/**
 * @author Daniel Maldonado
 */
public class Yard extends Length {
	public static final double METERS_PER_YARD = 0.9144;

	public Yard(double length) {
		super(length);
	}

	/**
	 * Converts this length and the other length to meters and then reconverts back to Yard type.
	 * 
	 * @param other An object that is a subclass of Length.
	 */
	@Override
	public void add(Length other) {
		this.setLength((other.toMeters()  / METERS_PER_YARD) + this.getLength());
	}

	/**
	 * Returns 'yards' if length is greater than 1 and 'yard' if it is 1 or less.
	 * 
	 * @return String of the correct singular and plural version of unit.
	 */
	@Override
	public String getUnit() {
		if (this.getLength() <= 1.0) {
			return "yard";
		}
		return "yards";
	}

	/**
	 * Takes length value of objects and converts it to meters.
	 * 
	 * @return double value of length in meters.
	 */
	@Override
	public double toMeters() {
		return this.getLength() * METERS_PER_YARD;
	}

}
