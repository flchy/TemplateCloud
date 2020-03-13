package com.flchy.cloud.exception;


import com.flchy.cloud.enums.BaseEWarning;
import com.flchy.cloud.enums.EWarning;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private EWarning warning;

    public BusinessException(EWarning warning) {
        super(warning.getName());
        this.warning = warning;
    }

    public BusinessException(EWarning warning, String message) {
        super(message);
        this.warning = warning;
    }

    public BusinessException(String message) {
        super(message);
        this.warning = BaseEWarning.Error;
        this.warning.setName(message);
    }

    public EWarning getWarning() {
        return warning;
    }
}
