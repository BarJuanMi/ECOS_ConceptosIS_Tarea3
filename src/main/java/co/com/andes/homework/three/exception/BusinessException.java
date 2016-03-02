/****************************************************************************
 * Copyright (c) 2011 Tigo (MIC), Inc. All rights reserved.
 **************************************************************************** 
 *
 * This file contains trade secrets of Tigo (MIC). No part may be reproduced or transmitted in any
 * form by any means or for any purpose without the express written permission of Tigo (MIC).
 */
package co.com.andes.homework.three.exception;

import java.io.Serializable;

/**
 * The Class BusinessException.
 *
 * @author Cesar Augusto Zambrano Aragon - cesar.zambrano@tigo.com.co ColombiaMovil(TIGO) -
 *         Informatica &amp; Tecnologia
 * @version CMFramework (28/12/2011)
 */
public class BusinessException extends Exception implements Serializable {

    private String errorCode = "99";

    /**
     * Author: Cesar Augusto Zambrano Aragon - cesar.zambrano@tigo.com.co
     * ColombiaMovil(TIGO) - Colombiamovil (TIGO) </p> Instancia un nuevo
     * business exception. </p>
     *
     * @since CMFramework (28/12/2011)
     */
    public BusinessException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Author: Cesar Augusto Zambrano Aragon - cesar.zambrano@tigo.com.co
     * ColombiaMovil(TIGO) - Colombiamovil (TIGO) </p> Instancia un nuevo
     * business exception. </p>
     *
     * @param message the message
     * @since CMFramework (28/12/2011)
     */
    public BusinessException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public BusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        // TODO Auto-generated constructor stub
    }

    /**
     * Author: Cesar Augusto Zambrano Aragon - cesar.zambrano@tigo.com.co
     * ColombiaMovil(TIGO) - Colombiamovil (TIGO) </p> Instancia un nuevo
     * business exception. </p>
     *
     * @param cause the cause
     * @since CMFramework (28/12/2011)
     */
    public BusinessException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
}
