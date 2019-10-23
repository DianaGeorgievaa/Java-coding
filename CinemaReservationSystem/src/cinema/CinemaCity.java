package cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exceptions.AlreadyReservedException;
import exceptions.ExpiredProjectionException;
import exceptions.InvalidSeatException;
import exceptions.ProjectionNotFoundException;
import exceptions.ReservationNotFoundException;

public class CinemaCity implements CinemaReservationSystem {

	private Map<Movie, List<Projection>> cinemaProgram;
	private Map<Projection, LinkedList<Ticket>> tickets;

	public CinemaCity(Map<Movie, List<Projection>> cinemaProgram) {
		this.cinemaProgram = cinemaProgram;
		tickets = new HashMap<>();
		initializeTickets();
	}

	@Override
	public void bookTicket(Ticket ticket) throws AlreadyReservedException, ProjectionNotFoundException,
			InvalidSeatException, ExpiredProjectionException {
		validateProjection(ticket);
		validateHall(ticket);
		checkIfTicketIsReserved(ticket);

		tickets.get(ticket.getProjection()).add(ticket);
	}

	@Override
	public void cancelTicket(Ticket ticket) throws ReservationNotFoundException, ProjectionNotFoundException {
		Projection ticketProjection = ticket.getProjection();

		if (!tickets.containsKey(ticketProjection)) {
			throw new ProjectionNotFoundException("The projection is not found!");
		}

		for (Ticket t : tickets.get(ticketProjection)) {
			if (t.equals(ticket)) {
				tickets.get(ticketProjection).remove(ticket);
				return;
			}
		}

		throw new ReservationNotFoundException("The reservation is not found!");
	}

	@Override
	public int getFreeSeats(Projection projection) throws ProjectionNotFoundException {
		if (!tickets.containsKey(projection)) {
			throw new ProjectionNotFoundException("The projection is not found!");
		}

		int notAvailableSeats = tickets.get(projection).size();
		int freeSeats = projection.getHall().getRows() * projection.getHall().getRowSeats() - notAvailableSeats;
		return freeSeats;
	}

	private void initializeTickets() {
		for (Map.Entry<Movie, List<Projection>> m : cinemaProgram.entrySet()) {
			List<Projection> projections = m.getValue();
			for (Projection projection : projections) {
				tickets.put(projection, new LinkedList<Ticket>());
			}
		}
	}

	private void validateProjection(Ticket ticket) throws ExpiredProjectionException, ProjectionNotFoundException {
		Projection projection = ticket.getProjection();
		Movie movie = projection.getMovie();

		if (projection.getDate().compareTo(LocalDateTime.now()) < 0) {
			throw new ExpiredProjectionException("The projection is expired!");
		}

		if (!cinemaProgram.containsKey(movie) || cinemaProgram.get(movie).indexOf(projection) == -1) {
			throw new ProjectionNotFoundException("The projection is not found!");
		}
	}

	private void validateHall(Ticket ticket) throws InvalidSeatException {
		Hall hall = ticket.getProjection().getHall();
		if (!isValidHall(hall, ticket)) {
			throw new InvalidSeatException("The seat is invalid!");
		}
	}

	private void checkIfTicketIsReserved(Ticket ticket) throws AlreadyReservedException {
		for (Ticket t : tickets.get(ticket.getProjection())) {
			if (t.equals(ticket)) {
				throw new AlreadyReservedException("It is already reserved!");
			}
		}
	}

	private boolean isValidHall(Hall hall, Ticket ticket) {
		if (hall.getRowSeats() < ticket.getSeat().getSeat() || hall.getRowSeats() < 1
				|| hall.getRows() < ticket.getSeat().getRow() || hall.getRows() < 1) {

			return false;
		}
		return true;
	}
}
