package com.txc.kinect.server.service;

import com.txc.kinect.mvc.service.IService;
import com.txc.kinect.server.model.Action;
import org.omg.PortableInterceptor.ACTIVE;

import java.util.List;

public interface ActionService extends IService<Action, Integer> {

	public List<Action> getAllAction();

}
