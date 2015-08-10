import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

public class prePostData
{
	public static void main (String [] args) throws FileNotFoundException
	{
		File myFile = new File (args[0]);
		ArrayList <Database> myDatabase = new ArrayList <Database>();
		ArrayList <String> currQuestions = new ArrayList <String>();
		HashMap <String, HashMap <Integer, String>> myMapping = new HashMap <String, HashMap<Integer,String>>();
		//Change file path to yours in your machine
		PrintStream out = new PrintStream (new FileOutputStream("/Users/julianljk/desktop/prePostData/outputFile.csv"));
		final PrintStream stdOut = System.out;
		

		Scanner myScanner = null;	
		try 
		{
			myScanner = new Scanner (myFile);
		}
		catch (FileNotFoundException e)
		{
			System.err.print("FAILED.FNF EXCEPTION");
		}
		int counter = 0;

		currQuestions = getQuestions(currQuestions, args[0], stdOut);
		Collections.sort(currQuestions);
		myMapping = getHashMap(currQuestions);
		

		while (myScanner.hasNextLine())
		{
			String currString = myScanner.nextLine();	
			String [] currArray = currString.split(",");
			
			if (currArray.length > 11)
			{
				currArray = arrayFixer(currArray);
			}
//			if(currArray[7].equals("Which of these activities do you do online?"))
//			{
//				System.out.println();
//			}
			//test all of these
			if (currArray[8].equals("Avatar") || currArray[8].equals("QuestionAvatar") 
					|| currArray[7].equals("Which of these activities do you do online?") 
					|| currArray[7].equals(" ") || currArray[7].contains("choose the specific numeric value corresponding to how you feel about each statement")
					|| currArray[7].equals("") || currArray[2].equals("admin") || currArray[2].equals("Admin"))
			{
				//skip avatar questions
			}
			else
			{
				arrayProcessor(currArray, myDatabase, myMapping);
			}
			
//			for (String i: currArray)
//			{
//				System.out.print(i + " ");
//			}
//			System.out.println(counter);
			counter++;

			
		}
		System.setOut(out);
		print(myDatabase, myMapping);
	}
	public static ArrayList <String> getQuestions (ArrayList <String> currQuestions, String filePath, PrintStream stdOut)
	{
		ArrayList <String> myQuestions = new ArrayList <String>();
		System.setOut(stdOut);
		File myFile = new File (filePath);
		Scanner myScanner = null;	
		try 
		{
			myScanner = new Scanner (myFile,"UTF-8");
		}
		catch (FileNotFoundException e)
		{
			System.err.println("crashed in getQuestions");
		}
		int counter = 0;
		
		while (myScanner.hasNextLine())
		{
			String currString = myScanner.nextLine();
			String [] currArray = currString.split(",");
			
			if (currArray.length > 11)
			{
				currArray = arrayFixer(currArray);
			}
			if (currArray.length != 11)
			{
				throw new IndexOutOfBoundsException();
			}
			if (currArray[7].length() > 5 && !(myQuestions.contains(currArray[7])))
			{
				myQuestions.add(currArray[7]);
			}
			
			counter++;
			

		}
		return myQuestions;

	}
	public static HashMap <String, HashMap <Integer,String>> getHashMap(ArrayList <String> myQuestions)
	{
		HashMap <String, HashMap <Integer, String>> myMap = new HashMap <String, HashMap <Integer, String>>();
		HashMap <Integer, String> conceptMap = new HashMap <Integer, String>();
		HashMap <Integer, String> linesMap = new HashMap <Integer, String>();
		HashMap <Integer, String> internshipMap = new HashMap <Integer, String>();
		HashMap <Integer, String> scientistMap = new HashMap <Integer, String>();
		HashMap <Integer, String> environmentalistMap = new HashMap <Integer, String>();
		
		HashMap <Integer, String> coniferousMap = new HashMap<Integer, String>();
		HashMap <Integer, String> whyDyouThinkMap1 = new HashMap <Integer, String>();
		
		HashMap <Integer, String> lafayetteMap = new HashMap<Integer, String>();
		HashMap <Integer, String> whyDyouThinkMap2 = new HashMap <Integer, String>();
		
		HashMap <Integer, String> amusementParkMap = new HashMap<Integer, String>();
		HashMap <Integer, String> whyDyouThinkMap3 = new HashMap <Integer, String>();
		
		HashMap <Integer, String> baldwinMap = new HashMap<Integer, String>();
		HashMap <Integer, String> whyDyouThinkMap4 = new HashMap <Integer, String>();
		
		String conceptMapQuestion = "A concept map is a way to show your ideas "
				+ "about a particular topic and about how those ideas might relate"
				+ " to one another.Take a look at these terms and draw lines to "
				+ "show how these terms connect to each other (if you think they do)";
		String lines = "Please explain why you drew the lines you did.";
		String internship = "If you could change one thing to make the internship better what would it be?";
		String scientists = "Scientists are concerned that Dunns Marsh a large wetland area near Jefferson"
				+ " Wisconsin is being damaged by acid rain caused by carbon monoxide emissions from a local "
				+ "factory. They have asked your company to make a model of the Dunns Marsh ecosystem to assess "
				+ "the impact of the factory. What information would you include in your model and why would "
				+ "that information be important? How would you get that information?";
		String environmentalist = "Environmentalists are concerned that the Sequoia "
				+ "Lake near Thomasville, Missouri is being damaged by toxic algae "
				+ "caused by nitrates used as fertilizer in nearby farms. They have "
				+ "asked your company to make a model of lakes ecosystem to assess "
				+ "the impact of the farms. What information would you include in your "
				+ "model, and why would that information be important? How would you get that information?";
		String amusementPark = "An amusement park in Florida wants to expand onto a wetland. This new development"
				+ " will impact the habitat for a variety of plants and animals. The amusement park has offered "
				+ "to create a new wetland to make up for the one it is destroying. Some people argue that the "
				+ "new wetland will not support the same species or be of the same quality. Others argue that "
				+ "the amusement park should be able to expand onto a wetland as long as they create a new "
				+ "wetland even if the new wetland supports different species of plants and animals. What do you think?";
		
		String coniferous = "In 1999 nearly 500,000 acres of coniferous forest "
				+ "was blown down by a windstorm in the Boundary Waters Canoe Area"
				+ " in the United States and Quetico Provincial Park in Canada."
				+ " The area is now a fire hazard to nearby property as well as "
				+ "being a visual mess. Some people argue that salvage loggers "
				+ "should clean out the area and replant pine trees. Others argue "
				+ "that it was a natural forest and should be left to natural forces. What do you think?";
		
		String lafayette = "Your town is located on a river between Lafayette and Carencro. "
				+ "Your town dumps its sewage and industrial wastes into the river, "
				+ "and the waste travels downstream to Carencro. Lafayette, which "
				+ "is upstream from your town, also dumps its waste into the river, "
				+ "and the effects are seen in your town and towns further downstream "
				+ "like Carencro. What are the rights and responsibilities of upstream "
				+ "communities to downstream communities?";
		
		String baldwin = "Your town is located between Spring Valley and Baldwin. "
				+ "Your town's coal fired power plant releases its emissions into "
				+ "the air, and because of the direction of the prevailing winds, "
				+ "the air emissions affect Baldwin. Spring Valley, which is up "
				+ "wind from your town, also has a coal fired power plant that "
				+ "releases its emissions into the air, and the effects are seen"
				+ " in your town and towns further downwind like Baldwin. What "
				+ "are the rights and responsibilities of up wind communities to downwind communities?";
	
		String whyDyou = "Why do you think that?";

		
		String currQuestion = "";
		
		conceptMap.put(0, conceptMapQuestion);
		linesMap.put(1, lines);
		internshipMap.put(2,internship);
		scientistMap.put(3, scientists);
		environmentalistMap.put(4, environmentalist);
		
		coniferousMap.put(5, coniferous);
		whyDyouThinkMap1.put(6,whyDyou);
		
		lafayetteMap.put(7, lafayette);
		whyDyouThinkMap2.put(8,whyDyou);
		
		amusementParkMap.put(9, amusementPark);
		whyDyouThinkMap3.put(10,whyDyou);
		
		baldwinMap.put(11, baldwin);
		whyDyouThinkMap4.put(12,whyDyou);
		
		int indexCounter = 13;
		
		for (int i = 0; i < myQuestions.size(); i++)
		{
			if(i == 131)
			{
				System.out.println();
			}
			currQuestion = myQuestions.get(i);
			if (currQuestion.contains("Please explain why you drew the lines you did."))
			{
				myMap.put(currQuestion, linesMap);
			}
			else if (currQuestion.contains("A concept map is a way to show"))
			{
				myMap.put(currQuestion, conceptMap);
			}
			else if(currQuestion.contains("An amusement park in Florida wants to expand onto a wetland."))
			{
				myMap.put(currQuestion, amusementParkMap);
			}
			else if(currQuestion.contains("choose the specific numeric value corresponding to how you feel about each statement"))
			{
		
			}
			else if(currQuestion.contains("farms.What information would you include in your model and why would that information be important? How would you get that information?") ||
					currQuestion.contains("farms. What information would you include in your model and why would that information be important? How would you get that information?"))
			{
				myMap.put(currQuestion, environmentalistMap);
			}
			else if(currQuestion.contains("If you could change one thing to make the internship better"))
			{
				myMap.put(currQuestion,internshipMap);
			}
			else if(currQuestion.contains("In 1999 nearly 500000 acres of coniferous forest was blown down"))
			{
				myMap.put(currQuestion, coniferousMap);
			}
			else if(currQuestion.contains("Our office communication system needs an avatar (an image) for each person at RDA."))
			{
				
			}
			else if(currQuestion.contains("in your model and why would that information be important? How would you get that information?"))
			{
				myMap.put(currQuestion, scientistMap);
			}
			else if(currQuestion.contains("We keep an alumni page for all of RDAs professional interns."))
			{
				
			}
			else if(currQuestion.contains("Why do you think that?"))
			{
				myMap.put(currQuestion + "1", whyDyouThinkMap1);
				myMap.put(currQuestion + "2", whyDyouThinkMap2);
				myMap.put(currQuestion + "3", whyDyouThinkMap3);
				myMap.put(currQuestion + "4", whyDyouThinkMap4);	
			}
			else if(currQuestion.contains("Your town is located on a river between Lafayette and Carencro."))
			{
				myMap.put(currQuestion, lafayetteMap);
			}
			else if(currQuestion.contains("Your town is located between Spring Valley and Baldwin."))
			{
				myMap.put(currQuestion, baldwinMap);
			}
			else
			{
				HashMap<Integer,String> mapping = new HashMap<Integer, String>();
				mapping.put(indexCounter,currQuestion);
				myMap.put(currQuestion, mapping);
				indexCounter++;
			}
		}
		return myMap; 
		
	}
	public static String [] arrayFixer (String[] currArray)
	{
		String [] responseTypes = {"Short Answer",
				"Short Answer",
				"Likert",
				"Multiple Choice",
				"Drawing",
				"Avatar",
				"Concept",
				"QuestionAvatar",
				"QuestionMultiChoice",
				"QuestionText",
				"QuestionConceptMap",
		"QuestionLikert"};

		String [] optionLabels = {"NULL",
				"Never",
				"Weekly",
				"Once in awhile",
				"Every day",
				"Average",
				"Good",
				" ",
				"Strongly disagree",
				"Strongly Disagree",
				"Strongly agree",
				"Strongly Agree",
				"Agree Somewhat",
				"Agree Strongly ",
				"Disagree Somewhat",
				"Disagree Strongly ",
				"Agree Strongly",
				" choose the specific numeric value corresponding to how you feel about each statement.\"",
				"5-Feb", //special case
				"7",
				"Below Average",
				"4",
				"1",
				"6",
				"Disagree Strongly",
				"I spend about the same amount of time on both.",
				"Videos",
				"Video games",
				"Social media",
				"I don't do either",
				"Agree ",
				"Disagree ",
				"Watching videos (e.g., Youtube)", //has comma
				"Playing video games (e.g., PS3 and XBox 360 games, Angry Birds, Farmville)", // has comma
				"Chatting (e.g., Gchat, Facebook Chat, AIM)", // has comma
				"Social media (e.g., Facebook, twitter, Myspace)", //has comma
				"Listening to music (e.g., Pandora, iheartradio, Spotify)", // has comma
				"Blogging (e.g., Tumblr, Wordpress, Blogger)",
				"Disagree",
				"Agree",
				"Programming",
				"Playing video games",
				"I don't do either.",
				"Watching videos",
				"2",
				" what would it be?\"",
				"6+",
				"5",
		"3"};
		int responseTypeIndex = 0;

		for (int i = 8; i < currArray.length; i++)
		{
			if (Arrays.asList(responseTypes).contains(currArray[i]))
			{
				//store i as the index that is the stopper.
				responseTypeIndex = i;
				break;
			}
		}
		String [] arrayCopy = new String [11];

		//loop for question
		for (int i = 0; i < currArray.length; i++)
		{
			if (i < 8)
			{
				arrayCopy[i] = currArray[i];
			}
			else if (i < responseTypeIndex)
			{
				arrayCopy[7] = arrayCopy[7] + currArray[i];
			}
			else if (i == responseTypeIndex)
			{
				arrayCopy[8] = currArray[responseTypeIndex];
			}
			else
			{
				break;
			}
		}
		arrayCopy[9] = "";

		int optionLabelIndex = 0;
		//find where the last item begins.
		for (int i = 10; i < currArray.length; i++)
		{
			if (Arrays.asList(optionLabels).contains(currArray[i]))
			{
				optionLabelIndex = i;
			}
		}

		//loop for appending answer
		for (int i = responseTypeIndex + 1 ; i < optionLabelIndex; i++)
		{
			arrayCopy[9] = arrayCopy[9] + currArray[i];
		}

		arrayCopy[10] = currArray[currArray.length-1];
		arrayCopy = removeQuotes(arrayCopy);

		return arrayCopy;
	}

