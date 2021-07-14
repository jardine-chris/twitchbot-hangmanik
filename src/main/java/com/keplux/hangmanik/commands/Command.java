package com.keplux.hangmanik.commands;

public class Command {

    private String input;
    private String[] inputPieces;

    private final String prefix = "-hm ";

    public Command(String input) {
        this.input = input.toLowerCase();
        inputPieces = this.input.split(" ");
    }

    /**
     * Check whether or not the <code>Command</code> is a valid action for the
     * game. Valid commands include:
     * <i>-hm help</i>
     * <i>-hm guess r</i>
     * <i>-hm solve technology</i>
     * @return True if the <code>Command</code> is valid, false otherwise.
     */
    public ICommand parse() {
        // Obviously invalid commands.
        if (!input.startsWith(prefix) || inputPieces.length < 2 || inputPieces.length > 3) {
            return null;
        }

        // Store the second part of the input String as the command.
        String command = inputPieces[1];

        // Valid commands
        if (inputPieces.length == 2 && command.equals("help")) {
            return new HelpCommand(inputPieces);
        }

        if (inputPieces.length == 3 && (command.equals("guess"))) {
            return new GuessCommand(inputPieces);
        }

        if (inputPieces.length == 3 && (command.equals("solve"))) {
            return new SolveCommand(inputPieces);
        }
        return null;
    }
}
