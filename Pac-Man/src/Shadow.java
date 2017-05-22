public class Shadow extends Ghost {

	public Shadow()
	{
		currentMode = GhostMode.CHASE;
	}
	
	public void ChasePM(Object PacMan)
	{
		int[] dest = getMap().getAdjacentLocation(getMap().getPacMan());
		getMap().move((getMap().getShadow()), dest[0], dest[1]);
	}

}