
public class Generator {
	String[] aCons = 		{"b","c","d","f","g","h","l","m","n","p","r","s","t"};
	String[] bCons = 		{"k","j","q","v","w","x","y","z"};
	String[] conSDipth = 	{"br","bl","ch","cr","cl","dr","fl","fr","gr","gl",
			 				"mn","pl","pr","ph","st","str","sch","sp","scr","sw","sk","sn",
			 				"th","thr",};
	String[] conMDipth = 	{"th","st","ph","ch","tch","sm","sn","sk","sp","ck",
							"nd","ll","mm","nn","tt","ss","pp","rc","sc","mb","tr","ft",
							"bb","bd","ct","nc","cc","dd"};  //28
	String[] vowels = 		{"a","a","a","e","e","e","e","e","e","i","i","o","u"}; //3a 6e 2i o u
	String[] vowDipth = 	{"ou","io","oa","ui","ae","oo","ea","ia","ie","au","y","ee","aa",
							 "oi"};
	
	private String startingLetter = "";
	private boolean isStartLtr = false;
	private int exactLength;
	private boolean isExactLength = false;
	
	public String randWord()
	{
		int wordLength = UT.randInt(3,9);
		String word;
		boolean lastIsVowel = false;
		if (startingLetter.equals(""))
			isStartLtr = false;
		
		if (isStartLtr) word = startingLetter;
		else if (UT.chance(25)) word = randVow();
		else word = randStartCon();
		
		if (isExactLength)
			wordLength = exactLength;
		else if ((word.equals("str") || word.equals("thr") || word.equals("scr"))&&wordLength<5)
			wordLength +=5;

		while (word.length()<=wordLength)
		{
			for (int j = 0; j<5; j++)
				if (word.substring(word.length()-1).equals(vowels[j]))
					lastIsVowel = true;
			if (lastIsVowel)
			{
				word = word + randCon();
				lastIsVowel = false;
			}
			else
			{
				if (UT.chance(93)) word = word + randVow();
				else word = word + randCon();
			}
		}
		for (int i = 0; i<3; i++)
		{
			if (word.length()>wordLength)
				word = word.substring(0, word.length()-1);
		}
		return UT.capitalize(word);
	}

	public String randCon()
	{
		if (UT.chance(95))
		{
			if (UT.chance(80)) return UT.randSTR(aCons);
			else return UT.randSTR(conMDipth);
		}
		else return UT.randSTR(bCons);
	}

	public String randVow()
	{
		if (UT.chance(75)) return UT.randSTR(vowels);
		else return UT.randSTR(vowDipth);
	}

	public String randStartCon()
	{
		if (UT.chance(95))
		{
			if (UT.chance(70)) return UT.randSTR(aCons);
			else return UT.randSTR(conSDipth);
		}
		else return UT.randSTR(bCons);
	}
	
	public void setStartingLetter(String strtltr)
	{
		startingLetter = strtltr;
	}
	
	public String getStartingLetter()
	{
		return startingLetter;
	}
	
	public void setIsStartLtr(boolean val)
	{
		isStartLtr = val;
	}
	
	public boolean getIsStartLtr()
	{
		return isStartLtr;
	}
	
	public void setIsExactLength(boolean val)
	{
		isExactLength = val; 
	}
	
	public boolean getIsExactLength()
	{
		return isExactLength;
	}
	
	public void setExactLength(int lngth)
	{
		exactLength = lngth;
	}
	
	public int getExactLength()
	{
		return exactLength;
	}

}
