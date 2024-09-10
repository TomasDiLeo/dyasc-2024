package ar.edu.untref.dyasc;

import java.util.List;
import java.io.IOException;
import java.util.Collections;
import org.apache.commons.cli.*;

public class Executable {
	public static void main(String[] args) {
		Options options = new Options();

		Option optionO = Option.builder("o")
		                        .hasArg()
		                        .desc("Describes how the values are presented. An h for horizontal or a v for vertical followed by a d for direct or a i for inverse. Example -o=hd")
		                        .required(false)
		                        .valueSeparator()
		                        .build();
		options.addOption(optionO);

		Option optionF = Option.builder("f")
		                        .hasArg()
		                        .desc("Writes a txt file with the program output, must have its extension specified i.e. example.txt")
		                        .required(false)
		                        .valueSeparator()
		                        .build();
		options.addOption(optionF);
		
		Option optionM = Option.builder("m")
		                        .hasArg()
		                        .desc("Let's you switch between two modes. -m=l for a list of fibonacci numbers and -m=s for the sum of all numbers up to the specified number")
		                        .required(false)
		                        .valueSeparator()
		                        .build();
		options.addOption(optionM);

		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		FibonacciSequence fibo = new FibonacciSequence();
		
		try {
			CommandLine cmd = parser.parse(options, args);
			char horizontalVertical = 'h';
            char directInverse = 'd';
			char listSum = 'l';

			if(cmd.hasOption("o")){
				String orientation = cmd.getOptionValue("o");
				if(orientation.length() == 2) {
					horizontalVertical = Character.toLowerCase(orientation.charAt(0));
                    directInverse = Character.toLowerCase(orientation.charAt(1));
                    if(!((horizontalVertical == 'h' | horizontalVertical == 'v')|(directInverse == 'd' | directInverse == 'i')))
    					throw new ParseException("Argument "+orientation+" is not a valid argument");
				} else {
					throw new ParseException("Argument "+orientation+" is not a valid argument");
				}
			}

			if(cmd.hasOption("m")){
				String mode = cmd.getOptionValue("m");
				if(mode.length() == 1) {
					listSum = Character.toLowerCase(mode.charAt(0));
                    if(!((listSum == 's' | listSum == 'l')))
    					throw new ParseException("Argument "+mode+" is not a valid argument");
				} else {
					throw new ParseException("Argument "+mode+" is not a valid argument");
				}
			}

			String[] leftoverArgs = cmd.getArgs();
            if (leftoverArgs.length != 1)
            	throw new IllegalArgumentException("Invalid number of arguments. Expected a single numbered argument");
            
            String argument = leftoverArgs[0]; 
			int n = Integer.parseInt(argument);
			List<Integer> sequence = fibo.fibonacciSequence(n);
			
			ListFormatter listFormatter = new ListFormatter(sequence, horizontalVertical, directInverse, listSum);
			String output = listFormatter.formattedList();

			if(cmd.hasOption("f")){
				String fileName = cmd.getOptionValue("f");
				TxtFileWriter fileManager = new TxtFileWriter(fileName);
				fileManager.writeLine("fibo<"+n+">:");
				fileManager.writeLine(output);
				fileManager.close();
				System.out.println("fibo<" + n + ">: saved in "+fileName+".txt");
			}else{
				System.out.println("fibo<" + n + ">:" + output);
			}

		} catch (NumberFormatException e) {
			System.out.println("Error: Argument must be an integer.");
			System.exit(1);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		} catch (ParseException e){
			System.out.println("Error: " + e.getMessage());
			formatter.printHelp("fibo", options);
		} catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
	}
}