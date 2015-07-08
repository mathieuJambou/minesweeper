package controller.facade;

import controller.service.FinaliseService;
import controller.service.FinaliseServiceImpl;
import controller.service.InitialiseService;
import controller.service.InitialiseServiceImpl;
import controller.service.RunningService;
import controller.service.RunningServiceImpl;
import exception.AreaDiscoveredException;
import exception.MineException;
import exception.OutOfDeskException;
import model.Desk;

/**
 * @author mathieu
 *
 */
public class MineSweeperImpl implements MineSweeper {

	private FinaliseService finaliseService = new FinaliseServiceImpl();
	private InitialiseService initialiseService = new InitialiseServiceImpl();
	private RunningService runningService = new RunningServiceImpl();

	@Override
	public Boolean putRandownMines(Desk desk, int mines) {
		return initialiseService.putRandownMines(desk, mines);
	}

	@Override
	public Desk initialiseDesk(int width, int height) {
		return initialiseService.initialiseDesk(width, height);
	}
	
	@Override
	public void discoverArea(Desk d, int row, int col) throws AreaDiscoveredException, OutOfDeskException, MineException {
		runningService.discoverArea(d, row, col);
	}

	@Override
	public void indicateArea(Desk d, int row, int col) {
		runningService.indicateArea(d, row, col);
	}
	
	@Override
	public Boolean IsFinished(Desk desk) {
		return finaliseService.IsFinished(desk);
	}


	public FinaliseService getFinaliseService() {
		return finaliseService;
	}

	public void setFinaliseService(FinaliseService finaliseService) {
		this.finaliseService = finaliseService;
	}

	public InitialiseService getInitialiseService() {
		return initialiseService;
	}

	public void setInitialiseService(InitialiseService initialiseService) {
		this.initialiseService = initialiseService;
	}

	public RunningService getRunningService() {
		return runningService;
	}

	public void setRunningService(RunningService runningService) {
		this.runningService = runningService;
	}

}
