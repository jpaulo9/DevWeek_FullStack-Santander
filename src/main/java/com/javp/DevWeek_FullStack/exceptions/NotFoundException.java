package com.javp.DevWeek_FullStack.exceptions;

import com.javp.DevWeek_FullStack.util.MessageUtils;

public class NotFoundException extends RuntimeException {

        public NotFoundException(){
            super (MessageUtils.NO_RECORDS_FOUND);

        }

}
