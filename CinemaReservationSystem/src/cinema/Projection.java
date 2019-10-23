package cinema;

import java.time.LocalDateTime;

public class Projection {
	private Movie movie;
	private Hall hall;
	private LocalDateTime date;

	public Projection(Movie movie, Hall hall, LocalDateTime date) {
		this.movie = movie;
		this.hall = hall;
		this.date = date;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Hall getHall() {
		return hall;
	}

	public Movie getMovie() {
		return movie;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Projection projection = (Projection) o;

		if (!movie.equals(projection.movie))
			return false;
		if (!hall.equals(projection.hall))
			return false;
		return date.equals(projection.date);
	}

	@Override
	public int hashCode() {
		int result = movie.hashCode();
		result = 31 * result + hall.hashCode();
		result = 31 * result + date.hashCode();
		return result;
	}
}
