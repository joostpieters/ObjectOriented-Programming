package worms.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import worms.util.Util;

public class Tester {


	private static final double EPS = Util.DEFAULT_EPSILON;

	private IFacade facade;

	private Random random;

	private World world;

	private Worm worm;

	private Weapon weapon;

	private Projectile projectile;

	// X X X X
	// . . . .
	// . . . .
	// X X X X
	private boolean[][] passableMap = new boolean[][] {
			{ false, false, false, false }, { true, true, true, true },
			{ true, true, true, true }, { false, false, false, false } };


	private boolean[][] passableMapMedium = new boolean[][] {
			{ false, false, false, false }, { true, true, true, true },
			{ true, true, true, true }, { true, true, true, true }, { false, false, false, false } };


	// 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9			
	// X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X 0
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 1
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 2
	// . . . . . . . . . . Q . R . . . . . . . . . . . . . . . . . . . . . . . . . . . 3
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 4
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 5
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 6
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 7
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 8
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 9
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 10
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 11
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 12
	// . . R . . . . . . . . . W . . . . . . . . . R . . . . . . . . . . . . . . . . . 13
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 14
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 15
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 16
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 17
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 18
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 19
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 20
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 21
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 22
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 23
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 24
	// . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 25
	// X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X 26
	// 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9	
	private boolean[][] passableMapLarge;


	@Before
	public void setup() {
		facade = new Facade();
		random = new Random(7357);
		world = new World(4.0, 4.0, passableMap, random);
		worm = new Worm(world);
		weapon = new Bazooka(worm);

		passableMapLarge = new boolean[24][40];
		for (int i = 0; i< 24;i++)
			for(int j= 0; j< 40;j++)
			{
				if(i== 0 || i == 23) passableMapLarge[i][j] = false;
				else passableMapLarge[i][j]=true;
			}
	}
	@Test
	public void testImpassable() {
		// . . X
		// . w X
		World world = facade.createWorld(3.0, 2.0, new boolean[][] {
				{ true, true, false },
				{ true, true, false } }, random);
		Worm worm = facade.createWorm(world, 2, 0,
				0, 1, "Test", null);
		assertEquals(true , facade.isImpassable(world, facade.getX(worm), facade.getY(worm), facade.getRadius(worm)));
	}


