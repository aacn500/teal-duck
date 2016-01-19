package com.tealduck.game.tests.collision;

import org.junit.Assert;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.tealduck.game.collision.Intersection;


public class IntersectionTest {
	private static final double DELTA = 1e-4;
	
	
	@Test
	public void testGetResolveVector() {
		Intersection i = new Intersection(new Vector2(1, 0), 5);
		
		Assert.assertEquals(5, i.getResolveVector().x, DELTA);
		Assert.assertEquals(0, i.getResolveVector().y, DELTA);
	}
	
	@Test
	public void testGetFlippedNormalVector() {
		Intersection i = new Intersection(new Vector2(1, 0), 5);
		
		Assert.assertEquals(-1, i.getFlippedNormalVector().x, DELTA);
		Assert.assertEquals(0, i.getFlippedNormalVector().y, DELTA);
	}
	
	@Test
	public void testGetCopy() {
		Intersection i = new Intersection(new Vector2(1, 0), 5);
		
		Assert.assertEquals(1, i.getCopy().normal.x, DELTA);
		Assert.assertEquals(0, i.getCopy().normal.y, DELTA);
		Assert.assertEquals(5, i.getCopy().distance, DELTA);
	}
	
	@Test
	public void testGetFlippedCopy() {
		Intersection i = new Intersection(new Vector2(1, 0), 5);
		
		Assert.assertEquals(-1, i.getFlippedCopy().normal.x, DELTA);
		Assert.assertEquals(0, i.getFlippedCopy().normal.y, DELTA);
		Assert.assertEquals(5, i.getFlippedCopy().distance, DELTA);
		
	}
}
