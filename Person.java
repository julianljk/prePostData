import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Person {

	//do I need it as public
	String [] preList = new String [86];
	String [] postList = new String [86];
	String name;
	String id; 
	String preForm = "";
	String postForm = "";

	//for the first time
	public Person (String id, String name)
	{
		this.name = name;
		this.id = id;
	}
	public void setValues (String [] currArray, HashMap <String, HashMap <Integer, String>> myMap)
	{
		boolean prePost = true;
		//determines whether pre or post
		if (currArray[3].equals("Pre"))
		{
			
		}
		else
		{
			prePost = false;
		}
		//sets the form Alphabet
		if (prePost == true && preForm.equals(""))
		{
			preForm = currArray[4];
		}
		else if (prePost == false && postForm.equals(""))
		{
			postForm =  currArray[4];
		}

		if (currArray[7].equals("Why do you think that?"))
		{
			if (currArray[2].equals("Misha") && currArray[6].equals("162"))
			{
				System.out.println();
			}
			int parentID = Integer.parseInt(currArray[6]);

			if(prePost)
			{
				if (parentID == 162)
				{
					preList[6] = currArray[9];
				}
				else if (parentID == 164)
				{
					preList[8] = currArray[9];
				}
				else if (parentID == 166)
				{
					preList[10] = currArray[9];
				}
				else if (parentID == 168)
				{
					preList[12] = currArray[9];
				}
			}
			else
			{
				if (parentID == 162)
				{
					postList[6] = currArray[9];
				}
				else if (parentID == 164)
				{
					postList[8] = currArray[9];
				}
				else if (parentID == 166)
				{
					postList[10] = currArray[9];
				}
				else if (parentID == 168)
				{
					postList[12] = currArray[9];
				}
			}
		}
		else
		{
			//get corresponding index
			HashMap <Integer, String> currQuestion = myMap.get(currArray[7]);
			System.out.println(currArray[0] + currArray[1] + currArray[2] + currArray[3]);
			Set <Integer> currSet = currQuestion.keySet();
			Iterator <Integer> myItr = currSet.iterator();
			Integer questionIndex = myItr.next();

			if (prePost)
			{
				String value = valueConverter(currArray[9]);
				preList[questionIndex] = value;
			}
			else
			{
				String value = valueConverter(currArray[9]);
				postList[questionIndex] = value;
			}
		}
	}
	private String valueConverter (String input)
	{
		switch (input)
		{
		case "154":
			return "1";
		case "155":
			return "2";
		case "156":
			return "3";
		case "199":
			return "1";	
		case "200":
			return "2";
		case "201":	
			return "3";
		case "202":		
			return "4";
		case "208":
			return "1";		
		case "209":
			return "2";
		case "210":
			return "3";
		case "211":
			return "4";
		case "212":
			return "5";
		case "213":
			return "6";
		case "214":
			return "7";
		case "217":
			return "1";
		case "218":
			return "2-5";		
		case "219":
			return "6+";
		case "224":
			return "1";
		case "225":
			return "2";
		case "226":	
			return "3";
		case "227":		
			return "4";
		case "228":		
			return "1";
		case "229":
			return "2";		
		case "230":			
			return "3";
		case "231":			
			return "4";
		case "242":
			return "Watching videos";			
		case "243":			
			return "Social media";
		case "244":
			return "I spend about the same amount of time on both.";			
		case "246":			
			return "Playing video games";
		case "249":
			return "I don't do either.";			
		case "251":
			return "Videos";			
		case "252":
			return "Social media";			
		case "253":
			return "Video games";			
		case "254":			
			return "Programming";
		case "255":
			return "I spend about the same amount of time on both.";
		case "256":
			return "I don't do either";
		case "264":
			return "I spend about the same amount of time on both.";
		default: 
			return input;
		}
	}



}

