package b.orrar.exceptions;

public class ModelNotFoundException extends RuntimeException {
    
    public ModelNotFoundException(String message){
        super(message);
    }
}
