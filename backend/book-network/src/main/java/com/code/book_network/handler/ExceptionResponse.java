package com.code.book_network.handler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionResponse {

    private Integer businessErrorCode;
    private String businessErrorDescription;
    private String error;
    private Set<String> validationsErrors;
    private Map<String, String> errors;


    public ExceptionResponse(Integer businessErrorCode, String businessErrorDescription, String error, Set<String> validationsErrors, Map<String, String> errors) {
        this.businessErrorCode = businessErrorCode;
        this.businessErrorDescription = businessErrorDescription;
        this.error = error;
        this.validationsErrors = validationsErrors;
        this.errors = errors;
    }

    public ExceptionResponse() {
    }

    public Integer getBusinessErrorCode() {
        return businessErrorCode;
    }

    public void setBusinessErrorCode(Integer businessErrorCode) {
        this.businessErrorCode = businessErrorCode;
    }

    public String getBusinessErrorDescription() {
        return businessErrorDescription;
    }

    public void setBusinessErrorDescription(String businessErrorDescription) {
        this.businessErrorDescription = businessErrorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Set<String> getValidationsErrors() {
        return validationsErrors;
    }

    public void setValidationsErrors(Set<String> validationsErrors) {
        this.validationsErrors = validationsErrors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public static class Builder {
        private Integer businessErrorCode;
        private String businessErrorDescription;
        private String error;
        private Set<String> validationsErrors;
        private Map<String, String> errors;

        public Builder businessErrorCode(Integer code) {
            this.businessErrorCode = code;
            return this;
        }

        public Builder businessErrorDescription(String description) {
            this.businessErrorDescription = description;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public Builder validationsErrors(Set<String> validationsErrors) {
            this.validationsErrors = validationsErrors;
            return this;
        }

        public Builder errors(Map<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public ExceptionResponse build() {
            return new ExceptionResponse(
                    businessErrorCode,
                    businessErrorDescription,
                    error,
                    validationsErrors,
                    errors
            );
        }
    }
}