	@Test
	public void worldConstructor()
	{
		World world = facade.createWorld(5, Double.MAX_VALUE, this.passableMap, this.random);
		assertEquals(5, world.getWidth(), EPS);
		assertEquals(Double.MAX_VALUE, world.getHeight(), EPS);
		assertTrue(this.passableMap.equals(world.getPassableMap()));
		assertTrue(this.random.equals(world.getRandom()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void worldConstructor_IllegalSize()
	{
		facade.createWorld(-5, Double.POSITIVE_INFINITY, this.passableMap, this.random);
	}

	@Test
	public void worldClassAttributes()
	{
		assertEquals(0, World.getMinimalSize(), EPS);
		assertEquals(Double.MAX_VALUE, World.getMaximalSize(), EPS);
	}
	@Test
	public void worldAttributes()
	{
		World world = facade.createWorld(8, 8, passableMap, random);
		assertEquals(.5, world.getScale(), EPS);
		assertEquals( 4, world.getMidX(), EPS);
		assertEquals( 4, world.getMidY(), EPS);

		world.addWorm(worm);
		world.setCurrentWorm(worm);
		assertEquals(worm , world.getCurrentWorm());

		world.setActiveProjectile(projectile);
		assertEquals(projectile, world.getActiveProjectile());

		world.addWorm(worm);
		assertEquals(worm, ((ArrayList<Worm>)world.getWorms()).get(0));

		world.removeWorm(worm);
		assertEquals(0, world.getWorms().size(), EPS);

	}
	@Test 
	public void worldRemoveWorm()
	{
		world.addWorm(worm);
		world.removeWorm(worm);
		assertEquals(0, world.getWorms().size(), EPS);
	}
	@Test(expected=NullPointerException.class)
	public void worldRemoveWorm_Null()
	{
		world.removeWorm(null);
	}
	@Test
	public void worldIsInRange()
	{
		assertEquals(true, world.isInRange(1, 1));
		assertEquals(false, world.isInRange(-1, 20));
		assertEquals(true, world.isInRange(new Vector(0,0)));
		assertEquals(false, world.isInRange(new Vector( -1, 5)));
	}
	@Test
	public void worldIsImpassable()
	{
		World worldX = new World(24, 40, passableMapLarge, random);
		assertEquals(true, worldX.isImpassable(2, 2, 2));
		assertEquals(false, worldX.isImpassable(5, 5, 2));
	}
	@Test
	public void worldAdjacent()
	{	
		World worldX = new World(24, 40, passableMapLarge, random);
		assertEquals(true, worldX.isAdjacent(11, 11, 10));
		assertEquals(false, worldX.isAdjacent(5, 5, 2));
	}
	@Test
	public void worldConversion ()
	{
		World worldX = new World(40, 24, passableMapLarge, random);
		assertEquals(2, worldX.convertToRealX(2), EPS);
		assertEquals(worldX.getHeight(), worldX.convertToRealY(0), EPS);
	}
	@Test
	public void worldStartNextTurn()
	{
		Worm worm1 = new Worm(world, 10, 10, 0, 1, "DBA", null);
		world.addWorm(worm1);
		world.addWorm(worm);
		world.setCurrentWorm(worm1);
		world.getCurrentWorm().turn(2);
		world.startNextTurn();
		world.startNextTurn();
		assertEquals(worm1.getMaxActionPoints(), worm1.getActionPoints());
		assertEquals(worm1, world.getCurrentWorm());
	}

	//Passability
	@Test
	public void passablePosition()
	{
		World world = facade.createWorld(2, 2, 
				new boolean[][]{{true, true},
				{true, true}}, this.random);
		assertEquals(true, !world.isImpassable(world.convertToRealY(0.0), world.convertToRealX(0.0)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(0.5), world.convertToRealX(0.5)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(0.5), world.convertToRealX(1.0)));

		world = facade.createWorld(2, 2, 
				new boolean[][]{{false, true},
				{true, true}}, this.random);
		assertEquals(true, world.isImpassable(world.convertToRealY(1.5), world.convertToRealX(0.5)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(1), world.convertToRealX(0.5)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(1.2), world.convertToRealX(1.0)));

		world = facade.createWorld(2, 2, 
				new boolean[][]{{false, true},
				{false, true}}, this.random);
		assertEquals(true, !world.isImpassable(world.convertToRealY(1.0), world.convertToRealX(1.0)));
		assertEquals(true, world.isImpassable(world.convertToRealY(0.99), world.convertToRealX(0.99)));
		assertEquals(true, world.isImpassable(world.convertToRealY(1.0), world.convertToRealX(0.5)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(1.5), world.convertToRealX(1.0)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(0.5), world.convertToRealX(1)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(1), world.convertToRealX(1.5)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(1.5), world.convertToRealX(1.5)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(0.5), world.convertToRealX(1.5)));

		world = facade.createWorld(2, 2, 
				new boolean[][]{{false, true},
				{true, false}}, this.random);
		assertEquals(true, world.isImpassable(world.convertToRealY(1.0), world.convertToRealX(1.0)));

		world = facade.createWorld(2, 2, 
				new boolean[][]{{false, true},
				{false, false}}, this.random);
		assertEquals(true, world.isImpassable(world.convertToRealY(1.0), world.convertToRealX(1.0)));
		assertEquals(true, world.isImpassable(world.convertToRealY(1.0), world.convertToRealX(0.5)));
		assertEquals(true, world.isImpassable(world.convertToRealY(0.5), world.convertToRealX(1.0)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(1.0), world.convertToRealX(1.5)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(1.3), world.convertToRealX(1.0)));
		assertEquals(true, !world.isImpassable(world.convertToRealY(1.3), world.convertToRealX(1.2)));


	}

	/////////WORM

	@Test
	public void wormConstructor()
	{
		Worm worm = new Worm(world, 1, 1, 1, 1, "DB", null);
		assertEquals(world, worm.getWorld());
		assertEquals(1, worm.getX(), EPS);
		assertEquals(1, worm.getY(), EPS);
		assertEquals(1, worm.getRadius(), EPS);
		assertEquals(1, worm.getOrientation(), EPS);
		assertEquals("DB", worm.getName());
	}
	@Test 
	public void wormClassAttributes()
	{
		assertEquals(1062, worm.getDensity(), EPS);
		assertEquals("Unknown", Worm.DEFAULT_NAME);
		assertEquals(.25, Worm.MIN_RADIUS, EPS);
		assertEquals(3445.15308494555, Worm.MAX_RADIUS, EPS);
	}
	@Test
	public void wormAttributes()
	{
		Worm worm = new Worm(world, 1, 1, 1, 1, "DB", null);
		assertEquals(State.UNDEFINED, worm.getState());
		assertEquals(4448.49519745, worm.getMass(), EPS);
		assertEquals(4448, worm.getMaxActionPoints(), EPS);
		assertEquals(4448, worm.getActionPoints(), EPS);
		assertEquals(4448, worm.getMaxHitPoints(), EPS);
		assertEquals(4448, worm.getHitPoints(), EPS);

		worm.selectNextWeapon();
		assertEquals(worm.getRifle(), worm.getSelectedWeapon());

		assertEquals(1, worm.getRealX(), EPS);
		assertEquals(2, worm.getRealY(), EPS);
		assertEquals(1, worm.getRealRadius(), EPS);


	}
	@Test
	public void wormCanMove()
	{
		World worldX = new World(4, 5, passableMapMedium, random);
		Worm worm = new Worm(worldX, 0, 2, 0, 1, "DB", null);
		assertEquals(true, worm.canMove());
		assertEquals(false, this.worm.canMove());
	}
	@Test
	public void wormMove()
	{
		boolean[][] passableMapExtraLarge = new boolean[27][40];
		for (int i = 0; i< 27;i++)
			for(int j= 0; j< 40;j++)
			{
				if(i== 0 || i == 26) passableMapExtraLarge[i][j] = false;
				else passableMapExtraLarge[i][j]=true;
			}
		World worldX = new World(40, 27, passableMapExtraLarge, random);
		Worm worm = new Worm(worldX, 12, 15, 0, 10, "DB", null);
		worm.move();
		assertEquals(22, worm.getX(), EPS);
		assertEquals(15, worm.getY(), EPS);
	}
	@Test
	public void wormTurn()
	{
		worm.turn(1);
		assertEquals(1, worm.getOrientation(), EPS);
	}
}
