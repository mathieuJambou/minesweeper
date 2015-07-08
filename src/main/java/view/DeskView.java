package view;

import controller.facade.MineSweeper;
import model.Desk;

/**
 * @author mathieu
 *
 */
public interface DeskView {

	public void displayDesk(Desk d, MineSweeper minesweeper);
}
