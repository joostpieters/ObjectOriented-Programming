package worms.model.programs.parser;

import worms.model.Program;
import worms.model.Worm;

//This class self need to replace worm at bounding with a worm
public class Self extends Literal<Worm>{

	public Self() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Literal<Worm> evaluate()
	{
		setValue(program.getWorm());
		return this;
	}


}
