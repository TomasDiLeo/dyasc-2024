package ar.edu.untref.dyasc;

import java.util.List;
import java.util.Collections;
import org.apache.commons.cli.*;

public class Ejecutable {
	public static void main(String[] args) {
		Options options = new Options();
		Option optionO = Option.builder("o")
		                        .hasArg()
		                        .desc("Describes how the values are presented. An h for horizontal or a v for vertical followed by a d for direct or a i for inverse. Example -o=hd")
		                        .required(false)
		                        .valueSeparator()
		                        .build();
		options.addOption(optionO);
		
		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		FibonacciSequence fibo = new FibonacciSequence();
		
		try {
			CommandLine cmd = parser.parse(options, args);
			char horizontalVertical = 'h';
            char directInverse = 'd';
			
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

			String[] leftoverArgs = cmd.getArgs();
            if (leftoverArgs.length != 1)
            	throw new IllegalArgumentException("Invalid number of arguments. Expected a single numbered argument");
            
            String argument = leftoverArgs[0]; 
			int n = Integer.parseInt(argument);
			List<Integer> sequence = fibo.fibonacciSequence(n);
			
			String breakLine = " ";
			if(horizontalVertical == 'v') breakLine = "\n";
			if(directInverse == 'i') Collections.reverse(sequence);
			
			String output = "";
			for(Integer number : sequence) {
				output += breakLine + number;
			}
			
			System.out.println("fibo<" + n + ">:" + output);
		} catch (NumberFormatException e) {
			System.out.println("Error: Argument must be an integer.");
			System.exit(1);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			formatter.printHelp("fibo", options);
		}
	}
}
