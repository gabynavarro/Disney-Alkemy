package  com.alkemy.Disney.auth.exception;

public class ParamNotFound extends RuntimeException {
    public ParamNotFound(String  error){
        super(error);
    }
}
