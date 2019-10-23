package cinema;

public class Movie {

	private String name;
	private int duration;
	private MovieGenre genre;

	public Movie(String name, int duration, MovieGenre genre) {
		this.name = name;
		this.duration = duration;
		this.genre = genre;
	}

	public MovieGenre getGenre() {
		return genre;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Movie movie = (Movie) o;
		if (duration != movie.duration) {
			return false;
		}
		if (!name.equals(movie.name)) {
			return false;
		}
		return genre == movie.genre;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + duration;
		result = 31 * result + genre.hashCode();
		return result;
	}
}
