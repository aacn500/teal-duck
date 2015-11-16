package com.tealduck.game.engine;


/**
 * Abstract base class for all systems. Requires implementing the {@link SystemAbstract#update} method. Has reference to
 * {@link EntityManager} so update method can access entities.
 */
public abstract class SystemAbstract {
	protected EntityManager entityManager;


	public SystemAbstract(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	// TODO: Is delta time in seconds or milliseconds
	/**
	 * Called each frame to update some part of the game.
	 *
	 * @param deltaTime
	 *                the time elapsed since the previous frame in (seconds/millisecond)
	 */
	public abstract void update(float deltaTime);
}
