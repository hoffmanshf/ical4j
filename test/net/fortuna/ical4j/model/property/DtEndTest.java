/*
 * $Id$
 *
 * Created on 30/06/2005
 *
 * Copyright (c) 2005, Ben Fortuna
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 *  o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.fortuna.ical4j.model.property;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.parameter.Value;
import junit.framework.TestCase;

/**
 * @author Ben Fortuna
 *
 */
public class DtEndTest extends TestCase {
    
    private static Log log = LogFactory.getLog(DtEndTest.class);

    /*
     * Class under test for validation()
     */
    public void testValidation() throws Exception {
        DtEnd dtEnd = new DtEnd(new DateTime());
        dtEnd.getParameters().add(Value.DATE);
        
        // test validation..
        log.info(dtEnd);
        try {
            dtEnd.validate();
            fail("Should throw ValidationException");
        }
        catch (ValidationException ve) {
            log.error("Exception thrown", ve);
        }
        
        //
        dtEnd.getParameters().add(Value.DATE_TIME);
        log.info(dtEnd);
        dtEnd.validate();
        
        //
        dtEnd.setUtc(true);
        log.info(dtEnd);
        dtEnd.validate();
        
        //
        dtEnd.setDate(new Date());
        log.info(dtEnd);
        try {
            dtEnd.validate();
            fail("Should throw ValidationException");
        }
        catch (ValidationException ve) {
            log.error("Exception thrown", ve);
        }
        
        //
        dtEnd.getParameters().add(Value.DATE);
        log.info(dtEnd);
        dtEnd.validate();
    }

}