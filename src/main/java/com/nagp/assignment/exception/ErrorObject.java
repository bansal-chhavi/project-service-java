package com.nagp.assignment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject {
    
    /** The error code. */
    private String errorCode;
    
    /** The error description. */
    private String errorDescription;

}
