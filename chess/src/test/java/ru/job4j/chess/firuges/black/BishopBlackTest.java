package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {
	@Test
	public void checkPositionWhenCreated() {
		BishopBlack bishop = new BishopBlack(Cell.C8);
		assertThat(bishop.position()).isEqualTo(Cell.C8);
	}

	@Test
	public void checkPositionWhenCopy() {
		Figure bishop = new BishopBlack(Cell.C8);
		bishop = bishop.copy(Cell.A1);
		assertThat(bishop.position()).isEqualTo(Cell.A1);
	}

	@Test
	public void whenWayFromC1ToG5() {
		BishopBlack bishop = new BishopBlack(Cell.C1);
		Cell[] way = bishop.way(Cell.G5);
		assertThat(way).containsExactly(Cell.D2, Cell.E3, Cell.F4, Cell.G5);
	}

	@Test
	public void whenWayFromG5ToC1() {
		BishopBlack bishop = new BishopBlack(Cell.G5);
		Cell[] way = bishop.way(Cell.C1);
		assertThat(way).containsExactly(Cell.F4, Cell.E3, Cell.D2, Cell.C1);
	}

	@Test
	public void whenWayNotDiagonal() {
		BishopBlack bishop = new BishopBlack(Cell.C1);
		ImpossibleMoveException exception = assertThrows(
				ImpossibleMoveException.class,
				() -> bishop.way(Cell.G6));
		assertThat(exception.getMessage())
				.isEqualTo("Could not way by diagonal from C1 to G6");

	}
}