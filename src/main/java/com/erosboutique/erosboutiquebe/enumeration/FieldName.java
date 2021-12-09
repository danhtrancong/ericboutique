package com.erosboutique.erosboutiquebe.enumeration;

public enum FieldName {
    userName("The username should not be empty", "The username should be in email format"), password("The password should not be empty", "The password should have length from 8 characters, include lower, upper case and special character"), roles("List roles of user should not be empty", null);

    private String emptyMessage;

    private String validationMessage;

    FieldName(String emptyMessage, String validationMessage){
        this.emptyMessage = emptyMessage;
        this.validationMessage = validationMessage;
    }

    public String getEmptyMessage(){
        return emptyMessage;
    }

    public String getValidationMessage() { return validationMessage; }
}
