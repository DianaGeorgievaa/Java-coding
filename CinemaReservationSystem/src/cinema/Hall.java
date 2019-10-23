package cinema;

public class Hall {

	private int number;
	private int rows;
	private int rowSeats;

	public Hall(int number, int rows, int rowSeats) {
		this.number = number;
		this.rows = rows;
		this.rowSeats = rowSeats;
	}

    public int getRows() {
        return rows;
    }

    public int getRowSeats() {
        return rowSeats;
    }
}
