package worms.model.programs.parser;

import worms.model.Program;

public class Assignement<T> extends Statement{

	public String variable;
	public Expression<T> expression;
	
	public Assignement(String newVariable, Expression<T> newExpression)
	{
		setVariable(newVariable);
		
		setExpression(newExpression);
		newExpression.setHolder(this);
	}
	
	public void setVariable(String newVariable)
	{
		variable = newVariable;
	}
	public String getVariable()
	{
		return variable;
	}
	public void setExpression(Expression<T> newExpression)
	{
		expression = newExpression;
	}
	public Expression<T> getExpression()
	{
		return expression;
	}
	@Override
	public void execute() {

		if(program.hasExceedNumberInstructions()) program.interrupt();
		if(isDone || program.isInterrupt()) return;
		program.incrementInstructionNumber();
		
		program.stackOfStatements.push(this);
		T newValue = ((Literal<T>) expression.evaluate()).getValue();
		if(program.isInterrupt()) return;
		((Literal<T>)(program.getGlobals().get(variable).getExpression())).setValue(newValue);
		if(program.isInterrupt()) return;
		isDone = true;
		program.stackOfStatements.pop();
		
	}
	@Override
	public void reset()
	{
		isDone = false;
	}

	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
		expression.setProgram(program);
	}
}
