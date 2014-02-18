/**
 * @author Daniel Maldonado
 */
package length;

/**
 * @author Daniel Maldonado
 */
public class Meter extends Length {

	public Meter(double length) {
		super(length);
	}

	/**
	 * Converts this length and the other length to meters and then reconverts back to Meter type.
	 * 
	 * @param other An object that is a subclass of Length.
	 */
	@Override
	public void add(Length other) {
		this.setLength(other.toMeters() + this.getLength());
	}

	/**
	 * Returns 'meters' if length is greater than 1 and 'meter' if it is 1 or less.
	 * 
	 * @return String of the correct singular and plural version of unit.
	 */
	@Override
	public String getUnit() {
		if (this.getLength() <= 1.0) {
			return "meter";
		}
		return "meters";
	}

	/**
	 * Takes length value of objects and converts it to meters.
	 * 
	 * @return double value of length in meters.
	 */
	@Override
	public double toMeters() {
		return this.getLength();
	}

}
