package worms.model.programs.parser;

import worms.model.Program;

public class IfElse extends Statement{

	public Expression<Boolean> condition;
	public Statement bodyIf;
	public Statement bodyElse;

	public IfElse(Expression<Boolean> newCondition, Statement newBodyIf, Statement newBodyElse)
	{
		setCondition(newCondition);
		newCondition.setHolder(this);
		newCondition.setProgram(program);
		
		setBodyIf(newBodyIf);
		newBodyIf.setParent(this);
		newBodyIf.setProgram(program);
		
		setBodyElse(newBodyElse);
		newBodyElse.setParent(this);
		newBodyElse.setProgram(program);
	}
	public void setCondition(Expression<Boolean> newCondition)
	{
		condition = newCondition;
	}
	public Expression<Boolean> getCondition()
	{
		return condition;
	}
	public void setBodyIf(Statement newBodyIf)
	{
		bodyIf = newBodyIf;
	}
	public Statement getBodyIf()
	{
		return bodyIf;
	}
	public void setBodyElse(Statement newBodyElse)
	{
		bodyElse = newBodyElse;
	}
	public Statement getBodyELse()
	{
		return bodyElse;
	}

	@Override
	public void execute() {

		if(program.hasExceedNumberInstructions()) program.interrupt();
		if(isDone ||  program.isInterrupt()) return;
		program.incrementInstructionNumber();
		
		program.stackOfStatements.push(this);
		if((Boolean)(condition.evaluate().getValue()))
		{
			bodyIf.execute();
		}
		else
		{
			bodyElse.execute();
		}
		if(program.isInterrupt()) return;
		isDone = true;
		program.stackOfStatements.pop();
	}
	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
		condition.setProgram(program);
		bodyIf.setProgram(program);
		bodyElse.setProgram(program);
	}
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		isDone = false;
		bodyIf.reset();
		bodyElse.reset();
	}

}
