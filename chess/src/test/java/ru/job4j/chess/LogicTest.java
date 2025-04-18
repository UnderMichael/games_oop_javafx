package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

	@Test
	public void whenMoveThenFigureNotFoundException()
			throws FigureNotFoundException,
			OccupiedCellException,
			ImpossibleMoveException {
		Logic logic = new Logic();
		FigureNotFoundException exception = assertThrows(FigureNotFoundException.class,
				() -> logic.move(Cell.C1, Cell.H6));
		assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
	}

	@Test
	public void whenMoveThenOccupiedCellException()
			throws FigureNotFoundException,
			OccupiedCellException,
			ImpossibleMoveException {
		Logic logic = new Logic();
		logic.add(new BishopBlack(Cell.A1));
		logic.add(new BishopBlack(Cell.B2));
		OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
			logic.move(Cell.A1, Cell.C3);
		});
		assertThat(exception).isInstanceOf(OccupiedCellException.class);
	}

	@Test
	public void whenMoveThenImpossibleMoveException()
			throws FigureNotFoundException,
			OccupiedCellException,
			ImpossibleMoveException {
		Logic logic = new Logic();
		logic.add(new BishopBlack(Cell.A1));
		ImpossibleMoveException exception = assertThrows(
				ImpossibleMoveException.class,
				() -> logic.move(Cell.A1, Cell.C4));
		assertThat(exception).isInstanceOf(ImpossibleMoveException.class);
	}
}
