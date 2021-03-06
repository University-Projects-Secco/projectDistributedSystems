package it.polimi.cs.ds.distributed_storage.exceptions;

import lombok.Getter;

public class ParsingException extends Exception {

    @Getter
    private final String unexpectedCommand;

    public ParsingException(String unexpectedCommand){
        this(unexpectedCommand, null);
    }

    public ParsingException(String unexpectedCommand, Throwable cause){
        super("Unexpected command: " + unexpectedCommand, cause);
        this.unexpectedCommand = unexpectedCommand;
    }

}
