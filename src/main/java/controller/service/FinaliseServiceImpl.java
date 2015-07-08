package controller.service;

import controller.Finalise;
import model.Desk;

/**
 * @author mathieu
 *
 */
public class FinaliseServiceImpl implements FinaliseService {

	@Override
	public Boolean IsFinished(Desk desk) {
		return Finalise.IsFinished(desk);
	}

}
