package pro;

interface LevelFactory {
    Level createLevel();
}

class Level1Factory implements LevelFactory {
    @Override
    public Level createLevel() {
        return  Level1();
    }

	private Level Level1() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Level2Factory implements LevelFactory {
    @Override
    public Level createLevel() {
        return  Level2();
    }

	private Level Level2() {
		// TODO Auto-generated method stub
		return null;
	}
}
class Level3Factory implements LevelFactory{
	public Level createLevel() {
		return Level3();
	}
	private Level Level3() {
		return null;
	}
}
