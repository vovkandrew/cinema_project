package cinema.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    private static final String EMAIL_PATTERN = "^.+@.*";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return (email != null)
                && email.matches(EMAIL_PATTERN)
                && (email.length() >= 10)
                && (email.length() <= 30);
    }
}
