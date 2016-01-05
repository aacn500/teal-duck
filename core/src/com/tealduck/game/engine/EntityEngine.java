package com.tealduck.game.engine;


import java.util.ArrayList;


/**
 * Used to group entity manager, entity tag manager and event manager together as these classes are often passed around
 * together.
 */
public class EntityEngine {
	private EntityManager entityManager;
	private EntityTagManager entityTagManager;
	private EventManager eventManager;

	private ArrayList<Integer> entitiesToRemove;


	public EntityEngine() {
		entityManager = new EntityManager();
		entityTagManager = new EntityTagManager();
		eventManager = new EventManager(this);

		entitiesToRemove = new ArrayList<Integer>();
	}


	public EntityEngine(EntityManager entityManager, EntityTagManager entityTagManager, EventManager eventManager) {
		this.entityManager = entityManager;
		this.entityTagManager = entityTagManager;
		this.eventManager = eventManager;
	}


	public void flagEntityToRemove(int entity) {
		entitiesToRemove.add(entity);
	}


	public void removeAllFlaggedEntities() {
		for (int entity : entitiesToRemove) {
			removeEntity(entity);
		}
		entitiesToRemove.clear();
	}


	private void removeEntity(int entity) {
		entityManager.removeEntity(entity);
		entityTagManager.removeTagsAssociatedWithEntity(entity);
		eventManager.removeEntity(entity);
	}


	public void clear() {
		entityManager.clear();
		entityTagManager.clear();
		eventManager.clear();
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	public EntityTagManager getEntityTagManager() {
		return entityTagManager;
	}


	public EventManager getEventManager() {
		return eventManager;
	}
}
