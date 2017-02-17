package org.travelbywheels.jsf.common.beans.custom.validators;

import java.util.Map;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.validate.ClientValidator;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 28/11/2015
 * Time: 17:21
 * Copyright TravelByWheels.
 */

@FacesValidator("custom.emailValidator")
public class CustomEmailValidator implements Validator, ClientValidator {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CustomEmailValidator.class);

    private Pattern pattern;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public CustomEmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value == null) {
            return;
        }

        if(!pattern.matcher(value.toString()).matches()) {
            LOG.info("Invalid email : " + value);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, value + " is not a valid email;",""));
        }
    }

    public Map<String, Object> getMetadata() {
        return null;
    }

    public String getValidatorId() {
        return "custom.emailValidator";
    }
}
