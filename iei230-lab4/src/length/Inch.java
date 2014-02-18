/**
 * @author Daniel Maldonado
 */
package length;

/**
 * @author Daniel Maldonado
 */
public class Inch extends Length {
	public static final double METERS_PER_INCH = 0.0254;

	public Inch(double length) {
		super(length);
	}

	/**
	 * Converts this length and the other length to meters and then reconverts back to Inch type.
	 * 
	 * @param other An object that is a subclass of Length.
	 */
	@Override
	public void add(Length other) {
		this.setLength((other.toMeters()  / METERS_PER_INCH) + this.getLength());
	}

	/**
	 * Returns 'inches' if length is greater than 1 and 'inch' if it is 1 or less.
	 * 
	 * @return String of the correct singular and plural version of unit.
	 */
	@Override
	public String getUnit() {
		if (this.getLength() <= 1.0) {
			return "inch";
		}
		return "inches";
	}

	/**
	 * Takes length value of objects and converts it to meters.
	 * 
	 * @return double value of length in meters.
	 */
	@Override
	public double toMeters() {
		return this.getLength() * METERS_PER_INCH;
	}

}
