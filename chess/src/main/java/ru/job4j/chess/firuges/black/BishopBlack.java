package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
	private final Cell position;

	public BishopBlack(final Cell ps) {
		position = ps;
	}

	@Override
	public Cell position() {
		return position;
	}

	@Override
	public Cell[] way(Cell dest) {
		if (!isDiagonal(dest)) {
			throw new ImpossibleMoveException(
					String.format("Could not way by diagonal from %s to %s",
							position, dest)
			);
		}
		int size = Math.abs(position.getX() - dest.getX());
		int x = position.getX();
		int y = position.getY();
		int deltaX = position.getX() < dest.getX() ? 1 : -1;
		int deltaY = position.getY() < dest.getY() ? 1 : -1;
		Cell[] steps = new Cell[size];
		for (int i = 0; i < size; i++) {
			x += deltaX;
			y += deltaY;
			steps[i] = Cell.findBy(x, y);
		}
		return steps;
	}

	public boolean isDiagonal(Cell dest) {
		return position.getX() != dest.getX()
			   && Math.abs(position.getX() - dest.getX())
				  == Math.abs(position.getY() - dest.getY());
	}

	@Override
	public Figure copy(Cell dest) {
		return new BishopBlack(dest);
	}
}
