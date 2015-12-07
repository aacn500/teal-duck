package com.tealduck.game.system;


import java.util.Set;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.math.Vector2;
import com.tealduck.game.component.MovementComponent;
import com.tealduck.game.component.UserInputComponent;
import com.tealduck.game.engine.EntityEngine;
import com.tealduck.game.engine.EntityManager;
import com.tealduck.game.engine.GameSystem;
import com.tealduck.game.input.Action;
import com.tealduck.game.input.ControlMap;


public class InputLogicSystem extends GameSystem {
	public InputLogicSystem(EntityEngine entityEngine) {
		super(entityEngine);
	}


	@Override
	public void update(float deltaTime) {
		EntityManager entityManager = getEntityManager();

		@SuppressWarnings("unchecked")
		Set<Integer> entities = entityManager.getEntitiesWithComponents(MovementComponent.class,
				UserInputComponent.class);

		for (int entity : entities) {
			UserInputComponent userInputComponent = entityManager.getComponent(entity,
					UserInputComponent.class);
			MovementComponent movementComponent = entityManager.getComponent(entity,
					MovementComponent.class);
			ControlMap controls = userInputComponent.controls;
			Controller controller = userInputComponent.controller;

			float rightState = controls.getStateForAction(Action.RIGHT, controller);
			float leftState = controls.getStateForAction(Action.LEFT, controller);
			float upState = controls.getStateForAction(Action.UP, controller);
			float downState = controls.getStateForAction(Action.DOWN, controller);

			float dx = rightState - leftState;
			float dy = upState - downState;

			int velocityLimit = 1;

			float shiftScale = 1;
			if (controls.getStateForAction(Action.SPRINT, controller) == 1) {
				shiftScale = movementComponent.sprintScale;
			}

			Vector2 accelerationDelta = new Vector2(dx, dy); // movementComponent.acceleration;
			accelerationDelta.limit(velocityLimit);
			accelerationDelta.scl(movementComponent.maxSpeed * shiftScale);
			movementComponent.acceleration.add(accelerationDelta);
			// movementComponent.velocity.add(new Vector2(dx, dy).scl(movementComponent.maxSpeed));
		}
	}
}