	public static String [] removeQuotes (String [] currArray)
	{
		
		for (int i = 0; i < currArray.length; i++)
		{
			if (currArray[i].equals(""))
			{

			}
			else
			{
				if (currArray[i].charAt(0) == '"')
				{
					currArray[i] = currArray[i].substring(1,currArray[i].length());
				}
				if (currArray[i].charAt(currArray[i].length() - 1) == '"')
				{
					currArray[i] = currArray[i].substring(0, currArray[i].length()-1);
				}
			}
		}
		
		return currArray;
	}
	public static void arrayProcessor (String [] currArray, ArrayList <Database> myDatabase, HashMap <String, HashMap <Integer,String>> myMap)
	{
		Database currDatabase = null;
		if (myDatabase.isEmpty() || !hasDatabase(currArray[0], myDatabase))
		{
			currDatabase = new Database (currArray[0]);
			myDatabase.add(currDatabase);
		}
		else 
		{
			currDatabase = getDatabase(currArray[0], myDatabase);

			if (currDatabase == null)
			{
				throw new IndexOutOfBoundsException();
			}
		}
		//check the databases for a player. 

		//
		Person currPerson = null;
		// 
		if (currDatabase.myPlayerList.isEmpty() || !currDatabase.hasPlayer(currArray[2]))
		{
			//add player name, and ID to constructor.
			currPerson = new Person(currArray[1],currArray[2]);
			currDatabase.addPlayer(currPerson);
		}
		else
		{
			currPerson = currDatabase.getPlayer(currArray[2]);
			if (currPerson == null)
			{
				System.out.println("screwed up at person else");
			}
		}
		//add the info here.
		currPerson.setValues(currArray, myMap);

	}
	public static boolean hasDatabase (String currDb, ArrayList <Database> myDatabase)
	{
		for (int i = 0; i < myDatabase.size();i++)
		{
			if (myDatabase.get(i).name.equals(currDb))
			{
				return true;
			}
		}
		return false;
	}
	public static Database getDatabase (String currDb, ArrayList <Database> myDatabase)
	{
		for (int i = 0; i < myDatabase.size();i++)
		{
			if (myDatabase.get(i).name.equals(currDb))
			{
				return myDatabase.get(i);
			}
		}
		return null;
	}
	public static void print (ArrayList <Database> myDatabase, HashMap <String, HashMap <Integer, String>> myMap)
	{
		Database currDatabase;
		Person currPerson = null;
		String currLine = "";
				
		Set <Integer> mySet = new HashSet <Integer> ();
		ArrayList <Integer> keySet = new ArrayList <Integer>();
		
		HashMap <Integer, String> integerQuestionMapping = new HashMap <Integer, String>();
		
		Set <String> questionSet = myMap.keySet(); //this is the set of all the questions.
		Iterator <String> itr = questionSet.iterator();
		
		while (itr.hasNext())
		{
			HashMap <Integer, String> currMap = myMap.get(itr.next());
			Set <Integer> currSet = currMap.keySet();
			Iterator <Integer> iterator = currSet.iterator();
			Integer currInt = iterator.next();
			integerQuestionMapping.put(currInt, currMap.get(currInt));
			mySet.addAll(currMap.keySet());
		}
		keySet.clear();
		keySet.addAll(mySet);
		Collections.sort(keySet);
		
		String title = "Db,userID,display_name,Pre/Post,Form,";
		
		for(int i = 0; i < 86; i++)
		{
			if(integerQuestionMapping.get(i).contains(","))
			{
				String cleanedString = integerQuestionMapping.get(i).replace(',', ';');
				title += cleanedString + ",";
			}
			else
			{
				title += integerQuestionMapping.get(i) + ",";
			}
		}
		title = title.substring(0,title.length()-1);
		System.out.println(title);
		
		
		for (int i = 0; i < myDatabase.size(); i++)
		{
			currDatabase = myDatabase.get(i);
				
			for (int j = 0; j < currDatabase.myPlayerList.size(); j++)
			{
				currPerson = currDatabase.myPlayerList.get(j);
				if (currPerson.preForm.equals(""))
				{
					
				}
				else
				{
					currLine += currDatabase.name + "," + currPerson.id + "," + currPerson.name + "," + "Pre," + currPerson.preForm + ",";
					
					for (int k = 0; k < currPerson.preList.length; k++)
					{
						if (currPerson.preList[k] == null)
						{
							currLine += "NA,"; 
						}
						else
						{
							currLine += currPerson.preList[k] + ",";	
						}
					}
					currLine += "\n";
				}
				
				if (currPerson.postForm.equals(""))
				{
					
				}
				else
				{
					currLine += currDatabase.name + "," + currPerson.id + "," + currPerson.name + "," + "Post," + currPerson.postForm + ",";
					
					for (int l = 0; l < currPerson.postList.length; l++)
					{
						if (currPerson.postList[l] == null)
						{
							currLine += "NA,";
						}
						else
						{
							currLine += currPerson.postList[l] + ",";

						}
					}
				}
				
				currLine = currLine.substring(0, currLine.length()-1);
				System.out.println(currLine);
				currLine = "";
			}

		}

	}
}
