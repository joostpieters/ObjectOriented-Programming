package worms.model.programs.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.Entity;
import worms.model.Worm;
import worms.model.programs.ProgramFactory;
import worms.model.programs.parser.Compare.ComparesValue;
import worms.model.programs.parser.Getter;

//import worms.model.programs.parser.Getter.LifePoints;

import worms.model.programs.parser.Getter.*;


public class ProgramIndustry implements ProgramFactory<Expression<?>, Statement, Type<?>>{

	public IActionHandler handler;

	public ProgramIndustry(IActionHandler newHandler)
	{
		setActionHandler(newHandler);
	}
	
	public void setActionHandler(IActionHandler newHandler)
	{
		handler = newHandler;
	}
	public IActionHandler getActionHandler()
	{
		return handler;
	}


	//INTERFACE

	@Override
	public Expression<Double> createDoubleLiteral(int line, int column, double d) {
		// TODO Auto-generated method stub
		return new Literal<Double>(d);
	}

	@Override
	public Expression<Boolean> createBooleanLiteral(int line, int column, boolean b) {
		// TODO Auto-generated method stub
		return new Literal<Boolean>(b);
	}

	@Override
	public Expression<Boolean> createAnd(int line, int column, Expression<?> e1,
			Expression<?> e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression<Boolean> createOr(int line, int column, Expression<?> e1,
			Expression<?> e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression<Boolean> createNot(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression<?> createNull(int line, int column) {
		// TODO Auto-generated method stub
		return new Literal<Entity>(null);
	}

	@Override
	public Expression<?> createSelf(int line, int column) {
		// TODO Auto-generated method stub
		//WTF HOW ?!
		return new Self();
	}

	@Override
	public Expression<?> createGetX(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		//Expression e == someWorm
		return new Getter((Expression<Worm>)e, Val.X);
	}

	@Override
	public Expression<?> createGetY(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return new Getter((Expression<Worm>)e, Val.Y);
	}

	@Override
	public Expression<?> createGetRadius(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return new Getter((Expression<Worm>)e, Val.RADIUS);
	}

	@Override
	public Expression<?> createGetDir(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return new Getter((Expression<Worm>)e, Val.DIRECTION);
	}

	@Override
	public Expression<?> createGetAP(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return new Getter((Expression<Worm>)e, Val.ACTION_POINTS);
	}

	@Override
	public Expression<?> createGetMaxAP(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return new Getter((Expression<Worm>)e, Val.MAX_ACTION_POINTS);
	}

	@Override
	public Expression<?> createGetHP(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return new Getter((Expression<Worm>)e, Val.HP);
	}

	@Override
	public Expression<?> createGetMaxHP(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return new Getter((Expression<Worm>)e, Val.MAX_HP);
	}

	@Override
	public Expression<?> createSameTeam(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression<?> createSearchObj(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		//Checks all worms if any bgtan alpha == theta +- e
		return new Search((Expression<Double>)e);
	}

	@Override
	public Expression<?> createIsWorm(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		// type always false or true => should change at execution
		return new IsWorm((Expression<Worm>)e);
	}

	@Override
	public Expression<?> createIsFood(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression<?> createVariableAccess(int line, int column, String name) {
		// TODO Auto-generated method stub
		//		System.out.println("Access variable : " +  name + " line && row  (" + line +", " + column +  ")");
		//		return globals.get(name);
		return new VariableAccess<>(name);
	}

	@Override
	public Expression<?> createVariableAccess(int line, int column,
			String name, Type<?> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression<?> createLessThan(int line, int column, Expression<?> e1,
			Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Compare((Expression<Double>)e1, (Expression<Double>)e2, ComparesValue.SMALLER);
	}

	@Override
	public Expression<?> createGreaterThan(int line, int column,
			Expression<?> e1, Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Compare((Expression<Double>)e1, (Expression<Double>)e2, ComparesValue.GREATER);
	}

	@Override
	public Expression<?> createLessThanOrEqualTo(int line, int column,
			Expression<?> e1, Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Compare((Expression<Double>)e1, (Expression<Double>)e2, ComparesValue.SMALLER_OR_EQUAL);
	}

	@Override
	public Expression<?> createGreaterThanOrEqualTo(int line, int column,
			Expression<?> e1, Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Compare((Expression<Double>)e1, (Expression<Double>)e2, ComparesValue.GREATER_OR_EQUAL);
	}

	@Override
	public Expression<?> createEquality(int line, int column, Expression<?> e1,
			Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Equality(e1, e2, true);
	}

	@Override
	public Expression<?> createInequality(int line, int column,
			Expression<?> e1, Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Equality(e1, e2, false);
	}

	@Override
	public Expression<?> createAdd(int line, int column, Expression<?> e1,
			Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Addition((Expression<Double>)e1,(Expression<Double>) e2);
	}

	@Override
	public Expression<?> createSubtraction(int line, int column,
			Expression<?> e1, Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Substraction((Expression<Double>)e1,(Expression<Double>) e2);
	}

	@Override
	public Expression<?> createMul(int line, int column, Expression<?> e1,
			Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Multiplication((Expression<Double>)e1,(Expression<Double>) e2);
	}

	@Override
	public Expression<?> createDivision(int line, int column, Expression<?> e1,
			Expression<?> e2) {
		// TODO Auto-generated method stub
		return new Division((Expression<Double>)e1,(Expression<Double>) e2);
	}

	@Override
	public Expression<?> createSqrt(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return new Sqrt((Expression<Double>)e);
	}

	@Override
	public Expression<?> createSin(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression<?> createCos(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createTurn(int line, int column, Expression<?> angle) {
		// TODO Auto-generated method stub
		//return new ActionTurn(getHandler(), angle);
		return new Turn(handler, (Expression<Double>)angle);
	}

	@Override
	public Statement createMove(int line, int column) {
		// TODO Auto-generated method stub
		return new Move(handler);
	}

	@Override
	public Statement createJump(int line, int column) {
		// TODO Auto-generated method stub
		return new Jump(handler);
	}

	@Override
	public Statement createToggleWeap(int line, int column) {
		// TODO Auto-generated method stub
		return new ToggleWeapon(handler);
	}

	@Override
	public Statement createFire(int line, int column, Expression<?> yield) {
		// TODO Auto-generated method stub
		return new Fire(handler, (Expression<Double>)yield);
	}

	@Override
	public Statement createSkip(int line, int column) {
		// TODO Auto-generated method stub
		return new Skip(handler);
	}

	@Override
	public Statement createAssignment(int line, int column,
			String variableName, Expression<?> rhs) {
		// TODO Auto-generated method stub
		return new Assignement<>(variableName, rhs);
	}

	@Override
	public Statement createIf(int line, int column, Expression<?> condition,
			Statement then, Statement otherwise) {
		// TODO Auto-generated method stub
		return new IfElse((Expression<Boolean>) condition, then, otherwise);
	}

	@Override
	public Statement createWhile(int line, int column, Expression<?> condition,
			Statement body) {
		// TODO Auto-generated method stub
		return new WhileLoop((Expression<Boolean>)condition, body);
	}

	@Override
	public Statement createForeach(int line, int column,
			worms.model.programs.ProgramFactory.ForeachType type,
			String variableName, Statement body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createSequence(int line, int column,
			List<Statement> statements) {
		// TODO Auto-generated method stub
		return new Sequence(statements);
	}

	@Override
	public Statement createPrint(int line, int column, Expression<?> e) {
		// TODO Auto-generated method stub
		return new Print(handler, e);
	}

	@Override
	public Type<Double> createDoubleType() {
		// TODO Auto-generated method stub

		//Double with default value
		return new Type<Double>(new Literal<Double>(.0));
	}

	@Override
	public Type<Boolean> createBooleanType() {
		// TODO Auto-generated method stub
		return new Type<Boolean>(new Literal<Boolean>(false));
	}

	@Override
	public Type<? extends Entity> createEntityType() {
		// TODO Auto-generated method stub
		return new Type<Worm>(new Literal<Worm>(null));
	}
}
